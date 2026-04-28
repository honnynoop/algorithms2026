import java.util.Scanner;
public class Main {

	static int T;
	static int N;
	static long [] p;
	public static void main(String[] args) {
		p=new long[40+1];
		p[0]=0L;
		p[1]=1L;
		for (int i = 2; i <41; i++) {
			p[i]=p[i-1]+p[i-2];
		}
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			if(N==0) {
				System.out.println(1+" "+0);
			}else {
				System.out.println(p[N-1]+" "+p[N]);
			}
		}
	}

}