import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int K=scann.nextInt();
		int[] length=new int[7];
		for (int i = 0; i < 6; i++) {
			int dir=scann.nextInt();
			length[i]=scann.nextInt();
		}
		length[6]=length[0];
		int sum=0;
		int max=-1;
		for (int i = 0; i < 6; i++) {
			max=Math.max(length[i]*length[i+1], max);
			sum+=length[i]*length[i+1];
		}
		System.out.println(K*(max-(3*max-sum)));
	}
}