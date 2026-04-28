import java.util.Scanner;
public class Main {
	static int N;
	static boolean isFirst=false;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		isFirst=false;
		dfs(1,"1");
	}

	static void dfs(int cnt, String s) {
		if(isFirst) return ;// 한번만 가장 작은 수 반환
		if(cnt==N){
			isFirst=true;
			System.out.println(s);
			return ;
		}
		// 123만 사용
		for (int i = 1; i <= 3; i++) {
			if(isGood(s+i)){
				dfs(cnt+1,s+i);
			}
		}
	}

	static boolean isGood(String s) {
		int len=s.length();
		int start=len-1;
		int end=len;
		int loop=len/2;
		for (int i = 1; i <= loop; i++) {
			if(s.substring(start-i,end-i).equals(s.substring(start,end))){
				return false;
			}
			start-=1;
		}
		return true;
	}


}
