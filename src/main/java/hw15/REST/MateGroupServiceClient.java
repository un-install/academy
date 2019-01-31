package hw15.REST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.ws.rs.core.Response.Status;

/**
 * @author spasko
 */
public class MateGroupServiceClient {
    public static void main(String[] args) {
        try {

            HttpURLConnection conn = setTeacher("18122018/teacher/");
            showInfo(conn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showInfo(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != Status.OK.getStatusCode()
                && conn.getResponseCode() != Status.ACCEPTED.getStatusCode()) {
            System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }

    private static HttpURLConnection setTeacher(String pathParam)
            throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        String input = "{\"name\": \"Sheldon\", \"surname\": \"Cooper\", \"yearOfBorn\": 1997, \"salary\": 2000}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        return conn;
    }
}