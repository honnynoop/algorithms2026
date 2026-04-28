import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int R=pivo(N);
		System.out.println(R);
	}

	private static int pivo(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else  {
			return pivo(n-1)+pivo(n-2);
		}
	}

}
