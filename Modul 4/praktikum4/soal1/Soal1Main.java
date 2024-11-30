package praktikum4.soal1;
import java.util.Scanner;

public class Soal1Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nama Hewan Peliharaan: ");
		String namaHewan = scan.nextLine();
		System.out.print("Ras: ");
		String rasHewan = scan.nextLine();
		HewanPeliharaan hewan = new HewanPeliharaan(rasHewan, namaHewan);
		hewan.display();
		scan.close();
	}

}