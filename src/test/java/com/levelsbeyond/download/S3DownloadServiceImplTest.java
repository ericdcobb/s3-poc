package com.levelsbeyond.download;

import static org.fest.assertions.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.amazonaws.services.s3.AmazonS3;
import com.levelsbeyond.download.mock.MockAmazonS3;
import junit.framework.TestCase;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3DownloadServiceImplTest extends TestCase {

	public static String bucketName = "lb-cloud-test";
	public static String objectKey = "NASCAR Hightlight - Homestead.mov";

	public void testDownload() throws IOException {

		AmazonS3 mockS3 = new MockAmazonS3();
		S3DownloadService downloadService = new S3DownloadServiceImpl(mockS3);
		File output = File.createTempFile("output", ".txt");
		downloadService.downloadFile(bucketName, objectKey, output.getAbsolutePath());

		String expectedOutput = new String(readFully(this.getClass().getResourceAsStream("/akins.txt")));
		String actualOutput = new String(readFully(new FileInputStream(output)));
		assertThat(actualOutput).isEqualTo(expectedOutput);

	}

	public static byte[] readFully(InputStream input) throws IOException
	{
		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((bytesRead = input.read(buffer)) != -1)
		{
			output.write(buffer, 0, bytesRead);
		}
		return output.toByteArray();
	}

}
