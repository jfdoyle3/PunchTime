package com.jdeveloper.punchtime.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeUtils {

	// Input date and time separately as Strings
	// concatenate them into: 2011-01-18 07:00:00
	// Change to Unix Epoch Time
	// Write UnixEpoch Time to Database
	// Read Unix Epoch Time and convert to Java Date
	// Calculate hours.

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private static final int MILLI_TO_HOUR = 1000 * 60 * 60;
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		// String Time/Date to Unix Epoch Time
		String time1 = "2011-01-18 07:00:00";
		String time2 = "2011-01-18 15:15:00";
		
		Long unixTime1=dateToEpochTime(time1);
		Long unixTime2=dateToEpochTime(time2);
		
		String date2=epochTimeToDate(unixTime2);
		System.out.println(date2);
		
		double hours=calculateHours(unixTime1,unixTime2);
			
		System.out.println("\n\nHours: " + hours);

		
	}
	
	public static Long dateToEpochTime(String dateTime) throws ParseException {

		Date dateIn = dateTimeFormat.parse(dateTime);
		long unixTime= dateIn.getTime() / 1000L;
		
		return unixTime;
	}

	public static String epochTimeToDate(Long unixTime) {

		Date dateTime = new Date(unixTime * 1000L);
		String dateTimeFormatted = dateTimeFormat.format(dateTime);
		
		return dateTimeFormatted;
	}

	public static double calculateHours(long unixEpoch1, long unixEpoch2) throws ParseException {
		
		String time1=epochTimeToDate(unixEpoch1);
		String time2=epochTimeToDate(unixEpoch2);
		
		Date date1 = timeFormat.parse(time1);
		Date date2 = timeFormat.parse(time2);
		Double difference = (double) (date2.getTime() - date1.getTime());
		// 3,600,000 millisecond = 1 minute / 1 ms = 1.7e-05 mins / 1 mins = 60,000.0 ms
		Double hours = Math.floor(((difference / 3600000) * 100) / 100);
		return hours;
	}
	

}
