import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		
		int N=scann.nextInt();
		int R=1<<N;
		System.out.println(R);
	}

}