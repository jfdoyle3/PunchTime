package com.jfdeveloper.punchtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTimeToUnixConsole {

	public static void main(String[] args) throws ParseException {
		/*
		 * start:	1647255600
		 * end:		1647630000
		 */
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter date and Time: YYYY-MM-DD HH:MM:SS");
			String dateTime=input.nextLine();

			SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date dateIn = dateTimeFormat.parse(dateTime);
			System.out.println(dateIn);
			long unixTime = dateIn.getTime() / 1000L;

			System.out.println("\nUnixTime: "+unixTime);
		}
	}
}


