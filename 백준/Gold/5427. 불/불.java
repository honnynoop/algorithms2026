import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node{
		int y;
		int x;
		int distance;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Node(int y, int x, int distance) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
		
	}
	static int[] dy={-1,1,0,0};
	static int[] dx={0,0,-1,1}; 
	
	static int T,R,C;
	static char[][] map;
	static Queue<Node> player;
	static Queue<Node> fire;
	static Queue<Node> fire4;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			C=scann.nextInt();
			R=scann.nextInt();
			map=new char[R][C];
			player=new LinkedList<Node>();
			fire=new LinkedList<Node>();
			fire4=new LinkedList<Node>();
			
			for (int i = 0; i < R; i++) {
				String s=scann.next();
				char[] c=s.toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j]=c[j];
					if(map[i][j]=='@'){
						player.add(new Node(i,j));
					}
					if(map[i][j]=='*'){
						fire.add(new Node(i,j));
					}
				}
			}
			while(!fire.isEmpty()){
				fire4.add(fire.poll());
			}
			while(true){
				if(player.size()==0){
					System.out.println("IMPOSSIBLE");
					break;
				}
				
				dfsFire();
				int count=dfsPlay();
				if(count>0){
					System.out.println(count);
					break;
				}
			}
		}
		
	}
	private static int dfsPlay() {
		int size=player.size();
		while(size-- >0){
			Node curr=player.poll();
			int cy=curr.y;
			int cx=curr.x;
			int depth=curr.distance;
			//벽을 만나면 
			if(cy==0 || cy==R-1 || cx==0 || cx==C-1){
				return depth+1;
			}
			for (int d = 0; d < 4; d++) {
				int ny=cy+dy[d];
				int nx=cx+dx[d];
				if(!check(ny, nx)){ continue; }
				
				if(map[ny][nx]=='.'){
					map[ny][nx]='@';// 이동 길
					player.offer(new Node(ny,nx, depth+1));
				}
			}
		}
		return -1;
	}
	private static boolean check(int ty, int tx) {
		if(ty>=0 && ty<R && tx>=0 && tx<C) {
			return true;
		}else return false;
	}
	private static void dfsFire() {
		
		int size=fire4.size();
		while(size-- > 0){
			Node curr4=fire4.poll();
			int cy4=curr4.y;
			int cx4=curr4.x;
			int depth4=curr4.distance;
			
			for (int d = 0; d < 4; d++) {
				int ny4=cy4+dy[d];
				int nx4=cx4+dx[d];
				if(!check(ny4, nx4)){
					continue;
				}
				if(map[ny4][nx4]=='.' || map[ny4][nx4]=='@'){
					map[ny4][nx4]='*';
					fire.add(new Node(ny4,nx4,depth4+1));
				}
			}
			while(!fire.isEmpty()){
				fire4.add(fire.poll());
			}
		}

	}
}
/*
5
4 3
####
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###

*/