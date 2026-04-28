//sparse하기 때문에 
// 4000000*32=120M

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean findFive;
	static boolean [] visited;
	static List<Integer>[] lists;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //사람수
		M=Integer.parseInt(st.nextToken()); //관계수
		lists=new ArrayList[N];//인접리스트
		for (int i = 0; i < N; i++) {
			lists[i]=new ArrayList<>(); //초기화
		}
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()); 
			int e=Integer.parseInt(st.nextToken()); 
			lists[s].add(e);//양방향
			lists[e].add(s);
		}//읽기
		//로직
		findFive=false;
		//N개의 각 사람에서 시작해 본다.
		for (int i = 0; i < N; i++) {
			visited=new boolean[N];//새로 시작할 때마다 방문기록을 지운다.
			//실행
			dfs(i,1); // i번호부터 시작 깊이 1로시작 5가 될때까지 
			// 5깊이를 찾을 때까지 돌려본다. 
			if(findFive) {  //끝나는 조건 명시
				System.out.println(1);
				//찾으면 
				return ;// 메인도 끝
			}
		}
		System.out.println(0);
		
	}

	private static void dfs(int n, int cnt) {
	
		if(cnt==5) {
			//깊이만큼 왔다. 
			findFive=true; //찾았다.
			return ;
		}
		
		visited[n]=true; //왔다. 
		//인접한 사람에 대하여 
		for (int i = 0; i < lists[n].size(); i++) {
			//다음 인접할 사람을 방문한적 없어야한다.
			if(!visited[lists[n].get(i)]) {  //온적이 없다면 prunning이라우기면 backtracking
				dfs(lists[n].get(i), cnt+1); //연결될 사람을 넣어주고 깊이 증가
			}
		}
		visited[n]=false;//갔다->왔다 대칭. :  깊이 들어가다가 더이상 못들어가면 원위치!!
	}
}