import java.util.Scanner;
public class Main {
	static int N;
	static Egg[] list;
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new Egg[N];
		for(int i = 0 ;i < N; i++) {
			list[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
//		처음 계란 위치와 깨진 계란 갯수
		dfs(0,0);
		System.out.println(result);

	}
	static void dfs(int idx, int cnt) {

//		모든 경우 다 해봤을 경우 깨진 계란 갯수 세기
		if(idx == N) {
			result = Math.max(result, cnt);
			return;
		}
//		현재 계란이 깨진 경우나 마지막까지 계란이 깨지지 않은 경우 다음 계란으로 넘어가기
		if(list[idx].s <= 0 || cnt == N-1) {
			dfs(idx+1, cnt);
			return;
		}
//		깨진 갯수 저장 백트래킹 하기 위해서
		int nCnt = cnt;
		for(int i = 0; i <N; i++) {
//			자기 계란이면 건너가기
			if(i == idx) {
				continue;
			}
//			깨진 계란이면 건너가기
			if(list[i].s <= 0) {
				continue;
			}
//			서로 계란 치기하여 내구도 떨구기
			list[i].s -= list[idx].w;
			list[idx].s -= list[i].w;
//			상대 계란이 깨지면 카운트 증가
			if(list[i].s <= 0) {
				nCnt++;
			}
//			내 계란이 깨지면 카운트 증가
			if(list[idx].s <= 0) {
				nCnt++;
			}
//			재귀호출함
			dfs(idx+1, nCnt);
//			백트래킹
			nCnt = cnt;
			list[i].s += list[idx].w;
			list[idx].s += list[i].w;			
		}
	}
	static class Egg {
		int s;
		int	w;
		public Egg(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
		
	}

}