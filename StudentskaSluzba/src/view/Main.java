package view;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.Files;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Files.readFromFile();
		System.out.println(":)");
		MainFrame.getInstance();
	}

}
