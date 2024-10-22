package praktikum2.soal2;

public class Kopi {
	public String namaKopi;
	public String ukuran;
	public double harga;
	private String pembeli;
	
	public String getPembeli() {
		return pembeli;
	}
	
	public void setPembeli(String pembeli) {
		this.pembeli = pembeli;
	}
	
	public double getPajak() {
		return 0.11 * harga;
	}
	

	
	public void info() {
		System.out.printf("Nama Kopi: %s\n", namaKopi);
		System.out.printf("Ukuran: %s\n", ukuran);
		System.out.printf("Harga: %.1f\n", harga);
	}
}
