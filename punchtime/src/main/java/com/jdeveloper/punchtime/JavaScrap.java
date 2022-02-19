package com.jdeveloper.punchtime;

import java.util.UUID;

public class JavaScrap {

	public static void main(String[] args) {
		
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        System.out.println("Your UUID is: " + uuidAsString);

	}

}
