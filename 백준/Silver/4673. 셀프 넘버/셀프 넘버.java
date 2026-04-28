public class Main{
	
	public static void main(String[] args) {
		for (int i = 1; i < 10000+1; i++) {
			if(isSelf(i))System.out.println(i);
		}
	}//main
	// n보다 작은 수를 d(i)=n 이 있다면 not Self
	private static boolean isSelf(int n) {
		for (int i = 1; i < n; i++) {
			if(d(i)==n) return false;
		}
		return true;// 만족하는 것이 없다면 Self
	}

	//  n=12  2  n=1  1  n=0
	public static int eachSum(int n) {
		int tot=0;
		while (n>0) {
			tot+=n%10;
			n/=10;
		}
		return tot;
	}
	public static int d(int n) {
		return n+eachSum(n);
	}
}
