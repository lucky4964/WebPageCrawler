package edu.handong.csee.java.hw4;

import java.net.*;
import java.io.*;

/**
 * This is the class to read the URL
 * @author seonamjin
 *
 */
public class DataReader {
	
	String target=null;
	
	/**
	 * This is the constructor of this class
	 * @param targetURL of page to read
	 */
	public DataReader(String targetURL) {
		this.target=targetURL;
	}
	
	/**
	 * This is method to read the page and to store the script of URL
	 * @throws MalformedURLException
	 */
	public void readThePage() throws MalformedURLException {
		
        URL targetPage = new URL(target);
        BufferedReader in =null;
		try {
			in = new BufferedReader(
			new InputStreamReader(targetPage.openStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String inputLine;
        try {
			while ((inputLine = in.readLine()) != null) {
				
			    	Main.list.add(inputLine);
			    	
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return;
		
	}

}
