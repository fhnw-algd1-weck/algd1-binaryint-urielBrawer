package ch.fhnw.algd1.converters.binary;

import java.util.ArrayList;

public class BinConverter {
	public static String toString(int x) {
		// TODO expect x to be in range [-128, 127], return string with 8 binary

		String option = "bitshift";
		String binary = "00000000";
		switch (option) {
			case "diy":
				// diy solution of algorithm:
				String result = "";
				while (x != 0) {
					System.out.println("loop with x = " + x);
					if (x % 2 == 0) {
						result = result + "0";
						System.out.println(result);
					} else {
						result = result + "1";
						x = x - 1;
					}
					x = x / 2;
				}
				System.out.println(result);
				binary = String.format("%8s", result).replace(' ', '0');
				System.out.println("diy: " + binary);
				break;
			case "Library":
				// built in solution:
				binary = String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0');
				System.out.println("Library: " + binary);
				break;
			case "bitshift":
				StringBuilder res = new StringBuilder();
				for (int i = 0; i < 8; i++) {
					int bit = (x >> i) & 1;
					res.append(bit);
				}
				res.reverse();
				System.out.println(res);
				binary = res.toString();
				break;
		}

		// digits representing x in 2-complement
		return binary;

	}

	public static int fromString(String text) {
		// TODO expect text to contain 8 binary digits, parse to int value in
		String option = "diy";
		int result = 0;

		switch (option) {
			case "diy":
				for (int i = 0; i < 8; i++) {
					System.out.println(text.charAt(i));
					result = result + ((text.charAt(i) - '0') << (7 - i));
				}
				System.out.println(result);
				break;

			case "shift":
				for (int i = 0; i < 8; i++) {
					result = (result << 1) | (text.charAt(i) - '0');
				}
				System.out.println(result);
				break;
		}
		// 2-complement
		return result;
	}
}