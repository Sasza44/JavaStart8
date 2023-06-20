package second.level;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Third {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width;
		int height;
		System.out.println("Write width ");
		width = sc.nextInt();
		System.out.println("Write height ");
		height = sc.nextInt();
		
		fileWrite(width, height);
	}
	static void fileWrite(int w, int h) {
		try(PrintWriter b3 = new PrintWriter("b3.txt")) {
			for(int i = 1; i <= h; i++) {
				if(i == 1 || i == h) {
					for(int j = 1; j <= w; j++) {
						b3.print("*");
					}
				}
				else {
					for(int j = 1; j <= w; j++) {
						if(j == 1 || j == w) {
							b3.print("*");
						}
						else {
							b3.print(" ");
						}
					}
				}
				b3.println();
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error file write");
		}
	}
}