package praktikum4.soal2;

public class Anjing extends HewanPeliharaan{
	private String warnaBulu;
	private String[] kemampuan;
	
	public Anjing(String n, String r, String w, String[] k) {
		super(r, n);
		this.warnaBulu = w;
		this.kemampuan = k;
	}
	
	public void displayDetailAnjing() {
		super.display();
		System.out.println("Memiliki warna bulu : " + warnaBulu);
		System.out.print("Memiliki kemampuan :");
		for(int i = 0; i < kemampuan.length; ++i) {
			System.out.print(" " + kemampuan[i]);
		}
	}
}