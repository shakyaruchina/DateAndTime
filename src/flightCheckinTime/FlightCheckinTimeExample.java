package flightCheckinTime;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightCheckinTimeExample {

	public static void main(String[] args) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		
		//Leaving from San Francisco on July 20, 2013 at 7:30pm
		LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20,19,30);
		ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
		ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
		
		try {
			String out1 = departure.format(format);
			System.out.printf("Leaving: %s (%s)%n", out1 , leavingZone);
		}catch(DateTimeException exc) {
			System.out.printf("%s can't be formatted!%n", departure);
			throw exc;
			
		}
		
		//Flight is 10 hrs and 50 mins / 650minutes
		
		ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
		
		try {
			String out2 = arrival.format(format);
			System.out.printf("Arriving: %s (%s)%n", out2, arrivingZone);
		}catch(DateTimeException exc) {
			System.out.printf("%s can't be formatted! %n", arrival);
			throw exc;
		}

	}

}
