package first.level;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Second {

	public static void main(String[] args) {
		int[][] arr = {{13, 42, 73}, {44, 58, 93}};
		writeArray(arr);
	}
	
	static void writeArray(int[][] a) {
		try(PrintWriter a2 = new PrintWriter("a2.txt")) {
			for(int[] row: a) {
				a2.println(Arrays.toString(row));
			}
			System.out.println("The array was written succesfully");
		} catch(FileNotFoundException e) {
			System.out.println("Error file write");
		}
	}
}