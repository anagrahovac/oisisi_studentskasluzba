package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

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
	
	public static void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		File dir = new File("podaci");
		File studentiFile = new File(dir, "studenti.txt");
		File profesoriFile = new File(dir, "profesori.txt");
		File predmetiFile = new File(dir, "predmeti.txt");
		
		ObjectInputStream ois1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(studentiFile)));
		try {
			ArrayList<Student> studenti = (ArrayList<Student>) ois1.readObject();
			BazaStudenata.getInstance().setStudenti(studenti);
		} finally {
			ois1.close();
		}
		
		ObjectInputStream ois2 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(profesoriFile)));
		try {
			ArrayList<Profesor> profesori = (ArrayList<Profesor>) ois2.readObject();
			BazaProfesora.getInstance().setProfesori(profesori);
		} finally {
			ois2.close();
		}
		
		ObjectInputStream ois3 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(predmetiFile)));
		try {
			ArrayList<Predmet> predmeti = (ArrayList<Predmet>) ois3.readObject();
			BazaPredmeta.getInstance().setPredmeti(predmeti);
		} finally {
			ois3.close();
		}
	}
}