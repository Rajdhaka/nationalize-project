package com.geekster.nationalize;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class NationalizeApplication {

	public static void main(String[] args)throws Exception {
		URL getUrl= new URL("https://api.nationalize.io/?name=nathaniel");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int respondCode=connection.getResponseCode();
		if(respondCode==200){
			BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseData= new StringBuilder();
			String readLine=null;
			while((readLine=in.readLine())!=null){
				responseData.append(readLine);}
			in.close();
			JSONObject nationalizeSData= new JSONObject(responseData.toString());
			System.out.println(nationalizeSData.toString(1));

		}
		else{
			System.out.println("This is not valid URL "+respondCode);
		}
	}

}
