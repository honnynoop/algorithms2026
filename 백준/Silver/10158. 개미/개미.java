import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int W=scann.nextInt();
		int H=scann.nextInt();
		int a=scann.nextInt();
		int b=scann.nextInt();
		int t=scann.nextInt();
		int x=-Math.abs((t+a)%(2*W)-W)+W;
		int y=-Math.abs((t+b)%(2*H)-H)+H;
		System.out.println(x+" "+y);
	}
}
