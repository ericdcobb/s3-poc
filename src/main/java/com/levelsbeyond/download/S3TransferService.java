package com.levelsbeyond.download;

import java.io.IOException;

/**
 * For downloading S3 objects using PreSigned URL- S3 credentials should only be used to generate the presigned URL.
 * Created by ericcobb on 4/28/14.
 */
public interface S3TransferService {

	public void downloadFile(String bucketName, String objectKey, String path) throws IOException;

	public void upload(String bucket, String objectKey, String path);

}
