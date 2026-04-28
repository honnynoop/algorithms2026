import java.util.Scanner;

public class Main {
	
	static int[] Timer= {300,60,10};
	static int T;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		int N=Timer.length;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			if(T/Timer[i]==0) {
				sb.append(0+" ");
				continue;
			}else {
				sb.append(T/Timer[i]+" ");
			}
			T-=(T/Timer[i])*Timer[i];
		}
		if(T!=0)System.out.println(-1);
		else System.out.println(sb.toString());
	}

}