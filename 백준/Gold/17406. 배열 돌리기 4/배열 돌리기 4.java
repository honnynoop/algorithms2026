import java.util.Scanner;

public class Main {

	static int N, M,K;
	static int[][] A;
	static int[][] KA;
	static int[][] Copy;
	//하우상좌
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,1,0,-1};

	static int KK; //몇 겹
	static int count;
	
	static int[] num;
	static boolean [] v; 
	static int min;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		K=scann.nextInt();
		A=new int[N][M];
		Copy=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j]=scann.nextInt();
			}
		}
		KA=new int[K][3];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 3; j++) {
				KA[i][j]=scann.nextInt();
			}
		}
		//로직
		count=0;
		min=Integer.MAX_VALUE;
		num=new int[K];
		v=new boolean[K];
		nPr(0);
		System.out.println(min);
	}
	static void nPr(int cnt) {
		if(K==cnt) {
			// 새로 초기화 깊은복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					Copy[i][j]=A[i][j];
				}
			}
			for (int i = 0; i <num.length; i++) {
				colck(num[i]);
				//print();
				//System.out.println("-----------------");
			}
			min=Math.min(min, calculate());
			
			//System.out.println("===============");
			return ;
		}
		for (int i = 0; i < K; i++) {
			if(v[i]) continue;
			v[i]=true;
			num[cnt]=(i);
			nPr(cnt+1);
			v[i]=false;
		}
	}
	static void colck(int ika) {
		int [] kmap=KA[ika];
		int sr=(kmap[0]-kmap[2])-1;
		int sc=(kmap[1]-kmap[2])-1;
		int er=(kmap[0]+kmap[2])-1;
		int ec=(kmap[1]+kmap[2])-1;
		int k2=Math.min((er-sr), (ec-sc))/2;  // 몇 겹
		//System.out.println(ika+": "+sr+" "+sc+" "+er+" "+ec);
		for (int boundary = 0; boundary <k2; boundary++) {  // 겹
			int r=boundary+sr;  // 시작위치 (0,0)->(1,1)
			int c=boundary+sc;
			int d=0; // 하
			int temp=Copy[r][c];
			while(d<4) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if( nr>=boundary+sr && nr<er+1-boundary
						&& nc>=boundary+sc && nc<ec+1-boundary) {
					Copy[r][c]=Copy[nr][nc];
					r=nr;
					c=nc;
				}else {
					// 방향
					d++;
				}
			}
			Copy[boundary+sr][boundary+sc+1]=temp;
		}
	}
	static int calculate() {
		int minC=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum=0;
			for (int j = 0; j < M; j++) {
				sum+=Copy[i][j];
			}
			minC=Math.min(minC, sum);
			//System.out.println(minC);
		}
		return minC;
	}
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(Copy[i][j]+" ");
			}
			System.out.println();
		}
	}
}
