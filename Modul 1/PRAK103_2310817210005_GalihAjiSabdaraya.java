import java.util.Scanner;

public class PRAK103_2310817210005_GalihAjiSabdaraya {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Maks_Baris = scan.nextInt();
		int Angka = scan.nextInt();
		int Baris = 0;
		
		//print Angka sebanyak Maks_Baris
		do {
			
			if(Angka % 2 == 0) { //jika Angka genap maka tambahkan 1 untuk jadi ganjil
				Angka++;
			}
			
			
			if (Baris < Maks_Baris - 1) {
				System.out.print(Angka + ", ");
			} else {
				System.out.print(Angka);
			}
			
			
			Angka += 2;
			Baris++;
		} while (Baris < Maks_Baris);
		
		scan.close();
	}
}