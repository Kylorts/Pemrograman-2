package PRAKTIKUM6;


public class Mahasiswa {
	private int id;
	private String nama;
	private String nim;
	
	public Mahasiswa(int id, String nama, String nim) {
		setId(id);
		setNama(nama);
		setNim(nim);
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}
	
	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNim() {
		return nim;
	}
}