import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		int cnt=count(N);
		System.out.println(cnt);
	}
	static int count(int n) {
		if(n/5==0) return 0; 
		else return n/5+count(n/5);
	}

}
