package com.jdeveloper.punchtime.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeUtils {

	public static void main(String[] args) throws ParseException {

	//splitDateTime();
//		inputDate();
//		System.out.println(inputTime("20:31:00","10:31:00"));
		
		


		
	}
	// UNIX Epoch Time
	public static void splitDateTime() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter Date: ex. 2017-07-05");
			String date = scan.next();
			System.out.println("Enter Time: ex. 20:31");
			String time = scan.next();
			String sourceTime = date + "T" + time + "+0:0000";
			// String sourceTimeEX = "2017-07-05T20:31+0:0000";

			// System.out.println("MyST: "+date+"T"+time+"+0:0000");

			DateTimeFormatter sourceFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm'+0:0000'");

			DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a", Locale.ENGLISH);

			String convertedTime = LocalDateTime.parse(sourceTime, sourceFormat).format(targetFormat)
					.toLowerCase(Locale.ENGLISH);

			String strDate = convertedTime.substring(0, 10);
			String strTime = convertedTime.substring(11);
			System.out.println(convertedTime);
			System.out.println("|" + strDate + "|" + "\n" + "|" + strTime + "|");
		}
	}
	
	public static void inputDate() {
		
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		// Works: res: 2022-02-13
//		int m=13;
//		int d=2;
//		int y=2022;
//		
//		LocalDate ld=LocalDate.of(y,d,m);
//		System.out.println(ld);
	}
	
	public static Double inputTime(String time1, String time2) throws ParseException {
//		String time1 = "20:31:00";
//		String time2 = "10:31:00";
		//String time1 = "07:01:03";
		//String time2 = "15:01:03";

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		Double difference = (double) (date2.getTime() - date1.getTime());
		Double hours=Math.floor(((difference/3600000)*100)/100);
	//	System.out.println(Math.floor(hours * 100) / 100);
		return hours;
	}
	
	public static void displayCurrentUnixEpochTime() {
        long ut1 = Instant.now().getEpochSecond();
        System.out.println(ut1);

        long ut2 = System.currentTimeMillis() / 1000L;
        System.out.println(ut2);

        Date now = new Date();
        long ut3 = now.getTime() / 1000L;
        System.out.println(ut3);
	}
}
