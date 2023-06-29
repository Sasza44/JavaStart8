package second.level;

import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		// Зчитування тексту з файлу та перетворення його на змінну типу String
		String text1 = reading("b2.txt");
		char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int[] arr2 = repeatNum(text1, arr1); // отримання масиву кількостей повторень літер
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		int[] arr3 = sortNumbers(arr2); // сортування масиву кількості повторень в порядку спадання
        System.out.println(Arrays.toString(arr3));
        
        char[] arr4 = sortLetters(arr3, arr2, arr1); // сортування масиву літер
        System.out.println(Arrays.toString(arr4));
	}
	
	static String reading(String fileName) { // Зчитування тексту з файлу та перетворення його на змінну типу String
		File b2 = new File(fileName);
		StringBuilder sb = new StringBuilder();
		try(Scanner sc = new Scanner(b2)) {
			for(;sc.hasNextLine();) {
				sb.append(sc.nextLine());
				sb.append(System.lineSeparator());
			}
		} catch(IOException e) {
			System.out.println(e);
		}
		String text = sb.toString(); // результат перетворення
		return text.toLowerCase(); // перетворення усіх символів у нижній регістр
	}
	
	static int[] repeatNum(String text, char[] a1) { // отримання масиву кількостей повторень літер
		char[] arr = text.toCharArray(); // перетворення тексту на масив символів
		int[] a2 = new int[26]; // масив, який зберігатиме значення кількості повторення кожної літери
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == a1[i]) {
					a2[i] += 1;
				}
			}
		}
		return a2;
	}
	
	static int[] sortNumbers(int[] a2) { // сортування масиву кількості повторень в порядку спадання
		int[] a3 = new int[26]; // копія масиву arr2
		for(int i = 0; i < a2.length; i++) {
			a3[i] = a2[i];
		}
		Arrays.sort(a3); // сортування масиву в порядку зростання
		int x = 0;
		for(int i = 0; i < a3.length / 2; i++) { // реверс масиву arr3
			x = a3[i];
			a3[i] = a3[a3.length - i - 1];
			a3[a3.length - i - 1] = x;
		}
		return a3;
	}
	
	static char[] sortLetters(int[] a3, int[] a2, char[] a1) { // сортування масиву літер
		int[] arr5 = new int[26]; // копія масиву arr3 (допоміжний масив, необхідний щоб не потрапляти на те саме число, коли трапляється однакова кількість повторень)
		for(int i = 0; i < a3.length; i++) {
			arr5[i] = a3[i];
		}
        
        char[] a4 = new char[26]; // масив, у якому розташовані спочатку літери. які частіше зустрічаються
        for(int i = 0; i < a3.length; i++) {
        	int j = 0;
        	boolean b = false;
        	while(b != true) {
        		if(a2[i] == a3[j] && arr5[j] >= 0) { // програма знаходить перший збіг, а далі не шукає
        			a4[j] = a1[i];
        			arr5[j] = -1;
        			b = true;
        		}
        		j += 1;
        	}
        }
        return a4;
	}
}