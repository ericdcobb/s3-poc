#S3-POC

##Overview

Demonstration of using a separate service to generate Presigned URLs. Though they are in the same jar right now, the interesting part is that transfer to and from URLS is decoupled from s3 logic.

##Build and config

To build
```
mvn clean install
```

Uses two environment variables for S3 access:

* S3_ACCESS_KEY
* S3_SECRET_KEY

To Run

###Download

 ```
java -jar target/s3test-1.0-SNAPSHOT.jar download lb-cloud-test "NASCAR Hightlight - Homestead.mov" /Users/ericcobb/s3_output/test.mov
```

###Upload

```
java -jar target/s3test-1.0-SNAPSHOT.jar upload lb-cloud-test "abc.mov" /Users/ericcobb/s3_output/test.mov
```

#Links 

* http://docs.aws.amazon.com/AmazonS3/latest/dev/ShareObjectPreSignedURLJavaSDK.html
* http://docs.aws.amazon.com/AmazonS3/latest/dev/PresignedUrlUploadObject.html