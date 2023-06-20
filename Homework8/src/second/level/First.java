package second.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class First {

	public static void main(String[] args) {
		String t1 = "b1.txt";
		readArray2(t1);
	}
	static void readArray2(String t) {
		try {
			File b1 = new File(t);
			FileReader fr = new FileReader(b1);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}