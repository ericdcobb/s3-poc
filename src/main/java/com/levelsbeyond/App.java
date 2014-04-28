package com.levelsbeyond;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

public class App
{
	public static void main(String[] args)
	{
		Map<String, String> env = System.getenv();

		AWSCredentials credentials = new BasicAWSCredentials(env.get("S3_ACCESS_KEY"), env.get("S3_SECRET_KEY"));
		AmazonS3 s3Client = new AmazonS3Client(credentials);

		java.util.Date expiration = new java.util.Date();
		long msec = expiration.getTime();
		msec += 1000 * 60 * 60; // 1 hour.
		expiration.setTime(msec);

		GeneratePresignedUrlRequest generatePresignedUrlRequest;

		generatePresignedUrlRequest = new GeneratePresignedUrlRequest("lb-cloud-test", "NASCAR Hightlight - Homestead.mov");

		generatePresignedUrlRequest.setMethod(HttpMethod.GET);
		generatePresignedUrlRequest.setExpiration(expiration);

		URL s = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
		System.out.println(s.toString());

		try {
			InputStream inputStream = s.openStream();
			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(new File("/Users/ericcobb/s3_output/test.mov"));
			int count;
			while( (count = inputStream.read(buf)) != -1)
			{
				if( Thread.interrupted() )
				{
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
			}
			out.close();
			inputStream.close();
			System.out.println("Completed copy.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
