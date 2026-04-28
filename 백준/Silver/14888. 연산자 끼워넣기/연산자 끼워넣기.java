import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] nums,p;
	static int[] ops;
	static int max, min;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		nums=new int[N];
		ops=new int[4];
		for (int i = 0; i < N; i++) {
			nums[i]=scann.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			ops[i]=scann.nextInt();
		}
		p=new int[N-1];
		int cnt=0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < ops[i]; j++) {
				p[cnt++]=i+1;
			}
		}

		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		do {
			int sum=nums[0];
			for (int i = 1; i < N; i++) {
				switch (p[i-1]) {
					case 1:
						sum+=nums[i];
						break;
					case 2:
						sum-=nums[i];
						break;	
					case 3:
						sum*=nums[i];
						break;	
					case 4:
						sum/=nums[i];
						break;	
				}
			}
			max=Math.max(max, sum);
			min=Math.min(min, sum);
		} while (np(N-2));
		System.out.println(max);
		System.out.println(min);
	}

	private static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}
}