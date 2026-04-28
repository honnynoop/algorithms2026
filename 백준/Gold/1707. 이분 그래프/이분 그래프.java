import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int V, E; // 정점, 간선의 개수
	static boolean flag; // 이분그래프가 맞는지 여부(true면 YES, false면 NO)
	static int[] team; // 각 정점의 팀 번호 저장 (1팀과 2팀)
	static LinkedList<Integer>[] list; // 정점이 연결되어 있는지 나타내는 인접리스트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); 
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken()); // input
			list = new LinkedList[V]; // 인접리스트 크기 V로 초기화
			team = new int[V]; //팀 배열 크기 V로 초기화
			flag = true; // 처음에 이분그래프가 맞다고 초기화
			for (int i = 0; i < V; i++)
				list[i] = new LinkedList<>(); // 각 정점의 리스트 생성
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken()) - 1;
				int v2 = Integer.parseInt(st.nextToken()) - 1; // input
				list[v1].add(v2); // v1에 v2를 연결
				list[v2].add(v1); // v2에 v1을 연결 (양방향이기 때문에 서로 연결)
			}
			for (int i = 0; i < V; i++) { // 모든 정점에 대해 dfs()를 돌리면서 검사
				if (!flag)
					break; // dfs()를 돌리다가 flag가 false가 되면 이분그래프가 아니기 때문에 반복문을 종료
				if (team[i] == 0) // 아직 팀 번호가 결정되지 않았다면
					dfs(i, 1); //dfs() 탐색
			}
			System.out.println(flag ? "YES" : "NO"); // 이분그래프가 맞으면 YES, 아니면 NO를 출력
		}
	}

	static void dfs(int v, int num) { // 매개변수는 (정점의 번호, 결정될 팀 번호)
		team[v] = num; // v의 팀 번호를 결정하여 team 배열에 입력
		for (int ver : list[v]) { // 정점 v와 연결된 모든 정점들(ver)에 대해 반복문
			if (num == team[ver]) { // 만약 ver의 팀 번호가 결정되어 있는 상태에서 정점 v와 같은 팀이라면
				flag = false; // 이분그래프가 아니므로 false로 설정하고
				return; // 함수 종료
			}
			if (team[ver] == 0) { // 만약 ver의 팀 번호가 결정되어 있지 않은 상태라면
				dfs(ver, num == 1 ? 2 : 1); // 인접한 정점 v의 팀 번호와 반대 팀으로 설정
			}
		}
	}

}