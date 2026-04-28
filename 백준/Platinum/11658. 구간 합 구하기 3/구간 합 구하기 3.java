import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] a;
	static int [][] tree;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		a=new int[N+1][N+1];
		tree=new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				a[i][j]=scann.nextInt();
				update(i,j,a[i][j]);
			}
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M; i++) {
			//w, x, y, c 
			//w, x1, y1, x2, y2 
			int w=scann.nextInt();
			if(w==0) {
				int x=scann.nextInt();
				int y=scann.nextInt();
				int c=scann.nextInt();
				int temp=a[x][y];
				a[x][y]=c;
				update(x,y,c-temp);
			}else if(w==1) {
				int x1=scann.nextInt();
				int y1=scann.nextInt();
				int x2=scann.nextInt();
				int y2=scann.nextInt();
				int sum=sum(x1,y1,x2,y2);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void update(int i,int jj, int diff) {
		while(i<N+1) {
			int j=jj;
			while(j<N+1) {
				tree[i][j]+=diff;
				j+=( j & -j);
			}
			i+=( i & -i);
		}
	}
	static int sum(int i, int jj) {
		int result=0;
		while(i>0) {
			int j=jj;
			while(j>0) {
				result+=tree[i][j];
				j-=( j & -j);
			}
			i-=( i & -i);
		}
		return result;
	}
	static int sum(int i1, int j1,int i2, int j2) {
		return sum(i2,j2)-sum(i1-1,j2)-sum(i2,j1-1)+sum(i1-1,j1-1);
	}
}
