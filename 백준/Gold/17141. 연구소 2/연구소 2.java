import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int K;//2의 개수
	static ArrayList<int[]> twos=new ArrayList<>();
	
	static int [][] map;
	static int [][] copy;
	
	static int [] dr={-1,0,1,0};
	static int [] dc={0,1,0,-1};//상우하좌
	
	static int min;
	static int count;
	public static void main(String[] args) {
	
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][N];
		copy=new int[N][N];
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==2){   //1) 2인 위치 저장
					twos.add(new int[]{i,j});
				}
			}
		}
		//읽기 끝
		min=Integer.MAX_VALUE;
		K=twos.size(); // 2의 개수
		// 세개의 인덱스를 찾아서 
		combi(0,0,new int[M]);  // M개의 선택바이러스 /K개에서
		System.out.println(Integer.MAX_VALUE==min?-1:min);
	}

	private static void combi(int start, int cnt, int[] nums) {
		if(cnt==M){
			// 로직----------------------------
			// 깊은 복사
			copy(map,copy);
			// 벽설치
			wall(copy, nums);  // K개의 벽에서 선택한 M개의 바이러스위치
			// virus go -> bfs
			go(nums);
			// 카운드 - copy에서 0의 개수를 세자.
			int res=count(copy);
			min=Math.min(min, res);
			return ;
		}
		//서로 다른  K개에서 M선택
		for (int i = start; i < K; i++) {
			nums[cnt]=i;
			combi(i+1, cnt+1,nums);
		}
		
	}
	


	private static int count(int[][] co) {
		int tmax=-1;
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if(co[i][j]==-2) return Integer.MAX_VALUE;
				tmax=Math.max(tmax, co[i][j]);
			}
		}
		return tmax;
	}

	private static void go(int[] numss) {
		Queue<int[]> que=new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int [] cur=twos.get(numss[i]);
			que.offer(new int[]{cur[0],cur[1]});
			copy[cur[0]][cur[1]]=0;
		}
		while(!que.isEmpty()){
			int[] cu=que.poll();
			int cr=cu[0];
			int cc=cu[1];
			// 4방탐색해서 온적 없다면
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc))continue;
				if(copy[nr][nc]==-2){  // 온적 없다. empty -2
					que.offer(new int[]{nr,nc});
					copy[nr][nc]=copy[cr][cc]+1;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	private static void wall(int[][] co, int[] nums) {
		// 모든 바이러스 삭제
		for (int i = 0; i < K; i++) {
			int [] cu=twos.get(i);
			int r=cu[0];
			int c=cu[1];
			co[r][c]=-2;// 바이러스 삭제
		}
	}

	//깊은복사
	private static void copy(int[][] ma, int[][] co) {
		for (int i = 0; i <N; i++) {
			//System.arraycopy(ma[i], 0, co[i], 0, N);
			for (int j = 0; j < N; j++) {
				if(ma[i][j]==1) {
					co[i][j]=-1;// 벽
				}else if(ma[i][j]==0) {
					co[i][j]=-2;// empty
				}
			}
		}
	}

}