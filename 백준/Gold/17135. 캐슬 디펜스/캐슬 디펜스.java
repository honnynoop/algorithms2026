import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static class E{
		int r; int c;

		public E(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, D;  //행 열 사격거리
	static int [][] map;
	static int G=3;  // 궁수병
	static int maxR;
	static ArrayList<E> enemies;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		enemies=new ArrayList<>();
		
		N=scann.nextInt();
		M=scann.nextInt();
		D=scann.nextInt();
		map=new int[N][M]; 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==1){
					enemies.add(new E(i,j));
				}
			}
		}
		maxR=Integer.MIN_VALUE;
		// i< j < k 서로 다른 세수 (N,i) (N,j) (N,k) 에 궁수배치와 
		// 계산 을 함께
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
				for (int k = j+1; k < M; k++) {
					maxR=Math.max(maxR, go(i,j,k));
				}
			}
		}
		System.out.println(maxR);
	}

	public static int go(int ... c) {  //배열 아닌데 배열처럼 사용하자. 
		int tot=0;
		// 적의 위치를 받는다. 적은 계속 아래로 이동한다. 
		ArrayList<E> copies=new ArrayList<>();
		for (int i = 0; i < enemies.size(); i++) {
			//깊은 복사
			copies.add(new E(enemies.get(i).r,enemies.get(i).c));//명주씨가 찾음
		}
		//적이 없어질 때까지 
		while(copies.size()!=0){
			ArrayList<E> temp=new ArrayList<>();  //살생부
			// 그놈 궁수 c1, c2, c3에서  사정거리안에 있어? 
			for (int i = 0; i < c.length; i++) {
				// 사정거리 안에 있으면 상생부에 적어놔 
				int t=findNear(copies,c[i]); // 한 궁수에서 적을 한놈씩 비교해서 거리에 있는놈
				if(t!=-1){
					temp.add(copies.get(t)); // t 번째 있는 놈 살생부
				}
			}
			// 살생부있는 놈들 제거 그리고 수확인
			for (E e : temp) {
				if(copies.remove(e)) tot++;
			}
			// 적군들 하강 -> N번 위치 제거 remove(그놈)
			downEnemies(copies);
		}
		return tot;
	}
	public static void downEnemies(ArrayList<E> copies) {
		for (int i=0; i<copies.size(); i++) {
			E e=copies.get(i);
			//한 놈씩 성에 도착한몬 제거
			e.r++;
			if(e.r==N){
				copies.remove(i);
				i--;
			}
		}
/*		ArrayList<E> temp=new ArrayList<>();
		for (int i=0; i<copies.size(); i++) {
			E e=copies.get(i);
			e.r++;
			if(e.r==N){
				temp.add(e);// 우리반의 명단을 옆에 적어놔
			}
		}
		for (E e : temp) {  // 옆에 적어놓은 이름 우리반에서 제거
			copies.remove(e);
		}*/
		
	}

	public static int distance(E e1, E e2){
		return Math.abs(e1.r-e2.r)+Math.abs(e1.c-e2.c);
	}
	public static int findNear(ArrayList<E> copies, int c) {
		int res=-1; // 없으면 -1
		int dist=11; //D보다 작은 수를 임으로 선택 
		int minC=50; //2N보다 크게 선택
		//(N,c)위치에 궁수가 있다. 이 궁수와 적중에서 범위내 적을 찾는다. 
		for (int i = 0; i < copies.size(); i++) {
			E e=copies.get(i);// 한 놈 가져와
			int d=distance(e, new E(N,c));
			if(d>D) continue; //거리 밖 다른 놈
			if(d<dist){
				dist=d;
				minC=e.c;
				res=i; // i번째 적
			}else if(d==dist){  // 같은 거리의 적이 있다면 ---> 중요 함정 
				// c가 작은 것을 선택
				if(minC>e.c){
					minC=e.c;
					res=i;
				}
			}
		}
		return res;
	}

}