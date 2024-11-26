package praktikum2.soal3;

//nama kelas dan nama file tidak sama persis.
//public class Employee {
public class Pegawai {
	 public String nama;
	 //pada baris ini variabel asal memakai char yang hanya dapat menyimpan 1 karakter padahal asal bertujuan menyimpan banyak karakter.
	 //public char asal;
	 public String asal;
	 public String jabatan;
	 public int umur;
	 
	 public String getNama() {
		 return nama;
	 }
	 
	 public String getAsal() {
		 return asal;
	 }
	 
	 //pada baris function setJabatan tidak memiliki paramater untuk menerima nilai.
	 //public void setJabatan() {
	 public void setJabatan(String j) {
		 this.jabatan = j;
	 }
}