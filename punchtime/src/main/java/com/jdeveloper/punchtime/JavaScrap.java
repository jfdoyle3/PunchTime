package com.jdeveloper.punchtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class JavaScrap {

	public static void main(String[] args) throws ParseException {

	//splitDateTime();
		inputDate();
		inputTime();
		
	}
	
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
	
	public static void inputTime() throws ParseException {
		
		String time1 = "16:00:00";
		String time2 = "19:00:00";

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long difference = date2.getTime() - date1.getTime();
		long hours=difference/3600000;
		System.out.println(hours);
		
	}
	
	

}
