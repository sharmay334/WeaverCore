package com.stpl.pms.utility;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class ZipMultipartUtility {
    private final String boundary;
    private static final String LINE_FEED = "\r\n";
    private static final String TWO_HYPHENS = "--";
    private HttpURLConnection httpConn;
    private DataOutputStream outputStream;
 
    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     * @param requestURL
     * @param charset
     * @throws IOException
     */
    public ZipMultipartUtility(String requestURL)
            throws IOException {
        // creates a unique boundary based on time stamp
        boundary = "===" + System.currentTimeMillis() + "===";
        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestProperty("Connection", "Keep-Alive");
        httpConn.setRequestProperty("Charset", "UTF-8");
        httpConn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);
        httpConn.setRequestProperty("User-Agent", "Weaver FileUploader");
        outputStream = new DataOutputStream(httpConn.getOutputStream());
    }
 
    /**
     * Adds a form field to the request
     * @param name field name
     * @param value field value
     * @throws IOException 
     */
    public void addFormField(String name, String value) throws IOException {
        outputStream.writeBytes(TWO_HYPHENS + boundary + LINE_FEED);
        outputStream.writeBytes("Content-Disposition: form-data; name=\""+name+"\""
				+ LINE_FEED + LINE_FEED + value + LINE_FEED);
    }
 
    /**
     * Adds a upload file section to the request 
     * @param fieldName name attribute in <input type="file" name="..." />
     * @param uploadFile a File to be uploaded 
     * @throws IOException
     */
    public void addFilePart(String fieldName, File uploadFile)
            throws IOException {
    	FileInputStream fileInputStream = new FileInputStream(uploadFile);
    	outputStream.writeBytes(TWO_HYPHENS + boundary + LINE_FEED);
    	outputStream.writeBytes("Content-Disposition: form-data; name=\""+fieldName+"\";filename="
				+ uploadFile.getName() + LINE_FEED);
    	outputStream.writeBytes(LINE_FEED);
    	int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;

		// create a buffer of maximum size
		bytesAvailable = fileInputStream.available();
		bufferSize = Math.min(bytesAvailable, maxBufferSize);
		buffer = new byte[bufferSize];

		// read file and write it into form...
		bytesRead = fileInputStream.read(buffer, 0, bufferSize);
		while (bytesRead > 0) {
			outputStream.write(buffer, 0, bufferSize);
			bytesAvailable = fileInputStream.available();
			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);
		}

		// send multipart form data necesssary after file data...
		outputStream.writeBytes(LINE_FEED);
		outputStream.writeBytes(TWO_HYPHENS + boundary + TWO_HYPHENS + LINE_FEED);
		fileInputStream.close();
    }
 
    /**
     * Adds a header field to the request.
     * @param name - name of the header field
     * @param value - value of the header field
     */
//    public void addHeaderField(String name, String value) {
//        writer.append(name + ": " + value).append(LINE_FEED);
//        writer.flush();
//    }
     
    /**
     * Completes the request and receives response from the server.
     * @return a list of Strings as response in case the server returned
     * status OK, otherwise an exception is thrown.
     * @throws IOException
     */
    public String finish() throws IOException {
        StringBuilder response = new StringBuilder("");
        outputStream.flush();
        outputStream.close();
        BufferedReader inStream = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        //DataInputStream inStream = new DataInputStream(httpConn.getInputStream());
		if (inStream != null) {
			String str;
			while ((str = inStream.readLine()) != null) {
				response.append(str);
			}
			inStream.close();
		}
        return response.toString();
    }
}