package praktikum3.soal1;
import java.util.LinkedList;
import java.util.Scanner;

public class Soal1Main { 
	public static void main(String[] args) {
		LinkedList<Dadu> daduCollection = new LinkedList<Dadu>();
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		for(int banyakDadu = 0; banyakDadu < input; banyakDadu++) {
			daduCollection.add(new Dadu());
		}
		
		printDaduCollection(daduCollection);
		scan.close();
	}
	
	
	static void printDaduCollection(LinkedList<Dadu> daduCollection) {
		if(daduCollection.isEmpty()) {
			System.out.println("Tidak ada dadu yang tersimpan dalam collection.");
			return;
		}
		
		int jumlah = 0;
		for(int banyakDadu = 0; banyakDadu < daduCollection.size(); banyakDadu++) {
			int angkaDadu = daduCollection.get(banyakDadu).getAngkaDadu();
			jumlah += angkaDadu;
			System.out.println("Dadu ke-" + (banyakDadu + 1) + " bernilai " + angkaDadu);
		}
		System.out.println("Total nilai dadu keseluruhan " + jumlah);
	}
}