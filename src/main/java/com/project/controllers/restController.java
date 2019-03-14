package com.project.controllers;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.views.reply;
import com.rivescript.Config;
import com.rivescript.RiveScript;
@CrossOrigin
@RestController
public class restController {
	
	 @RequestMapping(value="/req", produces = "application/json")
	    public reply greeting(@RequestParam(value="query", defaultValue="hi") String name) {

		String ques = "";
		String ans = "";
		reply rep = new reply();
		if((name.toLowerCase()).contains("says:")){
			String[] stringset = name.split(",");
			String[] queset = stringset[0].split(":");
			ques = queset[1];
			String[] ansset = stringset[1].split(":");
			ans = ansset[1];
			System.out.println(ques.toLowerCase());
			System.out.println(ans);
			
			try {
				FileWriter writer = new FileWriter("brain2.rive", true);
				writer.write("\r\n"); 
				writer.write("\r\n"); 
				writer.write("+ "+ques.toLowerCase());
				writer.write("\r\n");   // write new line
				writer.write("- "+ans);
	            writer.close();
	            rep.setReply("Oh Ok. Thanks for the update!");
	            return rep;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
		// To enable UTF-8 mode, you'd have initialized the bot like:
		RiveScript bot = new RiveScript();

		// Load an individual file.
		bot.loadFile("./brain2.rive");

		// Sort the replies after loading them!
		bot.sortReplies();

		// Get a reply.
		String reply2 = bot.reply("user", name ); 
//		System.out.println(reply2);
//		if(reply2.contains("I'm not sure how to reply to that") || reply2.contains("Try asking your question a different way") || reply2.contains("Let's change the subject") ){
//			byte ptext[];
//			String value = "";
//			try {
//				ptext = name.getBytes("ISO-8859-1");
//				value = new String(ptext, "UTF-8");
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 
//			   
//			String gquery = "http://www.google.com/search?q=";
//			String adParams = "&rlz=1C1CHBF_enIN765IN765&oq=good&aqs=chrome..69i57.7454j1j8&sourceid=chrome&ie=UTF-8";
//			  StringBuilder result = new StringBuilder();
//			  System.out.println(gquery);
//		      URL url;
//			try {
//				System.setProperty("http.agent", "Chrome");
//				url = new URL(gquery+URLEncoder.encode(value) );
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.addRequestProperty("User-Agent", "Mozilla/4.76"); 
//				
//			      conn.setRequestMethod("GET");
//			      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			      String line;
//			      while ((line = rd.readLine()) != null) {
//			         result.append(line);
//			      }
//			      rd.close();
//			      System.out.println(result.toString());
//			      Document doc = Jsoup.parse(result.toString());
//			      Elements r = doc.getElementsByClass("HwtpBd");
//			      rep.setReply(r.text());
//			      return rep;
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ProtocolException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		      
//		}
//		
		rep.setReply(reply2);
		return rep;
	    }

}
