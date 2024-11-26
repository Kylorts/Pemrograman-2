package praktikum3.soal2;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;

public class Soal2Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedList<Negara> collectionNegara = new LinkedList<Negara>();
		HashMap<Integer, String> Bulan = new HashMap<Integer, String>();
		inisiasiBulan(Bulan);
		
		int jumlahNegara = scan.nextInt();
		scan.nextLine();
		inputNegara(collectionNegara, jumlahNegara);
		System.out.println();
		printCollectionNegara(collectionNegara, Bulan);
	}
	
	
	static void inputNegara(LinkedList<Negara> collectionNegara, int jumlahNegara) {
	    for (int banyakNegara = 0; banyakNegara < jumlahNegara; banyakNegara++) {
	        String namaNegara = scan.nextLine();
	        String jenisKepimpinan = scan.nextLine();
	        String namaPemimpin = scan.nextLine();
	        int tanggalKemerdekaan = 0;
	        int bulanKemerdekaan = 0;
	        int tahunKemerdekaan = 0;

	        if (!jenisKepimpinan.equalsIgnoreCase("Monarki")) {
	            tanggalKemerdekaan = scan.nextInt();
	            scan.nextLine();

	            do {
	                bulanKemerdekaan = scan.nextInt();
	                if (bulanKemerdekaan <= 0 || bulanKemerdekaan > 12) {
	                    System.out.println("Bulan tidak valid. Silahkan masukkan bulan yang valid! (1 - 12)");
	                }
	                scan.nextLine();
	            } while (bulanKemerdekaan <= 0 || bulanKemerdekaan > 12);

	            do {
	                tahunKemerdekaan = scan.nextInt();
	                if (tahunKemerdekaan <= 0 || tahunKemerdekaan > 2024) {
	                    System.out.println("Tahun tidak valid. Silahkan masukkan tahun yang valid! (1 - 2024)");
	                }
	                scan.nextLine();
	            } while (tahunKemerdekaan <= 0 || tahunKemerdekaan > 2024);
	        }

	        
	        Negara negara = new Negara(namaNegara, jenisKepimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan);
	        if (!jenisKepimpinan.equalsIgnoreCase("Monarki")) {
	            cekValidTanggalKemerdekaan(negara);
	        }
	        collectionNegara.add(negara);
	    }
	}
	
	static void cekValidTanggalKemerdekaan(Negara negara) {
	    int jumlahHari[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int tanggal = negara.getTanggalKemerdekaan();
	    int bulan = negara.getBulanKemerdekaan();
	    int tahun = negara.getTahunKemerdekaan();

	    if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
	        jumlahHari[1] = 29; 
	    }

	    while (tanggal <= 0 || tanggal > jumlahHari[bulan - 1]) {
	        System.out.println("Tanggal tidak valid. Silahkan masukkan tanggal yang valid sesuai bulan dan tahun (1 - " + jumlahHari[bulan - 1] + "): ");
	        tanggal = scan.nextInt();
	        scan.nextLine();
	    }

	    negara.setTanggalKemerdekaan(tanggal);
	}
	
	static void printCollectionNegara(LinkedList<Negara>collectionNegara, HashMap<Integer, String> Bulan) {
		for(Negara negara : collectionNegara) {
			System.out.println("Negara " + negara.getNama() + " mempunyai " + negara.getJenisKepimpinan() + " bernama " + negara.getNamaPemimpin());
			if(!negara.getJenisKepimpinan().equalsIgnoreCase("Monarki")) {
				System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + Bulan.get(negara.getBulanKemerdekaan()) + " " + negara.getTahunKemerdekaan());
			}
			System.out.println();
		}
	}
	
	static void inisiasiBulan(HashMap<Integer, String> Bulan) {
		Bulan.put(1, "Januari");
		Bulan.put(2, "Februari");
		Bulan.put(3, "Maret");
		Bulan.put(4, "April");
		Bulan.put(5, "Mei");
		Bulan.put(6, "Juni");
		Bulan.put(7, "Juli");
		Bulan.put(8, "Agustus");
		Bulan.put(9, "September");
		Bulan.put(10, "Oktober");
		Bulan.put(11, "November");
		Bulan.put(12, "Desember");
	}
}