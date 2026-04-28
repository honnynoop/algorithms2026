import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static int N;
	static int[][] map;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		min=Integer.MAX_VALUE;
		visited=new boolean[N];
		
		nCr(0,0);
		System.out.println(min);
	}
	private static void nCr(int cnt, int start) {
		
		if(cnt==N/2){
			int []A=new int[N/2];
			int []B=new int[N/2];
			int m=0,n=0;
			for (int i = 0; i < N; i++) {
				if(visited[i]){
					A[m++]=i;
				}else{
					B[n++]=i;
				}
			}
			//System.out.println(Arrays.toString(A));
			//System.out.println(Arrays.toString(B));
			int sA=0;
			int sB=0;
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					sA+=map[A[i]][A[j]]+map[A[j]][A[i]];
					sB+=map[B[i]][B[j]]+map[B[j]][B[i]];
				}
			}
			//System.out.println(sA+" "+sB);
			min=Math.min(min, Math.abs(sA-sB));
			return ;
		}
		for (int i = start; i < N; i++) {
			if(!visited[i]){
				visited[i]=true;
				nCr(cnt+1, i+1);
				visited[i]=false;
			}
		}
	}
}
