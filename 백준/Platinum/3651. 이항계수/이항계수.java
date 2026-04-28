import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static class LC implements Comparator<L>{
		@Override
		public int compare(L o1, L o2) {
			return o1.compareTo(o2);
		}
	}
	static class L implements Comparable<L>{
		long n;
		long r;
		public L(long n, long r) {
			super();
			this.n = n;
			this.r = r;
		}
		@Override
		public int compareTo(L o) {
			int a=Long.compare(n, o.n);
			if(a==0) {
				return Long.compare(r, o.r);
			}else {
				return a;
			}
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (n ^ (n >>> 32));
			result = prime * result + (int) (r ^ (r >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			L other = (L) obj;
			if (n != other.n)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
		
	}
	static long m; 
	public static void main(String[] args) {
		ArrayList<L> list=new ArrayList<>();
		Scanner scann=new Scanner(System.in);
		m=scann.nextLong();
		list.clear();
		/*		//15C1=15
		list.add(new L(m,1));
		list.add(new L(m,m-1));
		//15C2 -> 8*M+1 이 정수
		int t=(int)(Math.sqrt(8*m+1));
		if(t*t==8*m+1) {
			int a=(1+t)/2;
			list.add(new L(a,2L));
			list.add(new L(a,a-2L));
		}
		*/
		long right =m;
		
		for (long k = 1L; ; k++) {
			long left=2L*k;
			while(left<=right) {
				long mid=(right+left)>>1;
				long res=nCr(mid,k);
				if(res==m) {
					if(mid==2*k) {
						if(!list.contains(new L(mid, k))) {
							list.add(new L(mid, k));
						}
					}else {
						if(!list.contains(new L(mid, k))) {
							list.add(new L(mid, k));
							list.add(new L(mid, mid-k));
						}
					}
					right=mid;
					break;
				}
				if(res>m) {right=mid-1; }
				else { left=mid+1; }
			}
			if(right<2*k) {break;}
		}
		
		//출력
		list.sort(new LC());
		System.out.println(list.size());
		for (L ll: list) {
			System.out.println(ll.n+" "+ll.r);
		}
	}
	static long nCr(long n, long k) {
		double re=1L;
		for (long i = 1L; i <= k; i++) {
			re=(re*(n-k+i))/(i);
			
		}
		if(re> (Math.pow(10, 16))) {return (long) Math.pow(10, 16);}
		return (long)re;
	}
}
