package script;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteAccountIdRunner {
    public static void main(String[] args) {
        String[] accountIds = {"2c9b808283d55409018432638a6c0ab0",
                "2c9b808783561b21018359f4abd00077",
                "2c9b808782dd9d260182e9c91480003d",
                "2c9b808c824d2b700182c6abed180895",
                "2c9b808a81fc44930181fc7818730008",
                "2c9b808d813d0713018172400d150469",
                "2c9b8084808472e5018085078f9d0010",
                "2c9b808b7ff6292f017ff65cbe0e0006",
                "2c9b808b7f7824a1017ff4f7313308cb",
                "2c9b80847f94327f017faefa1491017b",
                "2c9b80877f10989a017f13b5b803001f",
                "ff8080817ed5e54d017eeaa36ddd02d5",
                "ff8080817ec4510e017ec571312e0033",
                "ff8080817e37a553017eb213ba3c0d0a",
                "ff8080817e37a553017e8dfc6e9009a3",
                "ff8080817e7686fd017e7d66119200e3",
                "ff8080817e37a546017e7362ac9407fd",
                "ff8080817e59186b017e5a9df8e60042",
                "ff8080817e37a553017e54efa935051a",
                "ff8080817e4e4c16017e51be4ba90093",
                "ff8080817e37a546017e4b2fe95d0449",
                "ff8080817de2ec33017e270901ec0411",
                "ff8080817ce655dc017ce66d60a20000",
                "ff8080817ccf683e017cda0e5a16007c",
                "ff8080817c591ff8017c5b7a00781ab0"};
        // Add more accountIds as needed

        String baseUrl = "https://my.insideview.com/webclient/account/";

        for (String accountId : accountIds) {
            try {
                // Create the URL for the DELETE request
                URL url = new URL(baseUrl + accountId);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");

                // Set headers as needed
                connection.setRequestProperty("authority", "my.insideview.com");
                connection.setRequestProperty("accesstoken", "eyJraWQiOiJkUVFOc1RGUy1DWDdaMnZ1eWZUNzdVMVM1cHFFenNSc2IzTDlzWVJnbEJFIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULmRjMUdFdVlKdE96ak9jS21Mdy1Ub3lBa1k5Q29pSk4yZ3VOcTBXeVNoRzgiLCJpc3MiOiJodHRwczovL2F1dGhlbnRpY2F0aW9uLmRlbWFuZGJhc2UuY29tL29hdXRoMi9hdXM3ZnU3bThrRGo5MFo1MzJwNyIsImF1ZCI6ImFwaTovL21haW4iLCJpYXQiOjE2OTUzNjY2NDQsImV4cCI6MTY5NTM3MDI0NCwiY2lkIjoiMG9hODVzejNmNUk4TlB1SVMycDciLCJ1aWQiOiIwMHVkM2s2ajF3OU1SdDZPZzJwNyIsInNjcCI6WyJlbWFpbCIsInByb2ZpbGUiLCJvcGVuaWQiXSwiYXV0aF90aW1lIjoxNjk1MzY2NjM4LCJzdWIiOiJwZHdpdmVkaUBkZW1hbmRiYXNlLmNvbSJ9.ZT_NoZxp_SSR1ZmZVbobkWN-GNanein25_i14WkX4OYYbFWEUGTo9bp3yJ8Ty39CmWG1gBUTKP-G-tYUbP_0xXd7DC-qxZwPrr73dIWBabqRr38p2dK16Ag03VJLW8xYaE7KcZEk5Jy9antPgAcnZHf7xcahB538Bvj5PzwG1yn2HB2IhWzFXGHMV_rtPKR867UUfFgy5dGuN5zNTkMoqZZNFTMafJG-vk01K3t4A9Grom5T_KTYsIU51RC-c3tGM4074BqNUKBZk_MVC3kFkJUx1C7SLHW3i8UDKXHPxEhnNy7vmpI4qlkcPNBsHtOPSRPZ0vHvDoCt_voKsLGhJQ"); // Replace with your access token
                connection.setRequestProperty("accept", "*/*");
                // Add other headers as needed

                // Get the response code after sending the DELETE request
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("DELETE request for accountId " + accountId + " was successful.");
                } else {
                    System.out.println("DELETE request for accountId " + accountId + " failed with response code: " + responseCode);
                }

                // Close the connection
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

