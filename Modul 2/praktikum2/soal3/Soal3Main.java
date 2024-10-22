package praktikum2.soal3;

public class Soal3Main {

	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
		//Pada baris ini terjadi error karena kurangnya titik koma (;)
		//p1.nama = "Roi"
		p1.nama = "Roi";
		p1.asal = "Kingdom of Orvel";
		p1.setJabatan("Assasin");
		//Tidak ada assign/menambahkan nilai untuk umur.
		p1.umur = 17;
		
		//terdapat kata yang tidak sesuai output yaitu "pegawai".
		//System.out.println("Nama Pegawai: " + p1.getNama());
		System.out.println("Nama: " +p1.getNama());
		System.out.println("Asal: " + p1.getAsal());
		System.out.println("Jabatan: " + p1.jabatan);
		//baris ini tidak ada kata "tahun".
		//System.out.println("Umur: " + p1.umur);
		System.out.println("Umur: " + p1.umur);
	}

}
