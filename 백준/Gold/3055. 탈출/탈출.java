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
	
	static int R,C;
	static char[][] map;
	static Queue<Node> beaver;
	static Queue<Node> water;
	static Queue<Node> water4;
	static int Dy, Dx;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		R=scann.nextInt();
		C=scann.nextInt();
		
		map=new char[R][C];
		beaver=new LinkedList<Node>();
		water=new LinkedList<Node>();
		water4=new LinkedList<Node>();
		
		for (int i = 0; i < R; i++) {
			String s=scann.next();
			char[] c=s.toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=c[j];
				if(map[i][j]=='S'){
					beaver.add(new Node(i,j));
				}
				if(map[i][j]=='D'){
					Dy=i;
					Dx=j;
				}
				if(map[i][j]=='*'){
					water.add(new Node(i,j));
				}
			}
		}
		while(!water.isEmpty()){
			water4.add(water.poll());
		}
		while(true){
			if(beaver.size()==0){
				System.out.println("KAKTUS");
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
	private static int dfsPlay() {
		int size=beaver.size();
		while(size-- >0){
			Node curr=beaver.poll();
			int cy=curr.y;
			int cx=curr.x;
			int depth=curr.distance;
			
			for (int d = 0; d < 4; d++) {
				int ny=cy+dy[d];
				int nx=cx+dx[d];
				if(!check(ny, nx)){ continue; }
				//D을 만나면 
				if(ny==Dy && nx==Dx){
					return depth+1;
				}
				if(map[ny][nx]=='.'){
					map[ny][nx]='S';// 이동 길
					beaver.offer(new Node(ny,nx, depth+1));
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
		
		int size=water4.size();
		while(size-- > 0){
			Node curr4=water4.poll();
			int cy4=curr4.y;
			int cx4=curr4.x;
			int depth4=curr4.distance;
			
			for (int d = 0; d < 4; d++) {
				int ny4=cy4+dy[d];
				int nx4=cx4+dx[d];
				if(!check(ny4, nx4)){
					continue;
				}
				if(map[ny4][nx4]=='.' || map[ny4][nx4]=='S'){
					map[ny4][nx4]='*';
					water.add(new Node(ny4,nx4,depth4+1));
				}
			}
			while(!water.isEmpty()){
				water4.add(water.poll());
			}
		}

	}
}
/*
3 3
D.*
...
.S.

3 3
D.*
...
..S

5 4
.D.*
....
..X.
S.*.
....


*/