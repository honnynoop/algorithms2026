import java.util.Scanner;

public class Main {

	static int N,M,R;
	static int[][] map;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static int[] op;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		R=scann.nextInt();
		map=new int[N][M];
		//input
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		op=new int[R];  // 실행1~6
		for (int i = 0; i < R; i++) {
			op[i]=scann.nextInt();
		}
		//연산
		for (int i = 0; i < R; i++) {
			operation(op[i]);
		}
		//정답출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
	}

	private static void operation(int ops) {
		switch (ops) {
			case 1:operations1();break;
			case 2:operations2();break;
			case 3:operations3();break;
			case 4:operations4();break;
			case 5:operations5();break;
			case 6:operations6();break;
		}
	}

	private static void operations1() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int temp=map[i][j];
				map[i][j]=map[N-i-1][j];
				map[N-i-1][j]=temp;
			}
		}
	}
	private static void operations2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp=map[i][j];
				map[i][j]=map[i][M-j-1];
				map[i][M-j-1]=temp;
			}
		}
	}
	private static void operations3() {
		int [][] nmap=new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M ; j++) {
				nmap[j][N-i-1]=map[i][j];
			}
		}
		map=nmap;
		int t=M;
		M=N;
		N=t;
	}
	private static void operations4() {
		int [][] nmap=new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M ; j++) {
				nmap[M-j-1][i]=map[i][j];
			}
		}
		map=nmap;
		int t=M;
		M=N;
		N=t;
	}
	private static void operations5() {
		int [][] nmap=new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j <M/2 ; j++) {
				nmap[i][j+M/2]=map[i][j]; //1->2
				nmap[i+N/2][j+M/2]=map[i][j+M/2]; //2->3
				nmap[i+N/2][j]=map[i+N/2][j+M/2]; //3->4
				nmap[i][j]=map[i+N/2][j]; //4->1
			}
		}
		map=nmap;
	}
	private static void operations6() {
		int [][] nmap=new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j <M/2 ; j++) {
				
				nmap[i][j]=map[i][j+M/2]; //2->1
				nmap[i][j+M/2]=map[i+N/2][j+M/2]; //3->2
				nmap[i+N/2][j+M/2]=map[i+N/2][j]; //4->3
				nmap[i+N/2][j]=map[i][j]; //1->4
			}
		}
		map=nmap;
	}
}
