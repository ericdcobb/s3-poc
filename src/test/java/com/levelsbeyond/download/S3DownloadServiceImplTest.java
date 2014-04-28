package com.levelsbeyond.download;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.levelsbeyond.download.mock.MockAmazonS3;
import junit.framework.TestCase;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3DownloadServiceImplTest extends TestCase {

	public static String bucketName = "lb-cloud-test";
	public static String objectKey = "NASCAR Hightlight - Homestead.mov";

	public void testDownload() {

		AmazonS3 mockS3 = new MockAmazonS3();

		
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
