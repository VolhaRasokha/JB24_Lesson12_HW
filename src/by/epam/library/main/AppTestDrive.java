package by.epam.library.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import by.epam.library.entity.Library;
import by.epam.library.entity.PrintedEdition;

public class AppTestDrive {
	public static void main(String[] args) {
		DateFormat formatter;
		formatter = new SimpleDateFormat("yy.mm.dd");
		Library myLibrary = new Library();

		String[] printedEdition = new String[4];

		Path file_path = Paths.get(
				"d:/Volha_Rasokha/JB24/workspace_jb24/JB24_HW_Lesson12/src/",
				"list_of_books.txt");

		try {
			List<String> lines = Files.readAllLines(file_path);

			for (String line : lines) {
				for (int i = 0; i < printedEdition.length; i++) {
					printedEdition = line.split(",");
				}
				myLibrary.add(new PrintedEdition(printedEdition[0], Double
						.parseDouble(printedEdition[1]), printedEdition[2],
						formatter.parse(printedEdition[3])));
			}
			System.out.println(myLibrary.getUnits());
		} catch (IOException e) {
			System.out.println("File has not been found! Please, check if the file list_of_books.txt exits in d:/Volha_Rasokha/JB24/workspace_jb24/JB24_HW_Lesson12/src/!");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Data from the file is not correct! Please, check!");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Data from the file is not correct! Please, check!");			
			e.printStackTrace();
		}

	}

}
