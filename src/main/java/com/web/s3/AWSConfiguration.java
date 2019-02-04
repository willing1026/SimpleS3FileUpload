package com.web.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class AWSConfiguration {
	
	@Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
	@Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;
	@Value("${cloud.aws.region.static}")
    private String region;

	@Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

	@Bean
    public AmazonS3Client amazonS3Client(AWSCredentials awsCredentials) {
		AmazonS3Client s3client = new AmazonS3Client();
		
        AmazonS3Client amazonS3Client = new AmazonS3Client(awsCredentials);
        amazonS3Client.setRegion(Region.getRegion(Regions.fromName(region)));
        return amazonS3Client;
    }
}