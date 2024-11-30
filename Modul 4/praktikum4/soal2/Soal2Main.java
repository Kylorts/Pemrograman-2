package praktikum4.soal2;
import java.util.Scanner;

public class Soal2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int pilihan = 0;
		System.out.println("Pilih jenis hewan yang ingin diinputkan:");
		System.out.println("1 = Kucing");
		System.out.println("2 = Anjing");
		
		while(pilihan < 1 || pilihan > 2) {
			System.out.print("Masukkan Pilihan: ");
			pilihan = scan.nextInt();
			scan.nextLine();
			
			if(pilihan < 1 || pilihan > 2) {
				System.out.println("Pilihan tidak valid. Silahkan coba lagi");
			}
		}
		
		System.out.print("Nama hewan peliharaan: ");
		String nama = scan.nextLine();
		System.out.print("Ras: ");
		String ras = scan.nextLine();
		System.out.print("Warna Bulu: ");
		String warnaBulu =  scan.nextLine();
		
		if(pilihan == 1) {
			Kucing kucing = new Kucing(ras, nama, warnaBulu);
			kucing.displayDetailKucing();
		} else if(pilihan == 2) {
			System.out.print("Kemampuan : ");
			String kemampuan = scan.nextLine();
			String daftarKemampuan[] = kemampuan.split(",");
			
			Anjing anjing = new Anjing(nama, ras, warnaBulu, daftarKemampuan);
			anjing.displayDetailAnjing();
		}
		scan.close();
	}

}
