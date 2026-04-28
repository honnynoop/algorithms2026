import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int M,N,K,W;
	static int[][] map;
	static int[][] tomap;
	static int[][] nmap;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		M=scann.nextInt();
		N=scann.nextInt();
		K=scann.nextInt();
		W=scann.nextInt();
		map=new int[M][N];
		nmap=new int[M][N];
		tomap=new int[M-W+1][N-W+1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		
		for (int i = 0; i < M-W+1; i++) {
			for (int j = 0; j < N-W+1; j++) {
				int[][] cp=new int[W][W];
				copy(map,cp,i,j,0,0,W);
				int[] one=toO(cp,W);
				Arrays.sort(one);
				int md=one[(one.length-1)/2];
				tomap[i][j]=md;
			}
		}
		print(tomap);
		
		
/*		print(map);
		copy(map,tomap, 1,1,3);
		print(tomap);
		copy(map,nmap, 1,1,2,2,3);
		print(nmap);*/
	}
	
	public static int[] toO(int[][]m,int w){
		int[] t=new int[w*w];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				t[i*w+j]=m[i][j];
			}
		}
		return t;
	}
	public static int[][] toT(int[]m,int w){
		int[][] t=new int[w][w];
		for (int i = 0; i < m.length; i++) {
			t[i/w][i%w]=m[i];
		}
		return t;
	}
	
	public static void copy(int[][] m,int [][]n, int sy,int sx,int w){
		for (int i = 0; i < w; i++) {
			System.arraycopy(m[i+sy], sx, n[i], 0, w);
		}
	}
	public static void copy(int[][] m,int [][]n, int sy,int sx,int tx,int ty,int w){
		for (int i = 0; i < w; i++) {
			System.arraycopy(m[i+sy], sx, n[i+ty], tx, w);
		}
	}
	public static void print(int [][]m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		//System.out.println("--------------------");
	}
	
	

}