import java.util.Scanner;

public class Main {
	static int T;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A=scann.nextInt();
			int B=scann.nextInt();
			int gcd=gcd(A,B);
			System.out.println(1L*A*B/gcd);
		}

	}
	static int gcd(int a, int b) {
		
		if(a==b) { return a ;}
		else if(b>a) {
			int temp=a;
			a=b;
			b=temp;
		}
		if(b==0) return a;
		else return gcd(a%b,b);
	}

}
