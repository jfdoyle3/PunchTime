package com.jfdeveloper.punchtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GetDayOfWeekFromDate {

	public static void main(String[] args) throws ParseException {
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter date and Time: YYYY-MM-DD HH:MM:SS");
			String dateTime=input.nextLine();

			SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date dateIn = dateTimeFormat.parse(dateTime);
			Calendar cal=Calendar.getInstance();
			cal.setTime(dateIn);
			
			System.out.println("\nDate: "+dateIn);
			System.out.print("\n\nThe day is: ");
			
			int day=cal.get(Calendar.DAY_OF_WEEK);
			switch(day){
			case 1-> System.out.print("Sunday");
			case 2-> System.out.print("Monday");
			case 3-> System.out.print("Tuesday");
			case 4-> System.out.print("Wednesday");
			case 5-> System.out.print("Thursday");
			case 6-> System.out.print("Friday");
			case 7-> System.out.print("Saturday");
			default->System.out.println("error - day doesn't exist");
			}
		}
	}
}
