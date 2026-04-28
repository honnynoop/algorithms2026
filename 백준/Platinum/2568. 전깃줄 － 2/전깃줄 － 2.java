import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// LIS -> 교차하지 않는 라인수 
public class Main {

	public static class L implements Comparable<L>{
		int l;
		int r;
		public L(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(L o) {
			return Integer.compare(l, o.l);
		}	
	} 
	static int N;
	static L[] lines;
	static int [] dp;
	static L[] trace;
	static int cnt;
	public static void main(String[] args) {
		boolean[] visited = new boolean[500001];	
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		lines=new L[N];
		trace=new L[N];
		dp=new int[N];
		for (int i = 0; i < N; i++) {
			int l=scann.nextInt();
			int r=scann.nextInt();
			lines[i]=new L(l,r);
			visited[l] = true;
		}
		Arrays.sort(lines);
		cnt=0;
		
		int j=0; 
        dp[0] = lines[0].r; 
        trace[0] = new L(0, lines[0].l);
        for (int i = 1; i < N; i++) { 
            if (lines[i].r > dp[j]) {
                dp[++j] = lines[i].r; 
                trace[i] = new L(j, lines[i].l);
            }else{
            	int temp=Arrays.binarySearch(dp,0,j,lines[i].r);
            	if(temp<0){
            		temp=-temp-1;// 4-1
            	}
            	dp[temp] = lines[i].r;
            	trace[i] = new L(temp, lines[i].l);
            }
        } 
        System.out.println(N-(j+1));
        ArrayList<Integer> list = new ArrayList<>();	
		for(int i=N-1; i>=0; i--){
			if(trace[i].l == j){
				list.add(trace[i].r);
				j--;
			}
		}
		for(int a : list)
			visited[a] = false;
		for(int i=0; i<=500000; i++){
			if(visited[i])
				System.out.println(i);
		}
	}
}
/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6

*/