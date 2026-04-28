import java.util.Scanner;
public class Main {
	static int N, R=101, W=10;
	static int[][] map;
	static int max=Integer.MIN_VALUE;
	static int maxR, maxC;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[R][R];
		for (int t = 0; t <N; t++) {
			int sc=scann.nextInt();
			int sr=scann.nextInt();
			for (int i = sr; i < sr+W; i++) {
				for (int j = sc; j < sc+W; j++) {
					map[i][j]=1;
				}
			}
		}
/*		
        for (int i = 0; i <R; i++) {
			for (int j = 0; j < R; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		*/
		int answer=0;
		for (int i = 1; i < R; ++i) {
			for (int j = 1; j < R; ++j) {
				if (map[i][j]!=1)continue;
				for (int high = 1; high < R; ++high) {
					int nr = i + high;
					if (nr >= R)break;
					int area = squares(i, j, high);
					answer = Math.max(answer, area);
				}
			}
		}
		System.out.println(answer);
	}
    public static int squares(int r, int c, int high) {
    	int minWidth = 100;
    	for (int i = r; i <r+high ; ++i) {
    		int width = 0;
    		for (int j = c; j < R; ++j) {
    			if (map[i][j]!=1)break;
    			width++;
    		}
    		minWidth = Math.min(minWidth, width);
    	}
    	return minWidth * high;
	}
}
/*
3
3 7
15 7
5 2

*/