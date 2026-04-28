
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int [] dr={-1,0,1, 0};
	static int [] dc={ 0,1,0,-1};
	static int N, M;
	static int sr, sc;
	static int[][] map;
	static int[] keys;
	static int min=Integer.MAX_VALUE;
	static boolean [][][] visited;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		visited = new boolean[N][M][0b111111 + 1];
		for (int i = 0; i < N; i++) {
			char[] cs=scann.next().toCharArray();
			for (int j = 0; j < M; j++) {
				
				if(cs[j]=='0'){
					sr=i;
					sc=j;
					map[i][j]=0;
				}
				if(cs[j]=='1'){
					map[i][j]=1;
				}
				if(cs[j]>='A' && cs[j]<='F'){
					map[i][j]=cs[j]-'A'+10;
				}
				if(cs[j]>='a' && cs[j]<='f'){
					map[i][j]=cs[j]-'a'+4;
				}

				if(cs[j]=='.'){
					map[i][j]=2;
				}
				if(cs[j]=='#'){
					map[i][j]=3;
				}
			}
		}
/*		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}*/
		min=Integer.MAX_VALUE;
		bfs();
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static boolean check(int r, int c){
		return r>=0 && r<N && c>=0 && c<M;
	}
	static void bfs() {
		Queue<int[]> que=new LinkedList<int[]>();
		que.add(new int[]{sr,sc,0,0});//r,c,depth, key
		visited[sr][sc][0]=true;// r,c, key
		while(!que.isEmpty()){
			int[] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1]; 
			int cd=cur[2]; //distance
			int ck=cur[3]; //key
			
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				int nk=ck;
				//경계안
				if(check(nr,nc)){
					// 목표지점에 도착했다면 거리를 반환
					if(map[nr][nc]==1 ){
						min=cd+1;
						return ;
					}
					
					//벽 #
					if(map[nr][nc]==3)  continue;
					
					//열쇠없이 문통과 못함
					
					if(map[nr][nc]>=10 && map[nr][nc]<=15){//문을 통과할 때 
						if ((ck & (1 << (map[nr][nc]-10))) == 0) {
                            continue;
                        }
					}
					// 열쇠면 
					if(map[nr][nc]>=4 && map[nr][nc]<=9){
						nk=ck | (1 << (map[nr][nc]-4));
					} 
					// 방문한적 있나  123456
					if(visited[nr][nc][nk])  continue;
					//System.out.println(nr+" "+nc+" "+(cd+1)+" "+ck);
					// 이동 및 반영
					visited[nr][nc][ck]=true; // r,c, key
					que.add(new int[]{nr,nc,cd+1,nk});//r,c,depth, key
				}

			}
		}
	}
}
