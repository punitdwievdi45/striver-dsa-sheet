package script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CurlToJavaBatch {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            // URL and headers
            String baseUrl = "https://authentication.demandbase.com/api/v1/users/";
            String acceptHeader = "application/json";
            String contentTypeHeader = "application/json";
            String authorizationHeader = "SSWS 00smxHLPJbO5cdExEAwWN9yWmkfKCriQd--rc4AeeD";
            String cookieHeader = "JSESSIONID=76AAED114FB2CE9FEE03729B3D0FA05A";



            // User emails as a comma-separated string
            String userEmails = "ebansal@socialsellingu.com,test2875-3@socialsellingu.com";
            userEmails = userEmails.replaceAll("\\s+", ""); // Remove spaces

            // Convert the comma-separated string to a list of emails
            List<String> userEmailList = Arrays.asList(userEmails.split(","));

            // Number of users and batch size
            int totalUsers = userEmailList.size();
            int batchSize = 1;

            // Calculate the number of iterations
            int iterations = totalUsers / batchSize;
            int remainder = totalUsers % batchSize;
            if (remainder > 0) {
                iterations++;
            }

            // Execute the requests
            for (int i = 0; i < iterations; i++) {
                // Create PUT requests for the current batch
                for (int j = 0; j < batchSize; j++) {
                    int userIndex = i * batchSize + j;
                    if (userIndex >= totalUsers) {
                        break;
                    }

                    String userEmail = userEmailList.get(userIndex);
                    String url = baseUrl + userEmail;

                    // Create URL object
                    URL requestUrl = new URL(url);

                    // Open connection
                    HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

                    // Set request method
                    connection.setRequestMethod("PUT");

                    // Set headers
                    connection.setRequestProperty("Accept", acceptHeader);
                    connection.setRequestProperty("Content-Type", contentTypeHeader);
                    connection.setRequestProperty("Authorization", authorizationHeader);
                    connection.setRequestProperty("Cookie", cookieHeader);

                    // Enable input and output streams
                    connection.setDoOutput(true);
                    connection.setDoInput(true);

                    String randomPassword = PasswordGenerator.generatePassword();
                    System.out.println("Random Password: "+randomPassword);
                    // Common payload
                    String payload = "{\n" +
                            "    \"credentials\": {\n" +
                            "        \"password\": {\n" +
                            "            \"value\": \"" + randomPassword + "\"\n" +
                            "        }\n" +
                            "    }\n" +
                            "}";
                    // Write payload
                    try (OutputStream outputStream = connection.getOutputStream()) {
                        outputStream.write(payload.getBytes());
                        outputStream.flush();
                    }

                    // Get response code
                    int responseCode = connection.getResponseCode();

                    // Get response body
                    BufferedReader reader;
                    if (responseCode >= 400) {
                        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    } else {
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    }

                    String line;
                    StringBuilder responseBody = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        responseBody.append(line);
                    }
                    reader.close();

                    // Print the response
                    System.out.println("User " + userEmail + ":");
                    System.out.println("Response status: " + responseCode);
                    System.out.println("Response body: " + responseBody.toString());

                    // Delay between requests (1 minute)
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
