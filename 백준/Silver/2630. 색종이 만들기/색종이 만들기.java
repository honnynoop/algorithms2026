import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static int ansW, ansB;
	//파1 하0
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		ansW=0;
		ansB=0;
		colorPaper(0,0,N);
		System.out.println(ansW);
		System.out.println(ansB);
	}
	public static void colorPaper(int r, int c, int width) {
		if(width==1 || sameColor(r,c,width)){
			if(map[r][c]==0){
				ansW++;
			}else if(map[r][c]==1){
				ansB++;
			}
			return ;
		}
		int w=width/2;
		colorPaper(r, c, w);     //11
		colorPaper(r, c+w, w);   //1
		colorPaper(r+w, c, w);   //7
		colorPaper(r+w, c+w, w); //5
	}
	public static boolean sameColor(int r, int c, int width) {
		for (int i = r; i < r+width; i++) {
			for (int j = c; j < c+width; j++) {
				if(map[i][j]!=map[r][c]){ return false; }
			}
		}
		return true;
	}

}
/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1

*/