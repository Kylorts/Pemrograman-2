package praktikum3.soal3;

public class Mahasiswa implements Comparable<Mahasiswa>{
	private String nama;
	private String nim;
	
	public Mahasiswa(String nama, String nim) {
		setNamaMahasiswa(nama);
		setNimMahasiswa(nim);
	}
	
	public void setNamaMahasiswa(String nama){
		this.nama = nama;
	}
	
	public String getNamaMahasiswa() {
		return nama;
	}
	
	public void setNimMahasiswa(String nim) {
		this.nim = nim;
	}
	
	public String getNimMahasiswa() {
		return nim;
	}
	
	 @Override
	    public int compareTo(Mahasiswa other) {
	        return this.nim.compareTo(other.nim);
	    }
}