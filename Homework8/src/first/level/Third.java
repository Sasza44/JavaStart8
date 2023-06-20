package first.level;

import java.io.File;
import java.util.Scanner;

public class Third {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t;
		System.out.println("Write folder adress");
		t = sc.nextLine();
		showAllFolders(t);
	}
	static void showAllFolders(String ad) {
		File folder = new File(ad);
		if(folder.exists()) {
			for(File item: folder.listFiles())
			System.out.println(item + (item.isFile()?" - File": " - Folder"));
		}
	}
}