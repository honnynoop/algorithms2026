import java.util.Scanner;
public class Main {

	static int T;
	static int N;
	static long [] p;
	static int M=1000000;
	static int Q=1_000_000_009;
	public static void main(String[] args) {
		p=new long[M+1]; //
		p[0]=0L;
		p[1]=1L;
		p[2]=2L;
		p[3]=4L;
		for (int i = 4; i <M+1; i++) {
			p[i]=(((p[i-1]%Q+p[i-2]%Q)%Q)%Q+p[i-3]%Q)%Q;
			p[i]=p[i]%Q;
		}
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			System.out.println(p[N]);
		}
	}

}