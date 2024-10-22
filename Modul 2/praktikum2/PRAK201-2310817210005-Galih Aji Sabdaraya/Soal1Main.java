package praktikum2.soal1;

public class Soal1Main {

	public static void main(String[] args) {
		Buah buah1 = new Buah("Apel", 0.4,  7000, 40);
		Buah buah2 = new Buah("mangga", 0.2,  3500, 15);
		Buah buah3 = new Buah("alpukat", 0.25,  10000, 12);
		
		buah1.info();
		buah2.info();
		buah3.info();
	}

}
