import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;  //도시
	static int [] people;
	static boolean [] visited;  // subset visited
	static int[][] map;
	static int min;
	static boolean [] vv;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		people=new int[N];
		visited=new boolean[N];
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			people[i]=scann.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int M=scann.nextInt();
			for (int j = 0; j < M; j++) {
				int e=scann.nextInt();
				map[i][e-1]=1;  //1->0 2->1구역으로
				map[e-1][i]=1;
			}
		}

		min=1000000;
		subset(0);
		System.out.println(min==1000000?-1:min);
	}

	static void subset(int cnt) {
		if(cnt==N) {
			int conns=conn(visited); // 모든 도시 방문?? 1000000 연결안됨
			//+이면 |A-B| 차
			min=Math.min(min, conns);
			return ;
		}
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
	}

	static int conn(boolean[] visit) {
		List<Integer> alist=new ArrayList<>();
		List<Integer> blist=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if(visit[i]) {
				alist.add(i);
			}
			if(!visit[i]) {
				blist.add(i);
			}
		}
		
		if(alist.size()==0 || blist.size()==0) return  1000000;
		
		vv=new boolean[N];
		bfs(alist);
		bfs(blist);
		if(isSucc(vv)) {
			return cal(alist, blist);
		}else {
			return  1000000;
		}
		
	}

	static int cal(List<Integer> al, List<Integer> bl) {
		//System.out.println(Arrays.toString(al.toArray()));
		//System.out.println(Arrays.toString(bl.toArray()));
		int sumA=0;
		for (int i = 0; i < al.size(); i++) {
			sumA+=people[al.get(i)];
		}
		int sumB=0;
		for (int i = 0; i < bl.size(); i++) {
			sumB+=people[bl.get(i)];
		}
		return Math.abs(sumA-sumB);
	}

	static boolean isSucc(boolean[] v) {
		for (int i = 0; i < N; i++) {
			if(!v[i]) return false;
		}
		return true;
	}

	static void bfs(List<Integer> list) {
		Queue<Integer> que=new LinkedList<>();
		que.offer(list.get(0));
		vv[list.get(0)]=true;
		while(!que.isEmpty()) {
			int s=que.poll();
			for (int e = 0; e <list.size(); e++) {
				if(vv[list.get(e)]) continue;
				if(map[s][list.get(e)]==1) {
					que.offer(list.get(e));
					vv[list.get(e)]=true;
				}
			}
		}
	}



}