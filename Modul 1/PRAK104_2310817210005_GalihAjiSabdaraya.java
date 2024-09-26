import java.util.Scanner;

public class PRAK104_2310817210005_GalihAjiSabdaraya {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String suit_Abu[] = new String[3];
		String suit_Bagas[] = new String[3];
		
		//input suit punya Abu
		System.out.print("Tangan Abu: ");
		for(int i = 0; i < 3; ++i) {
			String suit = scan.next();
			suit_Abu[i] = suit; 
		}
		
		//input suit punya Bagas
		System.out.print("Tangan Bagas: ");
		for(int i = 0; i < 3; ++i) {
			String suit = scan.next();
			suit_Bagas[i] = suit; 
		}
		
		//melakukan perhitungan skor selama 3 kali suit
		int skor_Abu = 0; 
		int	skor_Bagas = 0;
		for(int i = 0; i < 3; ++i) {
			if(suit_Abu[i].equals(suit_Bagas[i])) {
				skor_Abu++;
				skor_Bagas++;
			} else if((suit_Abu[i].equals("B") && suit_Bagas[i].equals("G")) 
					|| (suit_Abu[i].equals("G") && suit_Bagas[i].equals("K")) 
					|| (suit_Abu[i].equals("K") && suit_Bagas[i].equals("B"))) {
				skor_Abu++;
			} else {
				skor_Bagas++;
			}
		}
		
		
		//menetukan pemenang dari suit
		if(skor_Abu == skor_Bagas) {
			System.out.println("Seri");
		} else if (skor_Abu > skor_Bagas) {
			System.out.println("Abu");
		} else {
			System.out.println("Bagas");
		}
		
		scan.close();
	}

}
