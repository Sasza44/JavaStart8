package first.level;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class First {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t;
		System.out.println("Write text ");
		t = sc.nextLine();
		
		try(FileWriter a1 = new FileWriter("a1.txt", true)) {
			a1.write(t);
			a1.write("\n");
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(t);
	}
}