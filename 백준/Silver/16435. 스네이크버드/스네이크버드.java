import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,L;
	static int[] H;
	static int height, start;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		L=scann.nextInt();
		H=new int[N];
		for (int i = 0; i <N; i++) {
			H[i]=scann.nextInt();
		}
		
		Arrays.sort(H);
		start=L;
		height=0;
		
		for (int i = 0; i < N; i++) {
			if(H[i]<=L) {
				height++;
				L++;
			}
		}
		System.out.println((height+start));
	}
}