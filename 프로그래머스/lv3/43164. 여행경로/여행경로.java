
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

	
	private static List<String> answer;
	private static boolean[] visited;
	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>();
		visited = new boolean[tickets.length];
		dfs("ICN", 0, "ICN", tickets );
		Collections.sort(answer);//갈 수 있는 곳이 여러곳인 경우 알파벳 순서 방문
		
		return answer.get(0).split(" ");
	}
	
	private void dfs(String path, int cnt, String location, String[][] tickets) {
		if(cnt == tickets.length) { //티켓을 모두 다 사용한 경우 : 경로 완성
			answer.add(path); //완성된 경로 넣어주기
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			//현재 티켓을 사용한적 없고, 티켓의 출발지가 현재 위치와 같다면
			if(!visited[i]&&tickets[i][0].equals(location)) {
				visited[i]=true;
				dfs(path+" "+tickets[i][1], cnt+1, tickets[i][1],tickets);
				visited[i]=false;
			}
		}
	}
}
