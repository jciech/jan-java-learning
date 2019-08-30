package MockExam2;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Flight {

	String flightCode, originFull, destinationFull;
	LocalDateTime departureTime, arrivalTime;
	double cost;
	long duration;
	
	public static Flight convertToProcessed(FlightRaw flight, HashMap<String, Airport> airports) {

		Flight dummyFlight = new Flight();

		dummyFlight.flightCode = flight.flightCode;
		dummyFlight.originFull = airports.get(flight.originCode).airportFullName;
		dummyFlight.destinationFull = airports.get(flight.destCode).airportFullName;
		
		dummyFlight.departureTime = flight.departureTime;
		dummyFlight.arrivalTime = flight.arrivalTime;

		String tz1 = airports.get(flight.originCode).airportTimeZone;
		String tz2 = airports.get(flight.destCode).airportTimeZone;
		
		
		dummyFlight.cost = flight.cost;
		dummyFlight.duration =  Flight.durationFromTZs(dummyFlight.departureTime, tz1, dummyFlight.arrivalTime, tz2);
		
		return dummyFlight;
	}

	@Override
	public String toString() {
		return "Flight [flightCode=" + flightCode + ", originFull=" + originFull + ", destinationFull="
				+ destinationFull + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", cost="
				+ cost + ", duration=" + duration + "]"+"\n";
	}

	public static long durationFromTZs(LocalDateTime lt1, String zone1, LocalDateTime lt2, String zone2) {
		ZoneId z1 = ZoneId.of(zone1);
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
		ZoneId z2 = ZoneId.of(zone2);
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		return duration;
	}
}
