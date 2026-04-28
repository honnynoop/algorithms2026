import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {

	static int M,N;
	static int [][] map, sharks;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		sharks=new int[N][M];
		ArrayList<int[]> sharkList=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1){
					sharkList.add(new int[]{i,j});
					//sharks[i][j]=0;
				}
			}
		}
		//System.out.println(sharkList.size());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int min=Integer.MAX_VALUE/100;
				for (int[] sh : sharkList) {
					if(map[i][j]==0){
						int man=manhatan(sh, new int[]{i,j});
						if(min>man){
							min=man;
							sharks[i][j]=min;
							//System.out.print(sh[0]+" "+sh[1]+" ");
							//System.out.println(i+" "+j+" "+man);
						}
					}
				}
			}
		}
		
/*		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(sharks[i]));
		}*/
		
		int max=-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max=Math.max(max, sharks[i][j]);
			}
		}
		System.out.println(max);
	}
	static int manhatan(int[] s1, int [] p2){
		
		int d1=manhatan(s1[0],p2[0]);
		int d2=manhatan(s1[1],p2[1]);
		if(d1==d2){
			return d1;
		}else {
			int max=Math.max(d1, d2);
			return max;
		}
	}
	static int manhatan(int s1, int  p2){
		return Math.abs(s1-p2);
	}
}
