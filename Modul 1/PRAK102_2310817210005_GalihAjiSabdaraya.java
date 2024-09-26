import java.util.Scanner;

public class PRAK102_2310817210005_GalihAjiSabdaraya {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int Angka = scan.nextInt();
        int Baris = 0;
        
        //Print baris angka sebanyak 11 bilangan
        while (Baris < 11) {
            if (Angka % 5 == 0) {
                System.out.print((Angka / 5) - 1);
            } else {
                System.out.print(Angka);
            }
   
            if (Baris < 10) {
                System.out.print(", ");
            }

            Angka++;
            Baris++;
        }
        scan.close();
	}

}