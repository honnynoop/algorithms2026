import java.util.Scanner;

public class Main {
	static int N;
	static int min;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		min=10000000;
		int cnt=(N+"").length();
		int val=9*cnt;
		for (int i = N-val; i < N; i++) {
			if(i>0) {
				int re=sum(i);
				if(N==(i+re)) {
					min=Math.min(min, (N-re));
				}
			}
		}
		System.out.println(min==10000000?0:min);
	}
	private static int sum(int n) {
		int tot=0;
		while(n>0) {
			tot+=(n%10);
			n/=10;
		}
		return tot;
	}
	
}
