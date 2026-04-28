import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1-i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");//하나찍고
			if(i==0) {
				System.out.println();
				continue; // i=0일때 여기까지만 실행
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print(" ");
			}
			System.out.print("*");//하나찍고
			System.out.println();
		}
		
	}

}
