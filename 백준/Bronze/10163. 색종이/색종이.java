import java.util.Scanner;

public class Main {

	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		map=new int[1001][1001];
		for (int k = 0; k < n; k++) {
			int r=sc.nextInt();//1
			int c=sc.nextInt();//4
			int width=sc.nextInt();//3
			int height=sc.nextInt();//2
			for (int i = c+height-1; i >= c; i--) {
				for (int j = r; j < r+width; j++) {
					map[i][j]=k+1;
				}
			}
		}

		int[] cnt=new int[n+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				cnt[map[i][j]]+=1;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(cnt[i+1]);
		} 
		
	}
}