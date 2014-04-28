package com.levelsbeyond.download;

import com.amazonaws.auth.AWSCredentials;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3DownloadServiceImpl implements S3DownloadService {

	final AWSCredentials credentials;

	public S3DownloadServiceImpl(AWSCredentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public void downloadFile(String bucketName, String objectKey, String path) {

	}
}
