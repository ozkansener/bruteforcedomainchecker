# bruteforcedomainchecker

We created an tool that will collect all domainnaims that exist
The code does require some change
```
	public demo() {
		charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		// define length of strings
		min = 1;
		max = 5;
	}

	public void generate(String str, int pos, int length) {
		if (length == 0) {
			String to = (str + ".nl");
			try {
				System.out.println(to);
				//oef(to);
			}
			catch (Exception e){
			}
		} else {
			// This if statement resets the char position back to the very first character
			if (pos != 0) {
				pos = 0;
			}
			for (int i = pos; i < charset.length; i++) {
				generate(str + charset[i], i, length - 1);
			}
		}
	}
```

Steps that the scripts perform:
 - Permutation of characters in an array in a for loop recursively
 - Adds the domain of to each loop
 - Checks if the URL exist if so we also collect the IP

The output can be easyly stored to a file:

```
javac com.java
java com > com.csv
```

Questions:
ozkansener@gmail.com

Vrije Universiteit Amsterdam
