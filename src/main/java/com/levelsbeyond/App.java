package com.levelsbeyond;

import java.io.IOException;
import java.util.Map;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.levelsbeyond.common.URLTransferService;
import com.levelsbeyond.common.URLTransferServiceImpl;
import com.levelsbeyond.download.S3TransferService;
import com.levelsbeyond.download.S3TransferServiceImpl;

public class App
{
	public static void main(String[] args)
	{
		Map<String, String> env = System.getenv();

		//Build Dependencies
		BasicSessionCredentials credentials = new BasicSessionCredentials(env.get("S3_ACCESS_KEY"), env.get("S3_SECRET_KEY"), env.get("S3_SESSION_TOKEN"));
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		URLTransferService urlTransferService = new URLTransferServiceImpl();
		S3TransferService s3TransferService = new S3TransferServiceImpl(s3Client, urlTransferService);

		if (args.length == 0) {
			printUsage();
			return;
		}

		if (args[0].equalsIgnoreCase("download")) {
			if (args.length != 4) {
				printUsage();
			}
			try {
				s3TransferService.downloadFile(args[1], args[2], args[3]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (args[0].equalsIgnoreCase("upload")) {
			if (args.length != 4) {
				printUsage();
			}
			s3TransferService.upload(args[1], args[2], args[3]);
		}
	}

	public static void printUsage() {
		System.out.println("Usage:");
		System.out.println("s3transfer [ download ] <bucket name> <object key> <file path>");
	}
}
