import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	static int T;
	static String ss;	
	static long count;
	static long RW;
	static int P,K;
	static String rs;
	static int [] nums;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			ss=scann.next();
			K=ss.length();
			long N=scann.nextLong();
			if(K==1){
				System.out.print("#"+t+" ");
				for (long i=0L; i<N; i++) {
					System.out.print(ss);
				}
				System.out.println();
			}else{
				int n=cal(N, K);
				nums=new int[n+1];
				long rt=sum(K,n);
				if(N-rt==0){
					char[] cc=new char[n];
					for (int i = 0; i < cc.length; i++) {
						cc[i]=ss.charAt(K-1);
					}
					rs=new String(cc);
					System.out.println("#"+t+" "+rs);
				}else{
					N=N-rt;
					for (int i = n; i >=0; i--) {
						long v=pw(K,i);
						nums[i]=(int)(N/v);
						N=(N%v);
					}
					System.out.print("#"+t+" ");
					int [] a=toVal(nums);
					for (int i = nums.length-1; i >=0; i--) {
						System.out.print(ss.charAt(a[i]-1));
					}
					System.out.println();
				}
			}
		}
	}
	// 0010 -> 0100으로 
	public static int[] toVal(int[] nums2) {
		int [] a=new int[nums2.length];
		if(isZ(nums2)){ // 마지막이 0
			if(first(nums2)==-1){// 0번째 빼고 모두 0이 아님
				for (int i = 0; i <nums2.length; i++) {
					if(i==0){
						a[i]=K;
					}else if(i==1){
						a[i]=nums2[i];
					}else{
						a[i]=nums2[i]+1;
					}
				}
			}else if(first(nums2)>0){
				int f=first(nums2);//1 이상 
				for (int i = 0; i <nums2.length; i++) {
					if(i<f){
						a[i]=K;
					}else if(i==f){
						a[i]=nums2[i];
					}else {
						a[i]=nums2[i]+1;
					}
				}
			}
		}else{// 마지막이 0이 아님
			for (int i = 0; i <nums2.length; i++) {
				if(i==0){
					a[i]=nums2[i];
				}else{
					a[i]=nums2[i]+1;
				}
			}
		}
		
		
		return a;
	}

	public static boolean isZ(int[] nums2) {
		return nums2[0]==0?true:false;
	}
	
	public static int first(int [] t){
		for (int i = 0; i <t.length; i++) {
			if(t[i]!=0) return i;
		}
		return -1;
	}
	public static boolean isEZ(int a){
		return a==0?true:false;
	}
	public static int cal(long M, int a) {
		return (int)(Math.log10(1.0*M*(a-1.0)/a+1.0)/Math.log10(1.0*a));
	}
	public static long pw(long n, int a) {
		long sum=1L;
		for (int i = 0; i < a; i++) {
			sum*= n;
		}
		return sum;
	}
	public static long sum(long n, int b){
		long sum=0L;
		for (int i = 1; i < b+1; i++) {
			long a=pw(n,i);
			sum+=a;
		}
		return sum;
	}
}
