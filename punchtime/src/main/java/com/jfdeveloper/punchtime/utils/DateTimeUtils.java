package com.jfdeveloper.punchtime.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final double MILLISECOND_TO_HOUR = 1000 * 60 * 60;
	private static final double MILLISECOND_TO_DAY=1000*60*60*24;
	private static final double MILLISECOND_TO_MINUTE=1000*60;

	public static Long dateToEpochTime(String dateTime) throws ParseException {

		Date dateIn = dateTimeFormat.parse(dateTime);
		long unixTime = dateIn.getTime() / 1000L;

		return unixTime;
	}

	public static String epochTimeToDate(Long unixTime) {

		Date dateTime = new Date(unixTime * 1000L);
		String dateTimeFormatted = dateTimeFormat.format(dateTime);

		return dateTimeFormatted;
	}
	
	public static double calculateDays(long unixEpoch1, long unixEpoch2) throws ParseException {

		Date date1 = new Date(unixEpoch1 * 1000L);
		Date date2 = new Date(unixEpoch2 * 1000L);
		Double days = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_DAY;

		return days;
	}

	public static double calculateHours(long unixEpoch1, long unixEpoch2) throws ParseException {

		Date date1 = new Date(unixEpoch1 * 1000L);
		Date date2 = new Date(unixEpoch2 * 1000L);
		Double hours = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_HOUR;

		return hours;
	}
	
	public static double calculateMinutes(long unixEpoch1, long unixEpoch2) throws ParseException {

		Date date1 = new Date(unixEpoch1 * 1000L);
		Date date2 = new Date(unixEpoch2 * 1000L);
		Double minutes = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_MINUTE;

		return minutes;
	}
	
	// Maybe a Method for Week Number in Calendar Year.
	
	public int getDayOfWeekFromDate(Date date) {
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		int day=cal.get(Calendar.DAY_OF_WEEK);
		
		/* May want this to return a String instead of an int/byte
		 * switch(day){
			case 1-> System.out.println("Sunday");
			case 2-> System.out.println("Monday");
			case 3-> System.out.println("Tuesday");
			case 4-> System.out.println("Wednesday");
			case 5-> System.out.println("Thursday");
			case 6-> System.out.println("Friday");
			case 7-> System.out.println("Saturday");
			default->System.out.println("error - day doesn't exist");
			}
		 */
		
		return day;
	}

}
