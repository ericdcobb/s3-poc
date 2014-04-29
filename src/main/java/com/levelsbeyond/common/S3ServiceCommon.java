package com.levelsbeyond.common;

import java.net.URL;
import java.util.Date;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

/**
 * Created by ericcobb on 4/28/14.
 */
public abstract class S3ServiceCommon {
	public Date getDate() {
		Date expiration = new Date();
		long msec = expiration.getTime();
		msec += 1000 * 60 * 60; // 1 hour.
		expiration.setTime(msec);
		return expiration;
	}

	public URL getUrl(String bucketName, String objectKey, Date expiration, AmazonS3 s3Client, HttpMethod method, String contentType) {
		GeneratePresignedUrlRequest generatePresignedUrlRequest;

		generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);
		generatePresignedUrlRequest.setMethod(method);
		generatePresignedUrlRequest.setExpiration(expiration);
		generatePresignedUrlRequest.setContentType(contentType);

		URL s = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
		System.out.println(String.format("Generated Presigned URL: %n %S", s.toString()));
		return s;
	}
}
