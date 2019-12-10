package com.stpl.pms.utility;

import java.io.File;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.stpl.pms.controller.commonMethods.CommonMethodController;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;

public class AWSWrapper {
	private static final Logger logger = Logger.getLogger(Utility.class);
    private static AmazonS3 S3_CLIENT;
    private static AmazonSimpleEmailServiceClient SES_CLIENT;

    /**
	 * A simple method for uploading files in publicly readable mode in AWS S3 bucket.
	 * 
	 * @param file the file to be uploaded.
	 * 
	 * @param path relative to content server with the complete filename.
	 * 
	 * @throws PMSException
	 */

	public static void uploadObjectPublic(File file, String path,String bucketName,String contentType)
			throws PMSException {
		TransferManager tx = null;
		Upload upload = null;
		logger.debug("---AWS S3 Uploading "+path+"---");
		try {
            if(S3_CLIENT==null)
                S3_CLIENT= (AmazonS3) CommonMethodController.getInstance().provideAWSClient((short)0,"S3");
			ObjectMetadata metaData=new ObjectMetadata();
			metaData.setContentType(contentType);
			tx = new TransferManager(S3_CLIENT);
			upload = tx.upload(new PutObjectRequest(bucketName, path, file).withCannedAcl(CannedAccessControlList.PublicRead).withMetadata(metaData));
			upload.waitForCompletion();
		} catch (Exception e) {
			e.printStackTrace();
			if(upload!=null)
				upload.abort();
			tx.shutdownNow(false);
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}finally{
			if(tx!=null)
				tx.shutdownNow(false);
		}
		logger.debug("---AWS S3 Upload complete---");
	}

	/**
	 * A simple method for uploading files in publicly readable mode in AWS S3 bucket.
	 * 
	 * @param FileItem the fileItem to be uploaded.
	 * 
	 * @param path relative to content server with the complete filename.
	 * 
	 * @throws Exception 
	 */

	public static void uploadObjectPublic(FileItem fileItem, String path,String bucketName) throws PMSException{
		try{
			File tempImage=File.createTempFile("avatar", ".tmp");
			fileItem.write(tempImage);
			uploadObjectPublic(tempImage, path,bucketName,fileItem.getContentType());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

    /**
     * Used to send Email from AWS Simple Email Service
     * @param content the HTML content string.
     * @param sub Subject of the mail.
     * @param from from address.
     * @param toEmails to addresses.
     */
	public static void sendEmail(String content, String sub, String from, String... toEmails){
        {

            // Construct an object to contain the recipient address.
            Destination destination = new Destination().withToAddresses(toEmails);

            // Create the subject and body of the message.
            Content subject = new Content().withData(sub);
            Body body = new Body().withHtml(new Content().withData(content));

            // Create a message with the specified subject and body.
            Message message = new Message().withSubject(subject).withBody(body);

            // Assemble the email.
            SendEmailRequest request = new SendEmailRequest().withSource(from)
                    .withDestination(destination).withMessage(message);
            try {
                logger.info("Attempting to send an email through Amazon SES...");
                if(SES_CLIENT==null)
                    SES_CLIENT= (AmazonSimpleEmailServiceClient) CommonMethodController.getInstance().provideAWSClient((short) 1, "SES");
                // Send the email.
                SES_CLIENT.sendEmail(request);
                logger.info("Email sent!");
            } catch (Exception ex) {
                logger.error("The email was not sent.");
                logger.error("Error message: " + ex.getMessage());
            }
        }
    }
}

//class AwsTestCaller{
//	public static void main(String[] args) throws IOException, PMSException {
//		String url="http://test.weaver.s3-ap-southeast-1.amazonaws.com/commonContent/";
//		AWSWrapper.uploadObjectPublic(new File("/home/stpl/Pictures/Screenshot from 2016-09-27 16-21-56 (another copy).png"), "temp0.png",Utility.getBucket("https://test-weaver.s3-ap-southeast-1.amazonaws.com/commonContent/"));
////		AWSWrapper.uploadObjectPublic(new File("/home/stpl/Pictures/Screenshot from 2016-09-27 16-21-56 (another copy).png"), "temp1.png");
////		AWSWrapper.uploadObjectPublic(new File("/home/stpl/Pictures/Screenshot from 2016-09-27 16-21-56 (another copy).png"), "temp2.png");
//		//		System.out.println("http://test.weaver.s3-ap-southeast-1.amazonaws.com/".contains("amazonaws"));
//	}
//}
