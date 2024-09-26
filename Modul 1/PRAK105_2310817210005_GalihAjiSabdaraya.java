import java.util.Scanner;

public class PRAK105_2310817210005_GalihAjiSabdaraya {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final double Pi = 3.14;
		
		System.out.print("Masukkan jari-jari: ");
		double jari_jari = scan.nextDouble();
		
		System.out.print("Masukkan tinggi: ");
		double tinggi = scan.nextDouble();
		
		double volumeTabung = Pi * jari_jari * jari_jari * tinggi;
		System.out.printf("Volume tabung dengan jari-jari %.1f dan tinggi %.1f cm adalah %.3f m3", jari_jari, tinggi, volumeTabung);
		scan.close();
	}

}
