package edu.handong.csee.java.hw4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * This class is to write the file in option -d
 * @author seonamjin
 *
 */
public class DataWriter {

	/**
	 * This is method to write the file in option -d
	 * @param filePath
	 */
	void run(final String filePath) {

		String fileName = Main.pageURL.toString();
		fileName = fileName.substring(fileName.indexOf("www"));
		System.out.println("\nComplete to make the "+fileName+".html");
		

		try {

			   OutputStreamWriter writer1=new OutputStreamWriter(new FileOutputStream(Main.outputPath+"/"+fileName.concat(".html")));
			   for(String s: Main.list){
			    writer1.write(s);
			    writer1.flush();
			   }
			   writer1.close();
			   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


        
		
	}

}

