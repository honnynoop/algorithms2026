import java.util.Scanner;

public class Main {

	static int N, L , M;
	static int[][] map;
	static int[][] fish;
	static int max;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		L=scann.nextInt();
		M=scann.nextInt();
		map=new int[M][2];
		
		for (int i = 0; i <M; i++) {
			int y=scann.nextInt()-1;
			int x=scann.nextInt()-1;
			map[i][0]=y;
			map[i][1]=x;
		}
		max=Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				for (int w = 1; w < L/2; w++) {
					dfs(map[i][0],map[j][1],w,L/2-w);
				}
			}
		}
		System.out.println(max);
	}
	private static void dfs(int y, int x, int yy, int xx) {
		int cnt=0;
		for(int i=0; i<M; i++){
			if(x<=map[i][1] && map[i][1]<=x+xx && y<=map[i][0] && map[i][0]<=y+yy)
				cnt++;
			max=Math.max(max, cnt);
		}
	}
}
/*

0 0 0 0 0 0 0
0 1 0 1 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 1 0
0 1 0 0 0 0 0
0 0 0 1 0 0 0


7 10 6
2 2
2 4
6 2
7 4
3 3
5 6

0 0 0 0 0
0 0 0 0 1
0 0 0 1 1
0 0 0 1 1
0 0 1 0 0

5 8 6
2 5
3 4
3 5
4 4
4 5
5 3


7 10 10
2 2
2 4
6 2
7 4
3 3
5 6
5 7
6 6
6 7
7 5

7 7
2 3
0 0 0 0 0 0 0
0 1 0 1 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 1 1
0 0 0 1 1 0 0






*/