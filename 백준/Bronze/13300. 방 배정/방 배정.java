

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int K=scann.nextInt();
		int[][] member=new int[7][2];
		for (int i = 0; i < N; i++) {
			int S=scann.nextInt();
			int Y=scann.nextInt();
			member[Y][S]++;
		}
		int tot=0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j <2; j++) {
				tot+=(member[i][j]/K+(member[i][j]%K==0?0:1));
			}
		}
		System.out.println(tot);
	}

}
