package com.levelsbeyond.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3DownloadServiceImpl implements S3DownloadService {

	final AmazonS3 s3Client;

	public S3DownloadServiceImpl(AmazonS3 s3Client) {
		this.s3Client = s3Client;
	}

	@Override
	public void downloadFile(String bucketName, String objectKey, String path) {
		java.util.Date expiration = new java.util.Date();
		long msec = expiration.getTime();
		msec += 1000 * 60 * 60; // 1 hour.
		expiration.setTime(msec);

		GeneratePresignedUrlRequest generatePresignedUrlRequest;

		generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);

		generatePresignedUrlRequest.setMethod(HttpMethod.GET);
		generatePresignedUrlRequest.setExpiration(expiration);

		URL s = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
		System.out.println(s.toString());

		try {
			InputStream inputStream = s.openStream();
			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(new File(path));
			int count;
			while ((count = inputStream.read(buf)) != -1)
			{
				if (Thread.interrupted())
				{
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
			}
			out.close();
			inputStream.close();
			System.out.println("Completed copy.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
