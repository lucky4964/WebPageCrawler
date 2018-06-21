package edu.handong.csee.java.hw4;

import java.net.MalformedURLException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.ArrayList; //Import ArrayList class

/**
 * This is the class including main method
 * 
 * @author seonamjin
 *
 */
public class Main { //Declare the class including the main method

	static String pageURL;
	static String outputPath;
	boolean verbose;
	boolean help;
	static ArrayList<String> list; //Instantiate the ArrayList with String

	/**
	 * This is the class including main method
	 * it handle cmd 
	 * 
	 * @param args -u (URL of the page to read) -d (directory of output file)
	 */
	public static void main(String[] args) { //Declare the main method


		list = new ArrayList<String>();

		Main console = new Main();
		console.run(args);
		
		DataReader read = new DataReader(Main.pageURL);
		try {
			read.readThePage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataWriter write = new DataWriter();
		write.run(outputPath);

		

	}
	/**
	 * This is the method to handle apache program
	 * it inputs the file path in accordance of option
	 * @param -u (URL of page to read) -d (directory of output file)
	 */
	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			} 

			System.out.println("You provided \"" + pageURL + "\" as the value of the option -u");	


			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + outputPath + "\" as the value of the option -d");	


			// TODO show the number of files in the path




			if(verbose) {

				// TODO list all files in the path

				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}
	}
	/**
	 * This is the method that input file directory in accordance with options
	 * @param options is defined by createOptions method
	 * @param args -u (page URL to read) -d (directory of output file) 
	 * @return if option parsing success, returns true, and if not, returns fail
	 */
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			pageURL = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	/**
	 * This method define options 
	 * we have the options, u- input file, d- output file h- help
	 * @return options
	 */
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("u").longOpt("inputPageURL")
				.desc("Set a URL address to read")
				.hasArg()
				.argName("URL of the page")
				//.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("d").longOpt("outputdir")
				.desc("Set a directory path that contains output files")
				.hasArg()
				.argName("Directory path")
				.build());


		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}
	/**
	 * This is method to be called when user input -h option
	 * @param options
	 */
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issue ";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}


}
