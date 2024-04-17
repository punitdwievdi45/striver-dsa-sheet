package script;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class APICaller {
    private static final String API_URL = "https://authentication.demandbase.com/api/v1/users/";
    private static final String API_KEY = "SSWS 00smxHLPJbO5cdExEAwWN9yWmkfKCriQd--rc4AeeD";
    private static final String COOKIE = "JSESSIONID=B544E607959E6F7530208DC01C19C28F";

    public static void main(String[] args) {
        // We will replace this String with all userNames
        String usersString = "test2875-3@socialsellingu.com, test2875-1@socialsellingu.com, test2875-3@socialsellingu.com";
        usersString.replaceAll("\\s", "");
        String[] users = usersString.split(",");
        int callCount = 0;

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        for (String user : users) {
            if (callCount % 100 == 0 && callCount > 0) {
                System.out.println("Waiting for 1 minute...");
                try {
                    Thread.sleep(60000); // Wait for 1 minute
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            callAPI(httpClient, user.trim());
            callCount++;
        }
    }

    private static void callAPI(HttpClient httpClient, String user) {
        try {
            String password = "87Xq^P2v";
            System.out.println("Password: "+password);
            String requestBody = "{\n" +
                    "    \"credentials\": {\n" +
                    "        \"password\": {\n" +
                    "            \"value\": \"" + password + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL + user))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", API_KEY)
                    .header("Cookie", COOKIE)
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("User: " + user + ", Response Code: " + response.statusCode());
            System.out.println("Response: " + response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
