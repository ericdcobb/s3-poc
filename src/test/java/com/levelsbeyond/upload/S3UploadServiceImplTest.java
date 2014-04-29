package com.levelsbeyond.upload;

import static com.levelsbeyond.download.S3DownloadServiceImplTest.*;
import static org.fest.assertions.Assertions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.levelsbeyond.common.URLTransferServiceImpl;
import com.levelsbeyond.download.S3TransferService;
import com.levelsbeyond.download.S3TransferServiceImpl;
import com.levelsbeyond.download.mock.MockAmazonS3;
import junit.framework.TestCase;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3UploadServiceImplTest extends TestCase {

	public static String bucketName = "lb-cloud-test";
	public static String objectKey = "test-cloud.mov";

	public void testDownload() throws IOException, InterruptedException {

		MockAmazonS3 mockS3 = new MockAmazonS3();
		S3TransferService uploadService = new S3TransferServiceImpl(mockS3, new URLTransferServiceImpl());

		File source = File.createTempFile("source", ".txt");

		byte[] buf = new byte[1024];
		OutputStream out = new FileOutputStream(source);
		int total = 0;
		int count;
		InputStream inputStream = this.getClass().getResourceAsStream("/akins.txt");
		while ((count =inputStream.read(buf)) != -1)
		{
			if (Thread.interrupted())
			{
				throw new InterruptedException();
			}
			out.write(buf, 0, count);
		}
		out.close();

		uploadService.upload(bucketName, objectKey, source.getAbsolutePath());

		String actual = new String(readFully(new FileInputStream(MockAmazonS3.output)));
		assertThat(actual).isEqualTo(new String(readFully(new FileInputStream(source))));

	}

}
