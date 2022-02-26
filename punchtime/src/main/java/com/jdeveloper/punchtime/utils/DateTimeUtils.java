package com.jdeveloper.punchtime.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final double MILLISECOND_TO_HOUR = 1000 * 60 * 60;

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

	public static double calculateHours(long unixEpoch1, long unixEpoch2) throws ParseException {

		Date date1 = new Date(unixEpoch1 * 1000L);
		Date date2 = new Date(unixEpoch2 * 1000L);
		Double hours = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_HOUR;

		return hours;
	}

}
