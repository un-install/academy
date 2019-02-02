package lesson16.rest;

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
			HttpURLConnection conn = getMateGroup();
			showInfo(conn);

			conn = addStudent("18122018/students");
			showInfo(conn);

		//	conn = deleteStudent("18122018/students/Stefan/");
		//	showInfo(conn);

			conn = updateStudent("18122018/students/update/Stefan?name=Abraham");
			showInfo(conn);

			conn = getHrs("18122018/hrs/");
			showInfo(conn);

			conn = getHr("18122018/hrs/1");
			showInfo(conn);

			conn = addHr("18122018/hrs");
			showInfo(conn);

			conn = deleteHr("18122018/hrs/1");
			showInfo(conn);

			conn = updateStartWorkYear("18122018/hrs/4/start-work-year?start-work-year=2000");
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

	private static HttpURLConnection addStudent(String pathParam)
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json");
		String input = "{\"name\": \"Iza\",\"yearOfBorn\": 1997	}";

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		return conn;
	}

	private static HttpURLConnection getMateGroup() throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/18122018");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private static HttpURLConnection deleteStudent(String pathParam) throws  MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private static HttpURLConnection updateStudent(String pathParam) throws  MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private static HttpURLConnection getHrs(String pathParam) throws IOException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}
	private static HttpURLConnection getHr(String pathParam) throws IOException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private static HttpURLConnection addHr(String pathParam)
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json");
		String input = "{\"name\": \"Eric\",\"surname\": \"Clapton\",\"yearOfBorn\": 1997, \"personId\": 4, \"startWorkYear\": 2007	}";

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		return conn;
	}

	private static HttpURLConnection deleteHr(String pathParam) throws  MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}

	private static HttpURLConnection updateStartWorkYear(String pathParam) throws  MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/json");
		return conn;
	}
}
