import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class Main {

	public static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int d;
		
		public Fish() {
		}
		
		public Fish(int r, int c, int size, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.d = distance;
		}

		@Override
		public int compareTo(Fish o) {
			int rd=Integer.compare(this.d, o.d);
			int rr=Integer.compare(this.r, o.r);
			int rc=Integer.compare(this.c, o.c);
			if(rd==0) {
				if(rr==0) {
					if(rc==0) {
						return 0;
					}else return rc;
				}else return rr;
			}else return rd;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", distance=" + d + "]";
		}
	
	}
	public static class Shark{
		int r;
		int c;
		int size;
		int qunt;
		int time;
		public Shark(int r, int c, int size, int qunt, int time) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			if(size==qunt){
				this.size++;
				this.qunt = 0;
			}else{
				this.qunt = qunt;
			}
			
			this.time = time;
		}
		public Shark() {
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", size=" + size + ", qunt=" + qunt + ", time=" + time + "]";
		}
	}
	static int N;
	static int [][] map;
	static int [][] v;
	static List<Fish> fishq=new ArrayList<Fish>();
	static ArrayList<Fish> ff=new ArrayList<>();
	static Shark shark;
	static int cnt;
	
	static int[] dr={-1,0,0,1};
	static int[] dc={0,-1,1,0};
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==9){
					shark=new Shark(i,j,2,0,0);
				}
			}
		}
		cnt=0;
		bfs();
		System.out.println(cnt);
	}
	private static int distance(int sr, int sc, int er, int ec, int size){
		int[][] b=new int[N][N];
		Queue<Fish> que=new LinkedList<>();
		que.offer(new Fish(sr,sc, size,0));
		b[sr][sc]=1;
		while(!que.isEmpty()){
			Fish cf=que.poll();
			int cr=cf.r;
			int cc=cf.c;
			int csize=cf.size;
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				
				if(!check(nr,nc) ){continue; }
				if(b[nr][nc]==0 && (csize>=map[nr][nc])){
					if(er==nr && ec==nc){ 
						return b[cr][cc];
					}
					
					b[nr][nc]=b[cr][cc]+1;
					que.offer(new Fish(nr,nc,csize,0));
				}
			}
		}//
		return -1;
	}
	private static void bfs() {
		
		fishq.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0 && map[i][j]<7){
					fishq.add(new Fish(i,j,map[i][j],0));
				}
			}
		}
		ff.clear();
		for (int i = 0; i < fishq.size(); i++) {
			Fish sfish=fishq.get(i);
			if(sfish.size<shark.size){
				int kk=distance(shark.r, shark.c, sfish.r, sfish.c, shark.size);
				if(kk!=-1){
					sfish.d=kk;
					ff.add(sfish);
				}
			}
		}
		
		if(ff.size()==0){
			return ;
		}else{
			Collections.sort(ff);
			Fish tfish=ff.get(0);
			int distance=tfish.d;
			int tr=tfish.r;
			int tc=tfish.c;
			int sr=shark.r;
			int sc=shark.c;
			shark=new Shark(tr, tc, shark.size, shark.qunt+1, shark.time+distance);
			map[sr][sc]=0;
			map[tr][tc]=9;
			cnt=shark.time;
			bfs();
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N){return true;
		}else return false;
	}
}