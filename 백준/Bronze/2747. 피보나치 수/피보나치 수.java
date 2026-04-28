import java.util.Scanner;
public class Main {
	static int N;
	static long [] p;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		p=new long[45+1];
		p[0]=0L;
		p[1]=1L;
		p[2]=1L;
		p[3]=2L;
		for (int i = 4; i <N+1; i++) {
			p[i]=p[i-1]+p[i-2];
		}
		System.out.println(p[N]);
	}

}