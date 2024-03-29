package MockExam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageData {

	int identifier;
	double latitude, longitude;
	String speciesVolunteer, speciesExpert;
	ArrayList<String> volunteerClassifications = new ArrayList<String>();

	// Method to create BufferedReader object from a file at a URL
	public static BufferedReader brfromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}

	public static ArrayList<ImageData> classificationFromURL(String urlClassification) {

		// Creating a BufferedReader for the URL and reading each line into the
		// data needed

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		try {
			BufferedReader br = brfromURL(urlClassification);
			Scanner s = new Scanner(br);
			while (s.hasNext()) {
				ImageData dummyImage = new ImageData();
				dummyImage.setIdentifier(s.nextInt());
				s.nextInt();
				dummyImage.setSpeciesVolunteer(s.next());
				dummyList.add(dummyImage);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dummyList;
	}

	public static ArrayList<ImageData> expertFromURL(String urlExpert) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		try {
			BufferedReader br = brfromURL(urlExpert);
			Scanner s = new Scanner(br);
			while (s.hasNext()) {
				ImageData dummyImage = new ImageData();
				dummyImage.setIdentifier(s.nextInt());
				s.nextInt();
				dummyImage.setSpeciesExpert(s.next());
				dummyList.add(dummyImage);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dummyList;
	}

	public static ArrayList<ImageData> locationsFromURL(String urlLocations) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		try {
			BufferedReader br = brfromURL(urlLocations);
			Scanner s = new Scanner(br);
			while (s.hasNext()) {
				ImageData dummyImage = new ImageData();
				dummyImage.setIdentifier(s.nextInt());
				dummyImage.setLatitude(s.nextDouble());
				dummyImage.setLongitude(s.nextDouble());
				dummyList.add(dummyImage);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dummyList;

	}

	public static ArrayList<ImageData> atLeast10(ArrayList<ImageData> classification) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		for (ImageData image : classification) {
			int classifiedBy = 0;
			int dummyID = image.getIdentifier();
			for (ImageData imageNest : classification) {
				if (dummyID == imageNest.getIdentifier()) {
					classifiedBy += 1;
				}
			}
			if (classifiedBy >= 10) {
				dummyList.add(image);
			}
		}

		return dummyList;
	}

	public static ArrayList<ImageData> collectAll(ArrayList<ImageData> classification,
			ArrayList<ImageData> expert, ArrayList<ImageData> locations) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		for (ImageData exp : expert) {
			ImageData dummyImage = new ImageData();
			dummyImage.setIdentifier(exp.getIdentifier());
			dummyImage.setSpeciesExpert(exp.getSpeciesExpert());
			for (ImageData loc : locations) {
				if (dummyImage.getIdentifier() == loc.getIdentifier()) {
					dummyImage.setLatitude(loc.getLatitude());
					dummyImage.setLongitude(loc.getLongitude());
				}
			}
			for (ImageData clas : classification) {
				if (dummyImage.getIdentifier() == clas.getIdentifier()) {
					dummyImage.addToVolunteerClassifications(clas.speciesVolunteer);
				}
			}
			dummyList.add(dummyImage);
		}

		return dummyList;
	}


	public static ArrayList<ImageData> clean(ArrayList<ImageData> list) {

		ArrayList<ImageData> dummyList = new ArrayList<ImageData>();

		for (ImageData image : list) {
			if (image.volunteerClassifications.size() >= 10) {
				dummyList.add(image);
			}
		}

		return dummyList;
	}

	@Override
	public String toString() {
		return "ImageData [identifier=" + identifier + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", speciesVolunteer=" + speciesVolunteer + ", speciesExpert=" + speciesExpert
				+ ", volunteerClassifications=" + volunteerClassifications + "]" + "\n";
	}

	public int getIdentifier() {
		return identifier;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getSpeciesVolunteer() {
		return speciesVolunteer;
	}

	public String getSpeciesExpert() {
		return speciesExpert;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setSpeciesVolunteer(String speciesVolunteer) {
		this.speciesVolunteer = speciesVolunteer;
	}

	public void setSpeciesExpert(String speciesExpert) {
		this.speciesExpert = speciesExpert;
	}

	public ArrayList<String> getVolunteerClassifications() {
		return volunteerClassifications;
	}

	public void setVolunteerClassifications(ArrayList<String> volunteerClassifications) {
		this.volunteerClassifications = volunteerClassifications;
	}

	public void addToVolunteerClassifications(String species) {
		this.volunteerClassifications.add(species);
	}
}
