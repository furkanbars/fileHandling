package fileProcesses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//createNewFile();
		
		//writeFile("Konya");
		
		//for(String city:readFile()) {
		//	System.out.println(city);
		//}
		
		//if(isExist("Konya")) {
		//	System.out.println("Mevcut");
		//}else {
		//	System.out.println("Mevcut değil");
		//}
	}


	public static boolean isExist(String city) {
		boolean result = false;

		ArrayList<String> cities = readFile();
		if (!cities.isEmpty() && cities.contains(city)) {
			result=true;
		}
		return result;
	}

	
	public static void writeFile(String city) {
		try {
			File file = new File("D:\\BtkAkademiJava\\fileProcesses\\cities.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			if (file.exists() && file.canWrite()) {
				if (!isZero()) {
					writer.newLine();
				}
				writer.write(city);
				System.out.println("Başarıyla dosyaya yazıldı.");
				writer.close();
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void createNewFile() {
		try {
			File file = new File("D:\\BtkAkademiJava\\fileProcesses\\cities.txt");

			if (file.createNewFile()) {
				System.out.println("Dosya başarıyla oluşturuldu.");
			} else {
				System.out.println("Dosya zaten mevcut.");
			}

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static ArrayList<String> readFile() {
		String line = null;
		ArrayList<String> cities = new ArrayList<String>();
		try { 
			File file = new File("D:\\BtkAkademiJava\\fileProcesses\\cities.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));

			while ((line=reader.readLine()) != null) {
				cities.add(line);
			}
			reader.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return cities;
	}

	public static boolean isZero() {
		boolean result = true;

		try {
			File file = new File("D:\\BtkAkademiJava\\fileProcesses\\cities.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));

			if (reader.readLine() != null) {
				result = false;
			}

			reader.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return result;
	}
}
