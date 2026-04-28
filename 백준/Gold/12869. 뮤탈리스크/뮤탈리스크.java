
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {

	static int N;
	static int min;
	static int[] p= {9,3,1};
	static boolean[][][] visited;
	public static void main(String[] args) {
		min=21;
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		List<Integer> ms=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			ms.add(scann.nextInt());
		}
		visited=new boolean[61][61][61];  //
		if(N==1) {
			min=Math.min(min, (int)(Math.ceil(1.0*ms.get(0)/9.0)));
			System.out.println(min);
		}else {
			dfs(0,ms);
			System.out.println(min);
		}
	}
	static void dfs(int cnt, List<Integer> ms2) {
		if(cnt>=min) return ;
		if(ms2.size()==0) {
			min=Math.min(cnt, min);
			return ;
		}
		if(ms2.size()==1) {
			min=Math.min(min, (int)(Math.ceil(1.0*ms2.get(0)/9.0))+cnt);
			return ;
		}
		ms2.sort((a,b)->-(a-b));
		int a=0;
		int b=0;
		int c=0;
		if(ms2.size()==3) {
			a=ms2.get(0);
			b=ms2.get(1);
			c=ms2.get(2);
			if(visited[a][b][c]) return;
			visited[a][b][c]=true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0;  j < 3; j++) {
					if(i==j) continue;
					for (int k = 0; k < 3; k++) {
						if(k==i) continue;
						if(k==j) continue;
						
						List<Integer> ms3=new LinkedList<>();
						if(a-p[i]>0) {
							ms3.add(a-p[i]);
						}
						if(b-p[j]>0) {
							ms3.add(b-p[j]);
						}
						if(c-p[k]>0) {
							ms3.add(c-p[k]);
						}
						
						dfs(cnt+1, ms3);
					}
				}
			}
		}else if(ms2.size()==2) {
			a=ms2.get(0);
			b=ms2.get(1);
			if(visited[a][b][0]) return;
			visited[a][b][0]=true;
			for (int i = 0; i < 2; i++) {
				for (int j = 0;  j < 2; j++) {
					if(i==j) continue;
					List<Integer> ms3=new LinkedList<>();
					if(a-p[i]>0) {
						ms3.add(a-p[i]);
					}
					if(b-p[j]>0) {
						ms3.add(b-p[j]);
					}
					dfs(cnt+1, ms3);
				}
			}
		} 
	}

}
