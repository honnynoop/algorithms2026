import java.util.Scanner;

public class Main {
	static int N,K,J;
	static int[] money= {500,100,50,10,5,1};
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=money.length;
		J=scann.nextInt();
		K=1000-J;
		
		int cnt=0;
		for (int i=0; i<N; i++) {
			int M=money[i];
			if(K/M==0)continue;
			cnt+=(K/M);
			K-=(K/M)*M;
			if(K==0) break;
		}
		System.out.println(cnt);
	}
}