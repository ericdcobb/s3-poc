package com.levelsbeyond.download;

import java.net.URL;
import java.util.Date;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3DownloadServiceImpl implements S3DownloadService {

	final AmazonS3 s3Client;
	final URLDownloadService urlDownloadService;

	public S3DownloadServiceImpl(AmazonS3 s3Client, URLDownloadService urlDownloadService) {
		this.s3Client = s3Client;
		this.urlDownloadService = urlDownloadService;
	}

	@Override
	public void downloadFile(String bucketName, String objectKey, String path) {
		Date expiration = getDate();
		URL s = getUrl(bucketName, objectKey, expiration);
		urlDownloadService.downloadFromUrl(s, path);
	}

	private Date getDate() {
		Date expiration = new Date();
		long msec = expiration.getTime();
		msec += 1000 * 60 * 60; // 1 hour.
		expiration.setTime(msec);
		return expiration;
	}

	private URL getUrl(String bucketName, String objectKey, Date expiration) {
		GeneratePresignedUrlRequest generatePresignedUrlRequest;

		generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);
		generatePresignedUrlRequest.setMethod(HttpMethod.GET);
		generatePresignedUrlRequest.setExpiration(expiration);

		URL s = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
		System.out.println(String.format("Generated Presigned URL: %n %S", s.toString()));
		return s;
	}
}
