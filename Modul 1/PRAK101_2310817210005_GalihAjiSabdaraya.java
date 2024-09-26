import java.util.Scanner;

public class PRAK101_2310817210005_GalihAjiSabdaraya {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String bulanLahir[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
		
		System.out.print("Masukkan Nama Lengkap: ");
		String Nama = scan.nextLine();
		
		System.out.print("Masukkan Tempat Lahir: ");
		String tempatLahir = scan.nextLine();
		
		System.out.print("Masukkan Tanggal Lahir: ");
		int tanggalLahir = scan.nextInt();
		
		System.out.print("Masukkan Bulan Lahir: ");
		int nomorBulan = scan.nextInt();
		
		System.out.print("Masukkan Tahun Lahir: ");
		int tahunLahir = scan.nextInt();
		
		System.out.print("Masukkan Tinggi Badan: ");
		int tinggiBadan = scan.nextInt();
		
		System.out.print("Masukkan Berat Badan: ");
		double beratBadan = scan.nextDouble();
		
		
		System.out.println("Nama Lengkap " + Nama + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + bulanLahir[nomorBulan - 1] + " " + tahunLahir + " Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + beratBadan + " Kilogram");
		scan.close();
	}

}