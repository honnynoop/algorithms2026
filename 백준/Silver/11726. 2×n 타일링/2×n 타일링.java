import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int T=10007;
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int[] p=new int[N+2];
		p[1]=1;
		p[2]=2;
		for (int i = 3; i < N+1; i++) {
			if(i%2==0) {
				p[i]=((p[i/2]%T)*(p[i/2]%T)%T+((p[i/2-1]%T)*(p[i/2-1]%T)%T)%T)%T;
			}else {
				p[i]=((p[i-1]%T)+(p[i-2]%T))%T;
			}
		}
		System.out.println(p[N]);
	}
}