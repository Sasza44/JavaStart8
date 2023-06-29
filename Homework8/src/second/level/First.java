package second.level;

import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class First {

	public static void main(String[] args) {
		String t1 = "b1.txt";
		String [] lineArr = readArray(t1); // масив рядків, зчитаних з файлу
		
		int[][] arrNum = new int[lineArr.length][]; // двовимірний масив цілих чисел, зчитаний з файлу
		for(int i = 0; i < lineArr.length; i++) {
			System.out.println(Arrays.toString(convertToInt(lineArr[i])));
		}
	}
	
	static String[] readArray(String t) { // перетворення інформації з файлу на масив рядків
		int l1 = 0; // величина цього масиву
		String[] lines = new String[20]; // створюємо масив зчитаних рядків (з запасом)
		try {
			File b1 = new File(t);
			FileReader fr = new FileReader(b1);
			BufferedReader reader = new BufferedReader(fr);
			int i = 1;
			String line = reader.readLine();
			lines[0] = line;
            while (line != null) {
                line = reader.readLine();
                lines[i] = line;
                i += 1;
            }
            i = 0;
            while(lines[i] != null) {i += 1;}
            l1 = i;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		String[] lines1 = new String[l1]; // масив зчитаних рядків
		if(l1 > 0) {
			for(int i = 0; i < lines1.length; i++) {
				lines1[i] = lines[i];
			}
		}
		return lines1;
	}
	
	static int[] convertToInt(String line) { // перетворення рядка на масив чисел
		int[] a = new int[20]; // масив індексів ком (з запасом)
		int i = -2; // індекси ком в рядку
		int j = 0;
		while(i != -1) {
			i = line.indexOf(", ", i + 2);
			a[j] = i;
			if(i != -1) {j += 1;}
		}
		int[] a1 = new int[j]; // масив індексів ком
		for(i = 0; i < a1.length; i++) {
			a1[i] = a[i];
		}
		String[] b = new String[a1.length + 1];
		b[0] = line.substring(0, a1[0]);
		for(i = 1; i < a1.length; i++) {
			b[i] = line.substring(a1[i - 1] + 2, a1[i]);
		}
		b[b.length - 1] = line.substring(a1[a1.length - 1] + 2);
		int[] a2 = new int[a1.length + 1];
		for(i = 0; i < a2.length; i++) {
			a2[i] = Integer.parseInt(b[i]);
		}
		return a2;
	}
}