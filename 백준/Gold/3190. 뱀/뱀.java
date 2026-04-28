import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static class Snake{
		int r;
		int c;
		public Snake() {
		}
		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static class Turns{
		int time;
		char direct;
		public Turns(int time, char direct) {
			super();
			this.time = time;
			this.direct = direct;
		}
		public Turns() {
		}
		@Override
		public String toString() {
			return "Turns [time=" + time + ", direct=" + direct + "]";
		}
		
	}
	// d 0우 1하 2좌 3상
	static int [] dr={0,1, 0,-1 };
	static int [] dc={1,0,-1,0 };
	
	public static int turn(char c, int d){
		if(c=='D'){
			return turnD(d);
		}else{
			return turnL(d);
		}
	}
	public static int turnD(int d){
		return (d+1)%4;
	}
	public static int turnL(int d){
		return (d+3)%4;
	}
	public static boolean isIn(int r, int c){
		return r>=1 && r<=N && c>=1 && c<=N;
	}
	static int N, K,L, cnt;
	static int[][] map;
	static ArrayList<Snake> snakes=new ArrayList<>();
	static ArrayList<Turns> turns=new ArrayList<>();
	public static void main(String[] args) {
		
		snakes.clear();
		turns.clear();
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		map=new int[N+2][N+2];
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(map[i], 2);
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j]=0;
			}
		}
		
		for (int i = 0; i < K; i++) {
			int r=scann.nextInt();
			int c=scann.nextInt();
			map[r][c]=1;// 사과
		}
		L=scann.nextInt();
		for (int i = 0; i < L; i++) {
			int x=scann.nextInt();
			char c=scann.next().charAt(0);
			turns.add(new Turns(x, c));
		}	
		cnt=0;
		solve(1, 1,0);
		System.out.println(cnt);
		
	}

	private static boolean isFinish(int r, int c) {
		if(!isIn(r, c)){
			return true;
		}
		for (int i = 0; i < snakes.size(); i++) { 
			Snake sn = snakes.get(i); 
			if (sn.r== r && sn.c == c) return true; 
		} 
		return false; 
	}

		
	static void solve(int cr, int cc, int cd) {
		// no r=1 c=1  dir 우  time 1
		snakes.add(new Snake(1, 1));  // 시간 1로 설정
		int turn=0;
		for (int i = 1; i <= 10000; i++) {// 시간
			cnt++;
			int nr=cr+dr[cd];
			int nc=cc+dc[cd];
			if(isFinish(nr,nc)){ return ;}
			//사과를 먹음
			if(map[nr][nc]==1){
				map[nr][nc]=0;
				snakes.add(new Snake(nr, nc));
			}else{
				snakes.add(new Snake(nr, nc));
				snakes.remove(0);  //꼬리 제거
			}
			// 위치  이동
			cr=nr;
			cc=nc;
			if(turn<L){
				if(cnt==turns.get(turn).time){
					// 방향 변경
					cd=turn(turns.get(turn).direct,cd);
					turn++;
				}
			}
		}
	}
}
