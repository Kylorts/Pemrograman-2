package praktikum3.soal3;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Soal3Main {

	public static void main(String[] args) {
		ArrayList<Mahasiswa> collectionMahasiswa = new ArrayList<Mahasiswa>();
		Scanner scan = new Scanner(System.in);
		int pilihan = 0;
		do {
			System.out.println("Menu: ");
			System.out.println("1. Tambah Mahasiswa");
			System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
			System.out.println("3. Cari Mahasiswa berdasarkan NIM");
			System.out.println("4. Tampilkan Daftar Mahasiswa");
			System.out.println("0. Keluar");
			System.out.print("Pilihan: ");
			pilihan = scan.nextInt();
			scan.nextLine();
			
			switch(pilihan) {
				case 1:
					tambahMahasiswa(collectionMahasiswa, scan);
					break;
				case 2:
					hapusMahasiswaBerdasarkanNIM(collectionMahasiswa, scan);
					break;
				case 3:
					cariMahasiswaBerdasarkanNIM(collectionMahasiswa, scan);
					break;
				case 4:
					tampilkanListMahasiswa(collectionMahasiswa, scan);
					break;
				case 0:
					System.out.println("Terima kasih!");
					break;
				default :
					System.out.println("Pilihan tidak valid. Silahkan coba lagi");
			}
			
		} while (pilihan != 0);
		
		scan.close();
	}
	
	static void tambahMahasiswa(ArrayList<Mahasiswa> collectionMahasiswa, Scanner scan) {
	    System.out.print("Masukkan Nama Mahasiswa: ");
	    String nama = scan.nextLine();
	    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
	    String nim = scan.nextLine();

	    Mahasiswa mhs = new Mahasiswa(nama, nim);

	    
	    int index = Collections.binarySearch(collectionMahasiswa, mhs);

	    if (index >= 0) {
	        System.out.println("Mahasiswa dengan NIM tersebut sudah ada");
	    } else {
	        int pos = -(index + 1);
	        collectionMahasiswa.add(pos, mhs);
	        System.out.println("Mahasiswa "+ nama + " ditambahkan.");
	    }
	}
	
	
	static void hapusMahasiswaBerdasarkanNIM(ArrayList<Mahasiswa> collectionMahasiswa, Scanner scan) {
		System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
		String nim = scan.nextLine();
		Mahasiswa nimSearch = new Mahasiswa("", nim);
		int index = Collections.binarySearch(collectionMahasiswa, nimSearch);
		
		if (index >= 0) {
			collectionMahasiswa.remove(index);
			System.out.println("Mahasiswa dengan NIM " + nim +" dihapus");
		} 
		else {
			System.out.println("Mahasiswa dengan NIM " + nim + " tidak ada berada pada list.");
		}
		
	}
	
	static void cariMahasiswaBerdasarkanNIM(ArrayList<Mahasiswa> collectionMahasiswa, Scanner scan) {
		System.out.print("Masukkan NIM mahasiswa yang akan dicari: ");
		String nim = scan.nextLine();
		Mahasiswa nimSearch = new Mahasiswa("", nim);
		int index = Collections.binarySearch(collectionMahasiswa, nimSearch);
		
		if(index >= 0) {
			Mahasiswa mhs = collectionMahasiswa.get(index);
			System.out.println("Mahasiswa dengan NIM " + mhs.getNimMahasiswa() + " adalah " + mhs.getNamaMahasiswa());
		}
		else {
			System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
		}
	}
	
	static void tampilkanListMahasiswa(ArrayList<Mahasiswa> collectionMahasiswa, Scanner scan) {
		if(collectionMahasiswa.isEmpty()) {
			System.out.println("List Mahasiswa kosong.");
		}
		else {
			System.out.println("Daftar Mahasiswa:");
			for(Mahasiswa mhs : collectionMahasiswa) {
				System.out.println("NIM: " + mhs.getNimMahasiswa()+ ", Nama: " + mhs.getNamaMahasiswa());
			}
			System.out.println();
		}
	}	
}