
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int T=10007;
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int[] p=new int[N+2];
		p[1]=1;
		p[2]=3;
		for (int i = 3; i <N+1; i++) {
			p[i]=((p[i-1]%T)+(2*(p[i-2]%T))%T)%T;
		}
		System.out.println(p[N]);
	}
}
