
//package ozzy;

import java.net.*;

//javac demo.java
//java demo > a.csv

public class demo {

	private char[] charset;
	String reg;

	public demo() {
		//you can add signs to this one
		charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-.".toCharArray();
	}
	//recursive method
	public void generate(String str, int pos, int length) {
		if (length == 0) {
			String host = str + ".nl";
			try {
				InetAddress inetAddress = InetAddress.getByName(host);
				reg = (inetAddress.getHostName() + "," + inetAddress.getHostAddress());
				System.out.println(reg);

			} catch (Exception e) {
			}
		} else {
			for (int i = pos; i < charset.length; i++) {
				generate(str + charset[i], i, length - 1);
			}
		}
	}

	public static void main(String[] args) {
		demo test = new demo();
		//changing this makes the URL much longer
		for (int length = 1; length < 99999999; length++)
			test.generate("", 0, length);

	}

}
