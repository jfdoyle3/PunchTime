package com.jdeveloper.punchtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class JavaScrap {

	public static void main(String[] args) {
		
	Scanner scan=new Scanner(System.in);
	
	System.out.println("Enter Date: ex. 2017-07-05");
	String date=scan.next();
	System.out.println("Enter Time: ex. 20:31");
	String time=scan.next();
	String sourceTime = date+"T"+time+"+0:0000";
	String sourceTimeEX = "2017-07-05T20:31+0:0000";
	
	System.out.println("ST:   "+sourceTimeEX);
	System.out.println("MyST: "+date+"T"+time+"+0:0000");
	
	
	Date now=new Date();
	System.out.println(now);
	
    DateTimeFormatter sourceFormat
    = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm'+0:0000'");
DateTimeFormatter targetFormat
    = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a", Locale.ENGLISH);
// String sourceTime = now.toString();

String convertedTime = LocalDateTime.parse(sourceTime, sourceFormat)
    .format(targetFormat)
    .toLowerCase(Locale.ENGLISH);

String strDate=convertedTime.substring(0, 10);
String strTime=convertedTime.substring(12);

System.out.println("|"+strDate+"|"+"\n"+"|"+strTime+"|");
	}

}
