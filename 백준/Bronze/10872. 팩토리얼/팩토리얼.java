import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		System.out.println(f(N));
	}

	private static int f(int n) {
		if(n==1 || n==0 )return 1;
		else return n*f(n-1);
	}

}