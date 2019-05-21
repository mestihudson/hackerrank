package warmups;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CountingValleys {
	// Complete the countingValleys function below.
	public int count(final int n, final String s) {
    String [] parts = s.split("");
    int counter = 0;
    for(int index = 0, length = parts.length; index < length; index++) {
      counter += isDown(index, parts) ? 1 : 0;
    }
    return counter;
	}

  private boolean isDown(final int index, final String... parts) {
    return
      (index > 0 && parts[index].equals("D") && parts[index - 1].equals("D")) &&
      (index == 1 || !parts[index - 2].equals("D"))
    ;
  }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		final BufferedWriter bufferedWriter = new BufferedWriter(
      new FileWriter(System.getenv("OUTPUT_PATH"))
    );

		final int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		final String s = scanner.nextLine();

		final int result = new CountingValleys().count(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
