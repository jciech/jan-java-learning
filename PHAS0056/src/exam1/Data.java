package exam1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Data {
	private int Att, RuYds, RuTD, Tgt, Rec, ReYds,ReTD, Fmb ;
	private String Name, Team, Pos;

	// Class constructor: sets all int type values
	public Data(String Name, String Team, String Pos, int Att, int RuYds, int RuTD, int Tgt, int Rec, int ReYds, int ReTD, int Fmb) {
		this.Name = Name;
		this.Team = Team;
		this.Pos = Pos;
		this.Att = Att;
		this.RuYds = RuYds;
		this.RuTD = RuTD;
		this.Tgt = Tgt;
		this.Rec = Rec;
		this.ReYds = ReYds;
		this.ReTD = ReTD;
		this.Fmb = Fmb;
	}

	// Method for retrieving Name variable
	public String getName() {
		return this.Name;
	}
	
	// Method for retrieving Team variable
	public String getTeam() {
		return this.Team;
	}
	
	// Method for retrieving Pos variable
	public String getPos() {
		return this.Pos;
	}

	// Method for retrieving Att variable
	public int getAtt() {
		return this.Att;
	}

	// Method for retrieving RuYds variable
	public int getRuYds() {
		return this.RuYds;
	}

	// Method for retrieving RuTD variable
	public int getRuTD() {
		return this.RuTD;
	}

	// Method for retrieving Tgt variable
	public int getTgt() {
		return this.Tgt;
	}

	// Method for retrieving Rec variable
	public int getRec() {
		return this.Rec;
	}	

	// Method for retrieving ReTD variable
	public int getReYds() {
		return this.ReYds;
	}

	// Method for retrieving RuTD variable
	public int getReTD() {
		return this.ReTD;
	}

	// Method for retrieving RuTD variable
	public int getFmb() {
		return this.Fmb;
	}

	// Parse data from url 
	// Throws Exception if data not parsed correctly
	public static Data fromURL(String urlName) throws Exception {

		//open data from URL
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//create array of data points
		
		
		// Instantiate Scanner from input String
		Scanner s = new Scanner(br).useDelimiter("\t");
		while (s.hasNext()) {
			String Name = s.next();
			String Team = s.next();
			String Pos = s.next();
			int Att = s.nextInt();
			int RuYds = s.nextInt();
			int RuTD = s.nextInt();
			int Tgt = s.nextInt();
			int Rec = s.nextInt();
			int ReYds = s.nextInt();
			int ReTD = s.nextInt();
			int Fmb = s.nextInt();

			return new Data(Name, Team, Pos, Att, RuYds, RuTD, Tgt, Rec, ReYds,ReTD, Fmb);
			s.nextLine();
		}
	}
}
