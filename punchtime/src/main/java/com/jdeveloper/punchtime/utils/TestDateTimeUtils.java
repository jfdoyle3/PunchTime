package com.jdeveloper.punchtime.utils;

import java.text.ParseException;

public class TestDateTimeUtils {

	public static void main(String[] args) throws ParseException {
				// Input
				String time1 = "2011-01-18 07:00:00";
				String time2 = "2011-01-18 15:15:02";
				
				System.out.println("Input:");
				System.out.println(time1);
				System.out.println(time2);
				
				// DateTime to UnixEpoch Time
				Long unixTime1 =DateTimeUtils.dateToEpochTime(time1);
				Long unixTime2 = DateTimeUtils.dateToEpochTime(time2);
				
				System.out.println("\nUnix Epoch Time");
				System.out.println(unixTime1);
				System.out.println(unixTime2);
				
				// Display UnixEpoch Time as Date/Time
				String date1 = DateTimeUtils.epochTimeToDate(unixTime1);
				String date2 = DateTimeUtils.epochTimeToDate(unixTime2);
				
				System.out.println("\nJava Date/Time");
				System.out.println(date1);
				System.out.println(date2);

				// Calculate Hours between UnixEpoch Time
				double hours = DateTimeUtils.calculateHours(unixTime1, unixTime2);

				System.out.println("\nHours Calculated: "+hours);

	}

}
