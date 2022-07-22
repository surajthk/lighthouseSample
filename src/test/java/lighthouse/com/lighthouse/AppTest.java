package lighthouse.com.lighthouse;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	  @Test
	public void testing() throws Exception {
			performLoadTest("https://www.swastikspices.com/","mobile");

	    	
	    }
	    	public void performLoadTest(String Url, String device) throws Exception {
	            URL url = new URL("https://www.googleapis.com/pagespeedonline/v5/runPagespeed?url=" + Url + "&key=" + "AIzaSyBgJMAmT9pdimF-Zm5d-5FoBIE_2m-3WBQ"
	                    + "&strategy=" + device);
	            HttpURLConnection http = (HttpURLConnection) url.openConnection();
	            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
	            BufferedReader rd = null;
	            StringBuilder sb = null;
	            String line = null;
	            rd = new BufferedReader(new InputStreamReader(http.getInputStream()));
	            sb = new StringBuilder();
	            FileWriter fWriter = new FileWriter(
	                    "./urls.json");
	            while ((line = rd.readLine()) != null) { // System.out.println(line);
	            	fWriter.write(line.toString());
	                sb.append(line);
	            }
	            fWriter.close();
	            http.disconnect();
	            JSONParser parser = new JSONParser();
	            JSONObject json = (JSONObject) parser.parse(sb.toString());
	            JSONObject entry = (JSONObject) json.get("lighthouseResult");
	            JSONObject entry2 = (JSONObject) entry.get("audits");
	          
	            JSONObject tti = (JSONObject) entry2.get("interactive");       
	            JSONObject fcp = (JSONObject) entry2.get("first-contentful-paint");
	            JSONObject lcp = (JSONObject) entry2.get("largest-contentful-paint");
	            JSONObject speedIndex = (JSONObject) entry2.get("speed-index");
	            JSONObject cli = (JSONObject) entry2.get("cumulative-layout-shift");
	            JSONObject blockTime = (JSONObject) entry2.get("total-blocking-time");

	            

	            System.out.println("Load time of website for " + device + " : " + tti.get("displayValue").toString());
	            System.out.println("FCP time of website for " + device + " : " + fcp.get("displayValue").toString());
	            System.out.println("LCP time of website for " + device + " : " + lcp.get("displayValue").toString());
	            System.out.println("Speed Index of website for " + device + " : " + speedIndex.get("displayValue").toString());
	            System.out.println("CLI of website for " + device + " : " + cli.get("displayValue").toString());
	            System.out.println("Block time of website for " + device + " : " + blockTime.get("displayValue").toString());

	        }
}
