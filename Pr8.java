package projects;
import java.util.Scanner;
public class Pr8 {

	public static void main(String[] args) {
		
		int sayi,yenisayi,a,b,c;
		Scanner i=new Scanner(System.in);
		
		System.out.println("bir sayi gir:");
		sayi=i.nextInt();
		
		a=sayi/100;
		b=(sayi/10)%10;
		c=sayi%10;
		
		System.out.println("yenisayi=" + c +b +a);

	}

}
