import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int[] nums=new int[N];
		for (int i = 0; i < N; i++) {
			nums[i]=scann.nextInt();
		}
		Arrays.sort(nums);
		int r=0;
		for (int i = 0; i < N; i++) {
			r+=(N-i)*nums[i];
		}
		System.out.println(r);
	}
}