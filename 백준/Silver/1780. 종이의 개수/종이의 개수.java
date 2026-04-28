import java.util.Scanner;
public class Main {
	static int N;
	static int[][] map;
	static int M, Z, P; //-1, 0, 1
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		count(0,0,N);
		System.out.println(M);
		System.out.println(Z);
		System.out.println(P);
	}
	private static void count(int r, int c, int n) {
		if(allSame(r,c,n)==-1) {
			M++;
		}else if(allSame(r,c,n)==0) {
			Z++;
		}else if(allSame(r,c,n)==1) {
			P++;
		}else {
			count(r,c+0,n/3);
			count(r,c+n/3,n/3);
			count(r,c+n/3*2,n/3);
			
			count(r+n/3,c+0,n/3);
			count(r+n/3,c+n/3,n/3);
			count(r+n/3,c+n/3*2,n/3);
			
			count(r+n/3*2,c+0,n/3);
			count(r+n/3*2,c+n/3,n/3);
			count(r+n/3*2,c+n/3*2,n/3);
		}
	}
	private static int allSame(int r, int c, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0) continue;
				if(map[r+0][c+0]!=map[r+i][c+j]) return 2;
			}
		}
		return map[r+0][c+0];
	}
}
