import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int N,S;
	static Integer[] A, B;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		A=new Integer[N];
		B=new Integer[N];
		for (int i = 0; i < N; i++) {
			A[i]=scann.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i]=scann.nextInt();
		}
		S=0;
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			S+=(A[i]*B[i]);
		}
		System.out.println(S);
	}

}