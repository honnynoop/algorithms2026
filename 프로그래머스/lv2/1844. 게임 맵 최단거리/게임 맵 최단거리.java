import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int N;
	static int M;
	static int[] dr= {-1,0,1, 0};
	static int[] dc= { 0,1,0,-1}; // 상우하좌 CW
	public int solution(int[][] maps) {
		N=maps.length;
		M=maps[0].length;
        int answer = bfs(maps);
		return answer;
	}
	//0벽 1길
	public int bfs(int[][] maps) {
		boolean[][] visited=new boolean[N][M];
		Queue<int[]> que=new LinkedList<int[]>();
		que.offer(new int[] {0,0,1});  // 시작이 1
		visited[0][0]=true;
		while(!que.isEmpty()) {
			int[] cur=que.poll();
			int r=cur[0];
			int c=cur[1];
			int distance=cur[2];
			if(r==N-1 && c==M-1) {
				return distance;
			}
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(!check(nr,nc))   continue;
				if(visited[nr][nc]) continue;
				if(maps[nr][nc]==1) {
					visited[nr][nc]=true;
					que.offer(new int[] {nr,nc,distance+1});
				}
				
			}
		}
		return -1;
	}
	public boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
