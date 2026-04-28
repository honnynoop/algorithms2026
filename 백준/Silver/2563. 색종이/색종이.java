import java.util.Scanner;

public class Main {

	static int L=100+2;
	static int[][] map;
	static int N;
	static int[][] loc;
	static int W=10;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[L][L];
		loc=new int[N][2];
		for (int i = 0; i < N; i++) {
			loc[i][0]=scann.nextInt();
			loc[i][1]=scann.nextInt();
		}
		
		for (int i = 0; i < loc.length; i++) {
			int x1=loc[i][0];
			int y1=loc[i][1];
			int y2=y1+10;
			int x2=x1+10;
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x< x2; x++) {
					map[y][x]=1;
				}
			}
			//System.out.println(y1+" "+x1);
		}
		
		int ndis=0;
		for (int i = 1; i < L; i++) {
			for (int j = 1; j < L; j++) {
				if(map[i][j]==1){
					ndis++;
				}
			}
		}
		
		System.out.println(ndis);
		
		
		//print(map);
		
		
	}
	public static void print(int[][] m){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}