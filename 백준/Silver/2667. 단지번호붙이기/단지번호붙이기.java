import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			String s=br.readLine().trim();
			char[] cs=s.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j]=cs[j]-'0';
			}
		}
		//print();
		
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					cnt++;
					bfs(i,j,cnt+1);
				}
			}
		}
		System.out.println(cnt);
		//print();
		int [] res=new int[cnt];
		for (int k = 2; k <2+cnt; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==k) {
						res[k-2]++;
					}
				}
			}
		}
		//정렬
		Arrays.sort(res);
		for (int a: res) {
			System.out.println(a);
		}

	}
	
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};//우좌상하
	
	private static void bfs(int r, int c, int ct) {
		Queue<int[]> que=new LinkedList<>();
		que.offer(new int[] {r,c});
		map[r][c]=ct;
		while(!que.isEmpty()) {
			int [] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc)) {continue;}
				if(map[nr][nc]==1) {
					map[nr][nc]=ct;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			return true;
		}else return false;
	}



	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
