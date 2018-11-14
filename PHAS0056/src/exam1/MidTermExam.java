package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MidTermExam {


	public static void main(String[] args) {

		String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt";
		ArrayList<Data> fb;
		try {
			fb = fromURL(dataURL);
			System.out.println(fb.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	//Parse data from url 
	// Throws Exception if data not parsed correctly
	public static ArrayList<Data> fromURL(String urlName) throws Exception {

		//open data from URL
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		//create ArrayList of data points
		ArrayList<Data> dat = new ArrayList<Data>();

		// Instantiate Scanner from input String
		Scanner s = new Scanner(br).useDelimiter("\t");
		s.nextLine();
		s.nextLine();
		s.nextLine();
		while (s.hasNext()) {
			String Name = s.next();
			String Team = s.next();
			String Pos = s.next();
			int Games = s.nextInt();
			int Att = s.nextInt();
			int RuYds = s.nextInt();
			int RuTD = s.nextInt();
			int Tgt = s.nextInt();
			int Rec = s.nextInt();
			int ReYds = s.nextInt();
			int ReTD = s.nextInt();
			int Fmb = s.nextInt();

			Data p = new Data(Name, Team, Pos, Games, Att, RuYds, RuTD, Tgt, Rec, ReYds,ReTD, Fmb);
			dat.add(p);
			s.nextLine();

		}
		s.close();
		return dat;
	}
}