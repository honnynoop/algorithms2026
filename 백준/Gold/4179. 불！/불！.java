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
	static int min;
	static Queue<Node> player;
	static Queue<Node> fire;
	static Queue<Node> fire4;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		R=scann.nextInt();
		C=scann.nextInt();
		map=new char[R][C];
		player=new LinkedList<Node>();
		fire=new LinkedList<Node>();
		fire4=new LinkedList<Node>();
		
		for (int i = 0; i < R; i++) {
			String s=scann.next();
			char[] c=s.toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=c[j];
				if(map[i][j]=='J'){
					player.add(new Node(i,j));
				}
				if(map[i][j]=='F'){
					fire.add(new Node(i,j));
				}
			}
		}
		while(!fire.isEmpty()){
			fire4.add(fire.poll());
		}
		
		int ans=0;
		a: while(true){

	        int firesize = fire4.size();
	        while(firesize-- > 0){
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
					if(map[ny4][nx4]=='.' || map[ny4][nx4]=='J'){
						map[ny4][nx4]='F';
						fire.add(new Node(ny4,nx4,depth4+1));
					}
				}
				while(!fire.isEmpty()){
					fire4.add(fire.poll());
				}
			}
	        
	        int playsize = player.size();
	        boolean isS=false;
	        while(playsize-- >0){
				Node curr=player.poll();
				int cy=curr.y;
				int cx=curr.x;
				int depth=curr.distance;
				if(cy==0 || cy==R-1 || cx==0 || cx==C-1){
					isS=true;
					System.out.println(ans+1);
					break a;
				}
				for (int d = 0; d < 4; d++) {
					int ny=cy+dy[d];
					int nx=cx+dx[d];
					if(!check(ny, nx)){ continue; }
					
/*					if(map[ny][nx]=='.' && (ny==0 || ny==R-1 || nx==0 || nx==C-1)){
						isS=true;
						System.out.println(ans);
						break a;
					}*/
					if(map[ny][nx]=='.'){
						map[ny][nx]='J';// 이동 길
						player.offer(new Node(ny,nx, depth+1));
					}
				}
			}
			ans++;
	        if(!isS){
	        	 playsize = player.size();
				if(player.size()==0){
					System.out.println("IMPOSSIBLE");
					break;
				}
	        }
		}
	}

	private static boolean check(int ty, int tx) {
		if(ty>=0 && ty<R && tx>=0 && tx<C) {
			return true;
		}else return false;
	}
}
/*
4 4
####
#JF#
#..#
#..#

4 4
####
#JF#
#..#
#F.#

4 4
####
.JF#
#..#
#..#

4 4
####
J.F#
#..#
#..#


4 6
######
#J.F.#
#...F#
#....#

*/