import java.util.Scanner;

public class Main {

	static int N=9;
	static int R=7;
	static int[] real;
	static int[] all;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		all=new int[N];
		real=new int[R];
		for (int i = 0; i < N; i++) {
			all[i]=scann.nextInt();
		}
		ncr(0,0,0);
		
	}

	private static void ncr(int start, int cnt, int tot) {
		if(cnt==R) {
			if(tot==100) {
				for (int i = 0; i < R; i++) {
					System.out.println(real[i]);
				}
			}
			return ;
		}
		for (int i = start; i < N; i++) {
			real[cnt]=all[i];
			ncr(i+1, cnt+1, tot+all[i]);
			//real[cnt]=0;
		}
	}
}