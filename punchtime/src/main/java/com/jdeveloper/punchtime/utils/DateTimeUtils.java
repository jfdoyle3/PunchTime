package com.jdeveloper.punchtime.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeUtils {

	
	// TODO delete this when finished.
	public static void main(String[] args) throws ParseException {

	//splitDateTime();
//		inputDate();
//		System.out.println(inputTime("20:31:00","10:31:00"));
		
	//	sqlDateTime();
		
		java.util.Date date=new java.util.Date();
		System.out.println(date.getTime());
	
	}
	
	public static void sqlDateTime() {
		
		
		try{

			// Connect to Database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datetime","root","root");
			
			// Instantiate Java's Date
			java.util.Date date=new java.util.Date();
			
			// Instantiate SQL Date to Java's Date
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			
			// Instantiate SQL TimeStamp to Java's Date to get Time
			java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
			
		//	java.sql.Time sqlTime=new java.sql.Time(date.getTime());
			
			// Prepare a SQL statement for writing to Database
			PreparedStatement ps=con.prepareStatement("insert into record (date,time) values(?,?)");
			
			// Set Date
			ps.setDate(1,sqlDate);
			
			// Set Time
			ps.setTimestamp(2,sqlTime);
			
			
		//	ps.setTime(2,sqlTime);
			
			// Execute SQL - Write to Database
			ps.executeUpdate();
			
			// Close Statement
			ps.close();
			
			// Close Connection
			con.close();
			
			
			System.out.println("Written to database");
			}catch(Exception e){
			e.printStackTrace();
			}	
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
	
	public static Double calculateDailyHours(String time1, String time2) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		Double difference = (double) (date2.getTime() - date1.getTime());
		//  3,600,000 millisecond = 1 minute / 1 ms = 1.7e-05 mins / 1 mins = 60,000.0 ms
		Double hours=Math.floor(((difference/3600000)*100)/100);
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
