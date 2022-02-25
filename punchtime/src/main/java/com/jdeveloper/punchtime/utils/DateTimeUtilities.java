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

public class DateTimeUtilities {

	// TODO delete this when finished.
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {

		// splitDateTime();
//		inputDate();
//		System.out.println(inputTime("20:31:00","10:31:00"));

		// sqlDateTime();
		// mySQLTimeStampInput();
		// calendarToSQL();
		displayUnixEpochTime();

//		LocalDate anotherSummerDay = LocalDate.of(2016, 8, 23);
//		LocalTime anotherTime = LocalTime.of(13, 12, 45);
//		
//		System.out.println(anotherSummerDay+" "+anotherTime);
//		System.out.println("------------------------------------------\n\n");
//	    String sDate1="31/12/1998";
//	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
//	    System.out.println(sDate1+"\t"+date1);
//	    
//	    System.out.println("------------------------------------------\n\n");
//	    String strTime = "20:15:40";
//	       DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
//	       Date d = dateFormat.parse(strTime);
//	       System.out.println("Resultant Date and Time = " +sDate1 + d);
//	    System.out.println("------------------------------------------\n\n");
//	       
//	    String dateAndTime="2011-01-18 20:15:40";
//	       DateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	       Date parseTS = timeStamp.parse(dateAndTime);
//	       System.out.println("2 lines: ts: "+parseTS);
//	    
//	    String oldstring = "2011-01-18 20:15:40";
//	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(oldstring);
//	    System.out.println("1 line: "+date);
//	       

	}

	public static void mySQLTimeStampInput() throws ParseException {
		try (Scanner scan = new Scanner(System.in)) {

			// Input
//			System.out.println("Enter Date: ex. 2017-07-05");
//			String date = scan.next();
//			System.out.println("Enter Time: ex. 20:31");
//			String time = scan.next();
//			String sourceTime = date + " " + time;

			// Need to take input and convert it unix time then pass into sql timestamp
//			LocalDate anotherSummerDay = LocalDate.of(2016, 8, 23);
//			LocalTime anotherTime = LocalTime.of(13, 12, 45);
//			
//			System.out.println(anotherSummerDay+" "+anotherTime);
//			
//			System.out.println("2v: "+anotherSummerDay+" "+anotherTime);
			String oldstring = "2011-01-18 20:15:40";
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(oldstring);

			// Java DATE
			// java.util.Date utilDate = new java.util.Date();
			System.out.println("java.util.Date time    : " + date);

			// SQL TIMESTAMP
			java.sql.Timestamp sqlTS = new java.sql.Timestamp(date.getTime());
			System.out.println("java.sql.Timestamp time: " + sqlTS);

			// formatted display
			DateFormat df = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss:SSS");
			System.out.println("Date formatted         : " + df.format(date));

		}
	}

	public static void calendarToSQL() throws ClassNotFoundException, SQLException, ParseException {

		// (1) connect to the database (mysql)

		String myUrl = "jdbc:mysql://localhost/datetime";

		Connection connection = DriverManager.getConnection(myUrl, "root", "root");
		System.out.println("connection opened..");

		// (2) create a java timestamp object that represents the current time (i.e., a
		// "current timestamp")
//		    Calendar calendar = Calendar.getInstance();
//		    calendar.set(2022,01,05);

		String oldstring = "2011-01-18 20:15:40";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(oldstring);
		// System.out.println("sql timestamp: "+calendar.getTime().getTime());
		java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(date.getTime());

		// (3) create a java timestamp insert statement
		String sqlTimestampInsertStatement = "INSERT INTO record (timestamp2) VALUES (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlTimestampInsertStatement);
		preparedStatement.setTimestamp(1, ourJavaTimestampObject);

		// (4) execute the sql timestamp insert statement, then shut everything down
		preparedStatement.executeUpdate();
		System.out.println("record written");
		preparedStatement.close();
		System.out.println("connection closed..\nend of line.");
		System.exit(0);

	}

	public static void sqlDateTime() {

		try {

			// Connect to Database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datetime", "root", "root");

			// Instantiate Java's Date
			java.util.Date date = new java.util.Date();

			// Instantiate SQL Date to Java's Date
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			// Instantiate SQL TimeStamp to Java's Date to get Time
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());

			// java.sql.Time sqlTime=new java.sql.Time(date.getTime());

			// Prepare a SQL statement for writing to Database
			PreparedStatement ps = con.prepareStatement("insert into record (date,time) values(?,?)");

			// Set Date
			ps.setDate(1, sqlDate);

			// Set Time
			ps.setTimestamp(2, sqlTime);

			// ps.setTime(2,sqlTime);

			// Execute SQL - Write to Database
			ps.executeUpdate();

			// Close Statement
			ps.close();

			// Close Connection
			con.close();

			System.out.println("Written to database");
		} catch (Exception e) {
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
		// 3,600,000 millisecond = 1 minute / 1 ms = 1.7e-05 mins / 1 mins = 60,000.0 ms
		Double hours = Math.floor(((difference / 3600000) * 100) / 100);
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

	public static void displayUnixEpochTime() throws ParseException {

		// Input date and time separately as Strings
		// concatenate them into: 2011-01-18 07:00:00
		// Change to Unix Epoch Time
		// Write UnixEpoch Time to Database
		// Read Unix Epoch Time and convert to Java Date
		// Calculate hours.
		
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String timeIn = "2011-01-18 07:00:00";
		String timeOut = "2011-01-19 15:00:00";
		Date dateIn = dateFormat.parse(timeIn);
		Date dateOut = dateFormat.parse(timeOut);

//        Date now = new Date();
//        long ut3 = now.getTime() / 1000L;
		long utIn = dateIn.getTime() / 1000L;
		long utOut = dateOut.getTime() / 1000L;

		// String Time/Date to Unix Epoch Time
		System.out.println("* String Time/Date to Unix Epoch Time\n--------------------------------");
		System.out.println("dateIn: " + dateIn);
		System.out.println("unixTimeIn: " + utIn);
		System.out.println();
		System.out.println("dateOut: " + dateOut);
		System.out.println("unixTimeOut: " + utOut);
		System.out.println("-----------------------------");

		// Unix Epoch Time to Java Date and Time
		Date unixEpochIn = new Date(utIn * 1000L);
		Date unixEpochOut = new Date(utOut * 1000L);

		String punchIn = dateFormat.format(unixEpochIn);
		String punchOut = dateFormat.format(unixEpochOut);
		System.out.println();
		System.out.println("* Unix Epoch Time to Java Date and Time \n--------------------------------");
		System.out.println("unixEpoch: " + unixEpochIn + "\t\tunixEpochNow: " + unixEpochOut);
		System.out.println("punchIn: " + punchIn + "\t\t\tpunchOut: " + punchOut);

		// Calculate hours

		final int MILLI_TO_HOUR = 1000 * 60 * 60;
		Double hours = (double) ((unixEpochOut.getTime() - unixEpochIn.getTime()) / MILLI_TO_HOUR);
		System.out.println("\n\nHours: " + hours);

	}

	public static void inputDateAndTime(String date, String time) throws ParseException {
		// Current Format input: 2011-01-18 20:15:40
		String dateStamp = date + " " + time;
		Date dateTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStamp);
		System.out.println("dateTimeStamp:  " + dateTimeStamp);

//		/ SQL TIMESTAMP
//        java.sql.Timestamp sqlTS = new java.sql.Timestamp(date.getTime());
//        System.out.println("java.sql.Timestamp time: " + sqlTS);
	}

	public static void javaSQLDB() {
		// Writing from JAVA to SQL DB

		// Convert the time into UTC and build Timestamp object.
		Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		// use setTimestamp on preparedstatement - write TS to DB
		// preparedStatement.setTimestamp(1, ts);
		System.out.println(ts);

		// Reading from SQL DB to JAVA

		// 1. Read it as it is in java.sql.Timestamp type.
		// 2. Decorate the DateTime value as time in UTC timezone using atZone method in
		// LocalDateTime class.
		// 3. Then, change it to your desired timezone. Here I am changing it to Toronto
		// timezone.

		// ResultSet resultSet = preparedStatement.executeQuery();
		// resultSet.next();
		Timestamp timestamp = ts;
		ZonedDateTime timeInUTC = timestamp.toLocalDateTime().atZone(ZoneId.of("UTC"));
		LocalDateTime timeInNewYork = LocalDateTime.ofInstant(timeInUTC.toInstant(), ZoneId.of("America/New_York"));
		System.out.println(timeInNewYork);
	}
}
