package com.levelsbeyond.download.mock;

import static org.mockito.Mockito.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Date;
import java.util.List;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketPolicy;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketPolicyRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.DeleteVersionRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetBucketAclRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.GetBucketPolicyRequest;
import com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.SetBucketAclRequest;
import com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.model.VersionListing;
import com.levelsbeyond.download.S3DownloadServiceImplTest;

/**
 * Created by ericcobb on 4/28/14.
 */
public class MockAmazonS3 implements AmazonS3 {

	@Override
	public void setEndpoint(String s) {

	}

	@Override
	public void setRegion(Region region) throws IllegalArgumentException {

	}

	@Override
	public void setS3ClientOptions(S3ClientOptions s3ClientOptions) {

	}

	@Override
	public void changeObjectStorageClass(String s, String s2, StorageClass storageClass) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setObjectRedirectLocation(String s, String s2, String s3) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public ObjectListing listObjects(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public ObjectListing listObjects(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public ObjectListing listObjects(ListObjectsRequest listObjectsRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public ObjectListing listNextBatchOfObjects(ObjectListing objectListing) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public VersionListing listVersions(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public VersionListing listNextBatchOfVersions(VersionListing versionListing) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public VersionListing listVersions(String s, String s2, String s3, String s4, String s5, Integer integer)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public boolean doesBucketExist(String s) throws AmazonClientException, AmazonServiceException {
		return false;
	}

	@Override
	public List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public String getBucketLocation(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public Bucket createBucket(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public Bucket createBucket(String s, com.amazonaws.services.s3.model.Region region) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public Bucket createBucket(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public AccessControlList getObjectAcl(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public AccessControlList getObjectAcl(String s, String s2, String s3) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setObjectAcl(String s, String s2, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setObjectAcl(String s, String s2, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setObjectAcl(String s, String s2, String s3, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setObjectAcl(String s, String s2, String s3, CannedAccessControlList cannedAccessControlList)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public AccessControlList getBucketAcl(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketAcl(String s, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setBucketAcl(String s, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public ObjectMetadata getObjectMetadata(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public S3Object getObject(String s, String s2) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteBucket(String s) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public PutObjectResult putObject(String s, String s2, File file) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public PutObjectResult putObject(String s, String s2, InputStream inputStream, ObjectMetadata objectMetadata)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public CopyObjectResult copyObject(String s, String s2, String s3, String s4) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public CopyPartResult copyPart(CopyPartRequest copyPartRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void deleteObject(String s, String s2) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void deleteVersion(String s, String s2, String s3) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public BucketLoggingConfiguration getBucketLoggingConfiguration(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public BucketVersioningConfiguration getBucketVersioningConfiguration(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String s) {
		return null;
	}

	@Override
	public void setBucketLifecycleConfiguration(String s, BucketLifecycleConfiguration bucketLifecycleConfiguration) {

	}

	@Override
	public void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest) {

	}

	@Override
	public void deleteBucketLifecycleConfiguration(String s) {

	}

	@Override
	public void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest) {

	}

	@Override
	public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String s) {
		return null;
	}

	@Override
	public void setBucketCrossOriginConfiguration(String s, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {

	}

	@Override
	public void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest) {

	}

	@Override
	public void deleteBucketCrossOriginConfiguration(String s) {

	}

	@Override
	public void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest) {

	}

	@Override
	public BucketTaggingConfiguration getBucketTaggingConfiguration(String s) {
		return null;
	}

	@Override
	public void setBucketTaggingConfiguration(String s, BucketTaggingConfiguration bucketTaggingConfiguration) {

	}

	@Override
	public void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest) {

	}

	@Override
	public void deleteBucketTaggingConfiguration(String s) {

	}

	@Override
	public void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest) {

	}

	@Override
	public BucketNotificationConfiguration getBucketNotificationConfiguration(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setBucketNotificationConfiguration(String s, BucketNotificationConfiguration bucketNotificationConfiguration)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketWebsiteConfiguration(String s, BucketWebsiteConfiguration bucketWebsiteConfiguration)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteBucketWebsiteConfiguration(String s) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest)
			throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public BucketPolicy getBucketPolicy(String s) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void setBucketPolicy(String s, String s2) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteBucketPolicy(String s) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public URL generatePresignedUrl(String s, String s2, Date date) throws AmazonClientException {
		return null;
	}

	@Override
	public URL generatePresignedUrl(String s, String s2, Date date, HttpMethod httpMethod) throws AmazonClientException {
		return null;
	}

	@Override
	public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
		if (generatePresignedUrlRequest.getBucketName().equals(S3DownloadServiceImplTest.bucketName) &&
				generatePresignedUrlRequest.getKey().equals(S3DownloadServiceImplTest.objectKey) &&
				generatePresignedUrlRequest.getMethod().equals(HttpMethod.GET) &&
				generatePresignedUrlRequest.getExpiration().after(new Date())) {
			try {
				return getMockUrl(this.getClass().getResourceAsStream("/akins.txt"));
			}
			catch (IOException e) {
				throw new AmazonClientException(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public PartListing listParts(ListPartsRequest listPartsRequest) throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {

	}

	@Override
	public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest)
			throws AmazonClientException, AmazonServiceException {
		return null;
	}

	@Override
	public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
		return null;
	}

	@Override
	public void restoreObject(RestoreObjectRequest restoreObjectRequest) throws AmazonServiceException {

	}

	@Override
	public void restoreObject(String s, String s2, int i) throws AmazonServiceException {

	}

	@Override
	public void enableRequesterPays(String s) throws AmazonServiceException, AmazonClientException {

	}

	@Override
	public void disableRequesterPays(String s) throws AmazonServiceException, AmazonClientException {

	}

	@Override
	public boolean isRequesterPaysEnabled(String s) throws AmazonServiceException, AmazonClientException {
		return false;
	}

	public static URL getMockUrl(InputStream inputStream) throws IOException {
		final URLConnection mockConnection = mock(URLConnection.class);
		when(mockConnection.getInputStream()).thenReturn(
				inputStream);
		when(mockConnection.getContentLength()).thenReturn(54375547);

		final URLStreamHandler handler = new URLStreamHandler() {

			@Override
			protected URLConnection openConnection(final URL arg0)
					throws IOException {
				return mockConnection;
			}
		};
		final URL url = new URL("http://foo.bar", "foo.bar", 80, "", handler);
		return url;
	}
}
