import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N=9;
	static int R=7;
	static int[] real,result;
	static int[] all;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		all=new int[N];
		real=new int[R];
		result=new int[R];
		for (int i = 0; i < N; i++) {
			all[i]=scann.nextInt();
		}
		ncr(0,0,0);
		Arrays.sort(result);
		for (int i = 0; i < R; i++) {
			System.out.println(result[i]);
		}
	}

	private static void ncr(int start, int cnt, int tot) {
		if(cnt==R) {
			if(tot==100) {
				System.arraycopy(real, 0, result, 0, R);
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