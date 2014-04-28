package com.levelsbeyond.download;

/**
 * For downloading S3 objects using PreSigned URL- S3 credentials should only be used to generate the presigned URL.
 * Created by ericcobb on 4/28/14.
 */
public interface S3DownloadService {

	public void downloadFile(String bucketName, String objectKey, String path);
}
