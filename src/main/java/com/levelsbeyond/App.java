package com.levelsbeyond;

import java.util.Map;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.levelsbeyond.download.S3DownloadService;
import com.levelsbeyond.download.S3DownloadServiceImpl;
import com.levelsbeyond.download.URLDownloadService;
import com.levelsbeyond.download.URLDownloadServiceImpl;

public class App
{
	public static void main(String[] args)
	{
		Map<String, String> env = System.getenv();

		//Build Dependencies
		AWSCredentials credentials = new BasicAWSCredentials(env.get("S3_ACCESS_KEY"), env.get("S3_SECRET_KEY"));
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		URLDownloadService urlDownloadService = new URLDownloadServiceImpl();
		S3DownloadService downloadService = new S3DownloadServiceImpl(s3Client, urlDownloadService);

		downloadService.downloadFile("lb-cloud-test", "NASCAR Hightlight - Homestead.mov", "/Users/ericcobb/s3_output/test.mov");

	}
}
