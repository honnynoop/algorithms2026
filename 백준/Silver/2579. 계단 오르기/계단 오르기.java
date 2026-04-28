import java.util.Scanner;

public class Main {

	static int N;
	static int [] f;
	static int [] d;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		f=new int[300+1];
		d=new int[300+1];
		for (int i = 1; i < N+1; i++) {
			f[i]=scann.nextInt();
		}
		
		d[1]=f[1];
		d[2]=f[1]+f[2];
		d[3]=Math.max(f[1], f[2])+f[3];
		for (int i = 4; i < N+1; i++) {
			d[i]=Math.max(d[i-2],d[i-3]+f[i-1])+f[i];
		}
		System.out.println(d[N]);
	}

}