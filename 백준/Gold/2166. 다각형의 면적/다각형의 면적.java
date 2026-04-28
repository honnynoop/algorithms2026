import java.util.Scanner;

public class Main {

	static int N;
	static int[][] m;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		m=new int[N][2];

		for (int i = 0; i < N; i++) {
			m[i][0]=scann.nextInt();
			m[i][1]=scann.nextInt();
		}
		double area=0.0;
		int j=N-1;
		for (int i = 0; i <N; i++) {
			area+=1.0*(m[j][0]+m[i][0])*(m[j][1]-m[i][1]);
			j=i;
		}
		System.out.printf("%.1f\n",Math.abs(0.5*area));
	}
	
}