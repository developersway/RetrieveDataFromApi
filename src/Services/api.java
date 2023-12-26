package Services;

import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
//import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
//import org.json.simple.parser.JSONParser;

public class api {
	
	@SuppressWarnings("deprecation")
	public void apiServices()
	{
		URL url = null;
		try {
			url = new URL("https://dummy.restapiexample.com/api/v1/employee/1");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			conn.connect();
			
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			if(responseCode == 200)
			{
				System.out.println("Ok");
				Scanner sc = new Scanner(url.openStream());
				String inline = "";
				
				while(sc.hasNext())
				{
					inline += sc.nextLine();
				}
				System.out.println(inline);
				sc.close();	
				
				JSONParser parse = new JSONParser();
				JSONObject parsedDataOb = (JSONObject)parse.parse(inline);
				System.out.println("Parse "+ parsedDataOb);
				JSONObject dataOb = (JSONObject)parsedDataOb.get("data");
				System.out.println("DataOb "+ dataOb);
				
				Long id = (Long) dataOb.get("id");
				System.out.println("value = " + id);
			}
			else
			{
				System.out.println("Not Ok");
			}
			
			conn.disconnect();
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
}
