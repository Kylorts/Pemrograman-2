package praktikum3.soal2;

public class Negara {
	private String nama;
	private String jenisKepimpinan;
	private String namaPemimpin;
	private int tanggalKemerdekaan;
	private int bulanKemerdekaan;
	private int tahunKemerdekaan;
	
	public Negara(String nama, String jenisKepimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan){
		setNama(nama);
		setJenisKepimpinan(jenisKepimpinan);
		setNamaPemimpin(namaPemimpin);
		setTanggalKemerdekaan(tanggalKemerdekaan);
		setBulanKemerdekaan(bulanKemerdekaan);
		setTahunKemerdekaan(tahunKemerdekaan);
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setJenisKepimpinan(String jenisKepimpinan) {
		this.jenisKepimpinan = jenisKepimpinan;
	}
	
	public String getJenisKepimpinan() {
		return jenisKepimpinan;
	}
	
	public void setNamaPemimpin(String namaPemimpin) {
		this.namaPemimpin = namaPemimpin;
	}
	
	public String getNamaPemimpin() {
		return namaPemimpin;
	}
	
	public void setTanggalKemerdekaan(int tanggalKemerdekaan) {
		this.tanggalKemerdekaan = tanggalKemerdekaan;
	}
	
	public int getTanggalKemerdekaan() {
		return tanggalKemerdekaan;
	}
	
	public void setBulanKemerdekaan(int bulanKemerdekaan) {
		this.bulanKemerdekaan = bulanKemerdekaan;
	}
	
	public int getBulanKemerdekaan() {
		return bulanKemerdekaan;
	}
	
	public void setTahunKemerdekaan(int tahunKemerdekaan) {
		this.tahunKemerdekaan = tahunKemerdekaan;
	}
	
	public int getTahunKemerdekaan() {
		return tahunKemerdekaan;
	}
}