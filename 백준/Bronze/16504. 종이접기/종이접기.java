import java.util.Scanner;

public class Main {

	//static int [][] map;
	static int N;
	static long tot=0L;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		//map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int s=scann.nextInt();
				tot+=s;
			}
		}
		System.out.println(tot);
	}

}