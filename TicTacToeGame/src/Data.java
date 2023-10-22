import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Data {
	
	final static String path = "dat.txt";
	HashMap<String, Integer> dat = new HashMap<String, Integer>();
	
	Data(){
		try {
			File file = new File( path );
			if( file.createNewFile() ) System.out.println( "File created." );
			else System.out.println( "File already exists. " );
			
			BufferedReader buff = new BufferedReader( new FileReader( file ) );
			String line = null;
			
			while( ( line = buff.readLine() ) != null ) { //if there is another line that is not empty
				String[] arr = line.split( ":" ); //put a part of text separated with colon into one array cell
				String name = arr[0].trim();
				Integer points = Integer.parseInt( arr[1].trim() ); //change String data to Integer
				if( !name.equals( "" ) && ( points >= 0 ) ) dat.put( name, points ); //adding elements to the HashMap
			}
			buff.close();
		}
		catch( Exception exp ){ //if the dat.txt does not exist and couldn't been created properly
			System.err.println( exp );
			System.exit( -1 ); //closes the app because there is a trouble using it
		}
		
	}
	
	protected HashMap<String, Integer> loginInfo() { //method to send created HashMap to a proper object
		return dat;
	}
	
	protected void dataSave() { //method to save all name and score data into a dat.txt file
		File file = new File( path ); //we are sure that the file exists, was created at the beginning of the program or had existed before running the program
		BufferedWriter buff;
		
		dat.put( "Loki", 450 );
		try {
			buff = new BufferedWriter( new FileWriter( file ) );
			for( Map.Entry<String, Integer> entry : dat.entrySet() ) {
				buff.write( entry.getKey() + ":" + entry.getValue());
				buff.newLine();
			}
			buff.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
