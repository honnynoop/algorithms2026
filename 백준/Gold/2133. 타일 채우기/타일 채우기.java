import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N;
	static long [] p;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		p=new long[31];
		N=scann.nextInt();
		p[0]=1;
		p[1]=0;
		p[2]=3;
		for (int i = 4; i < N+1; i++) {
			p[i]=p[i-2]*4-p[i-4];
		}
		System.out.println(p[N]);
	}

}