import java.util.Scanner;

public class Main {

	static int A, B;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		A=scann.nextInt();
		B=scann.nextInt();
		System.out.printf("%d %d\n",(B-A)/gcd(B-A,B), (B)/gcd(B-A,B));
		
	}
	public static int gcd(int a, int b){
		if(a==b || b==0){
			return a;
		}else if(a>b){ return gcd(b,a%b);}
		else { return gcd(a,b%a);}
	}

}