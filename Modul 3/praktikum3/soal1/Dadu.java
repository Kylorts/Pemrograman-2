package praktikum3.soal1;
import java.util.Random;

public class Dadu {
	private int angkaDadu;
	
	Dadu(){
		this.angkaDadu = acakNilai();
	}
	
	public int acakNilai(){
		int max = 6;
		int min = 1;
		Random acak = new Random();
		return acak.nextInt(max - min + 1) + min;
	}
	
	public int getAngkaDadu() {
		return angkaDadu;
	}
}