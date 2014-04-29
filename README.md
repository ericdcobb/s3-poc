#S3-POC

##Overview

Demonstration of using a separate service to generate Presigned URLs. In the same jar right now, but the interesting part is they don't have to be and the transfer services are ignorant of s3 impls (specifically security impls).

##Build and config

To build
```
mvn clean install
```

Uses two environment variables for S3 access:

* S3_ACCESS_KEY
* S3_SECRET_KEY

To Run
 ```
java -jar target/s3test-1.0-SNAPSHOT.jar download lb-cloud-test "NASCAR Hightlight - Homestead.mov" /Users/ericcobb/s3_output/test.mov
```

#Links 

* http://docs.aws.amazon.com/AmazonS3/latest/dev/ShareObjectPreSignedURLJavaSDK.html
* http://docs.aws.amazon.com/AmazonS3/latest/dev/PresignedUrlUploadObject.html