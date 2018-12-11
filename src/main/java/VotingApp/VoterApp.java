package VotingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import BlockChain.BlockChain;

public class VoterApp {
	public static void main(String[] args) throws InterruptedException {
		String publicKey;
		String privateKey;
		VoterLoginWindow loginWindow = new VoterLoginWindow();
		WindowUtils.waitTillComplete(loginWindow.f);
		String jsondata = loginWindow.response;
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(jsondata);
		String success = jsonObject.get("success").getAsString();
		String message = jsonObject.get("message").getAsString();
		if (success.matches("false")) {
			System.out.println(message);
			Thread.sleep(2000);
			System.exit(1);
		} else {
			publicKey = jsonObject.get("publicKey").getAsString();
			privateKey = jsonObject.get("privateKey").getAsString();
			System.out.println("Public key ===== \n " + publicKey);
			System.out.println("Private key ===== \n " + privateKey);
			JsonArray positions;
			try {
				URL url = new URL(Constants.BASE_URL + "/Vote");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				int response_Code = conn.getResponseCode();
				if (response_Code == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					JsonParser parser1 = new JsonParser();
					JsonObject voteFetchObject = (JsonObject) parser1.parse(response.toString());
					positions = parser1.parse(voteFetchObject.get("positions").getAsString()).getAsJsonArray();
					BlockChain chain = BlockChain.fromJSON(voteFetchObject.get("chain").getAsString());
					int balance = chain.getWalletAmount(publicKey);
					if (balance <= 0) {
						System.out.println("Already Registered!");
						return;
					}
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
