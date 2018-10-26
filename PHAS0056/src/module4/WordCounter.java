package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
	
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}
	
	public static int countWordsInResource(BufferedReader dataAsBR) {
		
		Scanner s = new Scanner(dataAsBR);
		int n = 0;
		
		while(s.hasNext()) {
			
		}
	}


}
