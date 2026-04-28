import java.util.Scanner;
public class Main {

	static int T;
	static int N;
	static long [] p;
	public static void main(String[] args) {
		p=new long[10+1];
		p[0]=0L;
		p[1]=1L;
		p[2]=2L;
		p[3]=4L;
		for (int i = 4; i <11; i++) {
			p[i]=p[i-1]+p[i-2]+p[i-3];
		}
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			System.out.println(p[N]);
		}
	}

}