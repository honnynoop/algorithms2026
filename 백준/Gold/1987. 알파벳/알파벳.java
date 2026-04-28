import java.util.Scanner;

public class Main {

    static int R, C, ans;
    static char[][] map;
    static boolean [] alpha;
    static boolean v[][];
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		R=scann.nextInt();
		C=scann.nextInt();
		alpha=new boolean[26];
		map=new char[R][C];
		v=new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i]=scann.next().toCharArray();
		}
		ans=0;
		dfs(0,0,1);
		System.out.println(ans);
		
	}

	public static void dfs(int r, int c, int cnt) {
		
		
		if(ans<cnt){
			ans=cnt;
		}
		if(cnt==26){ return ;}
		
		v[r][c]=true;
		alpha[map[r][c]-'A']=true;
		
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc)){
				continue;
			}
			if(!alpha[map[nr][nc]-'A'] && !v[nr][nc]){
				v[nr][nc]=true;
				alpha[map[nr][nc]-'A']=true;
				dfs(nr,nc,cnt+1);
				v[nr][nc]=false;
				alpha[map[nr][nc]-'A']=false;
			}
		}

	}

	public static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C){
			return true;
		}else return false;
	}

}