package com.example.shorten_url.util;

import org.springframework.stereotype.Component;

@Component
public class Base62Util {
	private static final char[] characterSet = 
	{
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
		'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
		'Y', 'Z'
	};

	public String Encode(Long dec) {
		String id = "";
		
		Long quotient = dec;
		int remainder;
		for(int i=0; i<8; ++i) {
			remainder = (int)(quotient%62);
			quotient = quotient/62;
			id = String.valueOf(characterSet[remainder]) + id;
		}

		return id;
	}
}