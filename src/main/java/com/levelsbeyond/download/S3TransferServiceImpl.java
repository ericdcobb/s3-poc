package com.levelsbeyond.download;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.levelsbeyond.common.S3ServiceCommon;
import com.levelsbeyond.common.URLTransferService;

/**
 * Created by ericcobb on 4/28/14.
 */
public class S3TransferServiceImpl extends S3ServiceCommon implements S3TransferService {

	final AmazonS3 s3Client;
	final URLTransferService urlTransferService;

	public S3TransferServiceImpl(AmazonS3 s3Client, URLTransferService urlTransferService) {
		this.s3Client = s3Client;
		this.urlTransferService = urlTransferService;
	}

	@Override
	public void downloadFile(String bucketName, String objectKey, String path){
		Date expiration = this.getDate();
		URL s = null;
		try {
			s = getUrl(bucketName, objectKey, expiration, s3Client, HttpMethod.GET, Files.probeContentType(FileSystems.getDefault().getPath(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		urlTransferService.downloadFromUrl(s, path);
	}

	@Override
	public void upload(String bucketName, String objectKey, String path) {
		File file = new File(path);
		Date expiration = getDate();
		URL url = null;
		try {
			url = getUrl(bucketName, objectKey, expiration, s3Client, HttpMethod.PUT, Files.probeContentType(FileSystems.getDefault().getPath(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		urlTransferService.uploadToUrl(url,  file);

	}

}
