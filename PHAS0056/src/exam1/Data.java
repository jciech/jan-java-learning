package exam1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	private int Games, Att, RuYds, RuTD, Tgt, Rec, ReYds,ReTD, Fmb;
	private String Name, Team, Pos;

	// Class constructor: sets all int type values
	public Data(String Name, String Team, String Pos, int Games, int Att, int RuYds, int RuTD, int Tgt, int Rec, int ReYds, int ReTD, int Fmb) {
		this.Name = Name;
		this.Team = Team;
		this.Pos = Pos;
		this.Games = Games;
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

	//Method for retrieving Games variable
	
	public int getGames() {
		return this.Games;
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
	
	public String toString() {
		String datString = "Name: "+this.Name+"; Team:"+this.Team+"; Position:"+this.Pos+"; Games:"+this.Games+"; Rushing Attempts:"+this.Att+"; Rushing Yards:"+this.RuYds+"; Rushing Touchdowns:"+this.RuTD+"; Targeted:"+this.Tgt+"; Receptions:"+this.Rec+"; Recieving Yards:"+this.ReYds+"; Recieving Touchdowns:"+this.ReTD+"; Fumbles:"+this.Fmb;
		return datString;
	}
	
}
