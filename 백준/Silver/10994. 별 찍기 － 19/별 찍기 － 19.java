import java.util.Scanner;
public class Main {

	static int[][] star;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		//별을 만든 후 찍겠다. 등차수열 구하기
		star=new int[4*N-3][4*N-3];
		//로직
		star(0,0,4*N-3); //재귀 
		//출력
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < 4*N-3; i++) {
			for (int j = 0; j < 4*N-3; j++) {
				sb.append(star[i][j]==1?"*":" ");
				//System.out.print(star[i][j]==1?"*":" ");//공백없이 붙여서
			}
			//System.out.println();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void star(int r, int c, int n) {
		if(n>0) { // 양수면 계속 실행
			//0행
			for (int j = 0; j < n; j++) {
				star[r][c+j]=1;
			}
			//n-1행
			for (int j = 0; j < n; j++) {
				star[r+n-1][c+j]=1;
			}
			//0열
			for (int j = 0; j < n; j++) {
				star[r+j][c]=1;
			}
			//n-1 열
			for (int j = 0; j < n; j++) {
				star[r+j][c+n-1]=1;
			}
			// 시작점이 (2,2)씨 이동
			star(r+2,c+2,n-4);//재귀 
		}
	}
}
