import java.util.Scanner;
public class Main {

	static int[][] star;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		//별을 만든 후 찍겠다. 
		star=new int[N][N];
		//로직
		star(0,0,N); //분할정복
		//출력
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]==1?"*":" ");
				//System.out.print(star[i][j]==1?"*":" ");//공백없이 붙여서
			}
			//System.out.println();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void star(int r, int c, int n) {
		if(n==3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1) continue;
					star[r+i][c+j]=1;
				}
			}
		}else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1) continue;
					star(r+i*n/3, c+j*n/3,n/3);
				}
			}
		}
	}
}
