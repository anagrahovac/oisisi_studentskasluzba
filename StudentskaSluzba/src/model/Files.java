package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Files {
	public static void writeInFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("podaci.txt");
		Data d = new Data();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		try{
			oos.writeObject(d);
		} finally {
			oos.close();
		}
	}
	
	public static void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("podaci.txt");
		Data d = new Data();
		
		ObjectInputStream ois1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		try{
			d = (Data) ois1.readObject();
			BazaStudenata.getInstance().setStudenti(d.getStudenti());
			BazaProfesora.getInstance().setProfesori(d.getProfesori());
			BazaPredmeta.getInstance().setPredmeti(d.getPredmeti());
		} finally {
			ois1.close();
		}
	}
}