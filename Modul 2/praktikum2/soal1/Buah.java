package praktikum2.soal1;

public class Buah {
	private String nama;
	private double berat;
	private double harga;
	private double totalBerat;
	
	Buah(String nama, double berat, double harga, double totalBerat){
		this.nama = nama;
		this.berat = berat;
		this.harga = harga;
		this.totalBerat = totalBerat;
	}
	
	private double hitungTotalHarga() {
		return (totalBerat / berat) * harga;
	}
	
	private double hitungTotalDiskon() {
		return (Math.floor(totalBerat/4)) * 0.02 * harga * 4;
	}
	
	private double hitungHargaSetelahDiskon() {
		return hitungTotalHarga() - hitungTotalDiskon();
	}
	
	public void info() {
		System.out.printf("Nama Buah: %s\n", nama);
		System.out.printf("Berat: %.1f\n", berat);
		System.out.printf("Harga: %.1f\n", harga);
		System.out.printf("Jumlah Beli : %.1fkg\n", totalBerat);
		System.out.printf("Harga Sebelum Diskon : %.2f\n", hitungTotalHarga());
		System.out.printf("Total Diskon: Rp%.2f\n", hitungTotalDiskon());
		System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n",  hitungHargaSetelahDiskon());		
	}
}
