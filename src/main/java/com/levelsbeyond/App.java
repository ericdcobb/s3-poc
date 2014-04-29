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

		if (args.length == 0) {
			printUsage();
			return;
		}

		if (args[0].equalsIgnoreCase("download")) {
			if (args.length != 4) {
				printUsage();
			}
			downloadService.downloadFile(args[1], args[2], args[3]);
		}
	}

	public static void printUsage() {
		System.out.println("Usage:");
		System.out.println("s3transfer [ download ] <bucket name> <object key> <file path>");
	}
}
