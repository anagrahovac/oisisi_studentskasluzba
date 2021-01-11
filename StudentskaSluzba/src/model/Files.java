package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class Files {
	public static void writeInFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("podaci");
		File studentiFile = new File(dir, "studenti.txt");
		File profesoriFile = new File(dir, "profesori.txt");
		File predmetiFile = new File(dir, "predmeti.txt");
		
		ObjectOutputStream oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(studentiFile)));
		try{
			oos1.writeObject(BazaStudenata.getInstance().getStudenti());
		} finally {
			oos1.close();
		}
		
		ObjectOutputStream oos2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(profesoriFile)));
		try{
			oos2.writeObject(BazaProfesora.getInstance().getProfesori());
		} finally {
			oos2.close();
		}
		
		ObjectOutputStream oos3 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(predmetiFile)));
		try{
			oos3.writeObject(BazaPredmeta.getInstance().getPredmeti());
		} finally {
			oos3.close();
		}
	}
}