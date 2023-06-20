package second.level;

import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		// Зчитування тексту з файлу та перетворення його на змінну типу String
		File b2 = new File("b2.txt");
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
		//System.out.println(text);
		String text1 = text.toLowerCase(); // перетворення усіх символів у нижній регістр
		char[] arr = text1.toCharArray(); // перетворення тексту на масив символів
		char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int[] arr2 = new int[26]; // масив, який зберігатиме значення кількості повторення кожної літери
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == arr1[i]) {
					arr2[i] += 1;
				}
			}
		}
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		int[] arr3 = new int[26]; // копія масиву arr2
		for(int i = 0; i < arr2.length; i++) {
			arr3[i] = arr2[i];
		}
		Arrays.sort(arr3); // сортування масиву в порядку зростання
		//System.out.println(Arrays.toString(arr3));
		int x = 0;
		for(int i = 0; i < arr3.length / 2; i++) { // реверс масиву arr3
			x = arr3[i];
			arr3[i] = arr3[arr3.length - i - 1];
			arr3[arr3.length - i - 1] = x;
		}
        System.out.println(Arrays.toString(arr3));
        
        int[] arr5 = new int[26]; // копія масиву arr3 (допоміжний масив, необхідний щоб не потрапляти на те саме число, коли трапляється однакова кількість повторень)
		for(int i = 0; i < arr3.length; i++) {
			arr5[i] = arr3[i];
		}
        
        char[] arr4 = new char[26]; // масив, у якому розташовані спочатку літери. які частіше зустрічаються
        for(int i = 0; i < arr2.length; i++) {
        	int j = 0;
        	boolean b = false;
        	while(b != true) {
        		if(arr2[i] == arr3[j] && arr5[j] >= 0) { // програма знаходить перший збіг, а далі не шукає
        			arr4[j] = arr1[i];
        			arr5[j] = -1;
        			b = true;
        		}
        		j += 1;
        	}
        }
        System.out.println(Arrays.toString(arr4));
        //System.out.println(Arrays.toString(arr5));
	}
}