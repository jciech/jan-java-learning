package MockExam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.*;
import java.util.*;

public class FlightRaw {

	String flightCode, originCode, destCode;
	LocalDateTime departureTime, arrivalTime;
	double cost;

	public static ArrayList<FlightRaw> listfromCSV(String string) {

		ArrayList<FlightRaw> dummyList = new ArrayList<FlightRaw>();

		try {
			BufferedReader br = brfromURL(string);
			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);
				s.useDelimiter(", ");
				while (s.hasNext()) {
					FlightRaw dummyFlight = new FlightRaw();
					dummyFlight.setFlightCode(s.next());
					dummyFlight.setOriginCode(s.next());
					dummyFlight.setDestCode(s.next());
					dummyFlight
							.setDepartureTime(LocalDateTime.of(LocalDate.parse(s.next()), LocalTime.parse(s.next())));
					dummyFlight.setArrivalTime(LocalDateTime.of(LocalDate.parse(s.next()), LocalTime.parse(s.next())));
					dummyFlight.setCost(Double.parseDouble(s.next()));
					dummyList.add(dummyFlight);
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dummyList;
	}

	// Method to create BufferedReader object from a file at a URL
	public static BufferedReader brfromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}

	@Override
	public String toString() {
		return "FlightRaw [flightCode=" + flightCode + ", originCode=" + originCode + ", destCode=" + destCode
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", cost=" + cost + "]";
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getOriginCode() {
		return originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	public String getDestCode() {
		return destCode;
	}

	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
