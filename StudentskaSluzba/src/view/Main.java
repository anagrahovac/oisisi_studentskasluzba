package view;

public class Main {

	public static void main(String[] args) {
		System.out.println(":)");
		MainFrame.getInstance();
		DodajPredmetProfesoruDialog p = new DodajPredmetProfesoruDialog();
		p.setVisible(true);
	}

}
