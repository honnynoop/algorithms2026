import java.util.Scanner;
// 1은 땅, 0은 바다이다.
public class Main {

	static int W, H;
	static int [][] map;
	static int[] dy= {-1,-1,0,1, 1,1, 0,-1};
	static int[] dx= {0 ,1 ,1,1, 0,-1,-1,-1}; 
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		while(true) {
			W=scann.nextInt();
			H=scann.nextInt();
			if(W==0 && H==0) { break ;}
			map=new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			int cnt=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1){  //새로운 땅에서 시작
						cnt++;
						dfs(i,j,cnt+1);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static int solve(int[] m) {
		int tot=0;
		for (int j = 0; j < m.length; j++) {
			if(m[j]>0){tot++;}
		}
		return tot;
	}
	private static void dfs(int y, int x, int c) {
		map[y][x]=c;
		for (int d = 0; d < 8; d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(!check(ny, nx)){continue; }
			if(map[ny][nx]==1 ){ // 아직 방문안함
				dfs(ny,nx, c);
			}
		}
		
	}
	private static boolean check(int ty, int tx) {
		if(ty>=0 && ty<H && tx>=0 && tx<W) {
			return true;
		}else return false;
	}
}