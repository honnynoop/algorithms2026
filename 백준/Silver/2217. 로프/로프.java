import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] weight;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		weight=new int[N];
		for (int i = 0; i < N; i++) {
			weight[i]=scann.nextInt();
		}
		int result=-1;
		Arrays.sort(weight);
		for (int i = 0; i < N; i++) {
			result=Math.max(result, (N-i)*weight[i]);
		}
		System.out.println(result);
	}

}