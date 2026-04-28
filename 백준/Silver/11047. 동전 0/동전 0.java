import java.util.Scanner;

public class Main {

	static int N,K;
	static int[] money;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		money=new int[N];
		for (int i = 0; i < N; i++) {
			money[i]=scann.nextInt();
		}
		int index=N-1;
		for (int i = 0; i < N; i++) {
			if(money[i]>K) {
				index=i-1;
				break;
			}
		}
		int cnt=0;
		for (int i = index; i >=0; i--) {
			cnt+=(K/money[i]);
			K=(K-(K/money[i])*money[i]);
			if(K==0) break;
		}
		System.out.println(cnt);
	}

}