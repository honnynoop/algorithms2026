
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static class Building {
		int x;
		int height;
		boolean isStart;
	 
		public Building(int x, int height, boolean isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}

		@Override
		public String toString() {
			return " [x=" + x + ", height=" + height + ", isStart=" + isStart + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int[][] build=new int[N][3];

		for (int i = 0; i <N; i++) {
			st=new StringTokenizer(br.readLine());
			build[i][0]=Integer.parseInt(st.nextToken());
			build[i][2]=Integer.parseInt(st.nextToken());
			build[i][1]=Integer.parseInt(st.nextToken());
		}
		List<int[]> locations=getSkyline(build);
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < locations.size(); i++) {
			sb.append(locations.get(i)[0]+ " "+locations.get(i)[1]+" ");
		}
		System.out.println(sb.toString());
	}
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<int[]>();
	 
		if (buildings == null || buildings.length == 0
				|| buildings[0].length == 0) {
			return result;
		}
	 
		List<Building> buildList = new ArrayList<Building>();
	 
		// add all left/right edges
		for (int[] building : buildings) {
			Building startEdge = new Building(building[0], building[2], true);
			buildList.add(startEdge);
			Building endEdge = new Building(building[1], building[2], false);
			buildList.add(endEdge);
		}
	 
		// sort edges 
		Collections.sort(buildList, new Comparator<Building>() {
			public int compare(Building a, Building b) {
				if (a.x != b.x)
					return Integer.compare(a.x, b.x);
	 
				if (a.isStart && b.isStart) {
					return -Integer.compare(a.height,b.height);
				}
	 
				if (!a.isStart && !b.isStart) {
					return Integer.compare(a.height, b.height);
				}
	 
				return a.isStart ? -1 : 1;
			}
		});
		// 높은 순서로 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	 
		for (Building build : buildList) {
			if (build.isStart) {  // 앞쪽은  -> 비어있거나 더 높은 것이 오면 저장
				if (pq.isEmpty() || build.height > pq.peek()) {
					result.add(new int[] { build.x, build.height });  // 건물 앞쪽 정보
				}
				pq.add(build.height);     // 건물 높이 저장
			} else {              //뒤쪽  
				pq.remove(build.height);  // 건물 높이 제거
	 
				if(pq.isEmpty()){         // 건물이 끊어지거 없어
					result.add(new int[] {build.x, 0});  // 건물 뒤쪽 정보 : 높이 0
				}else if(build.height > pq.peek()){      // 건물이 높으면 
					result.add(new int[]{build.x, pq.peek()});      // 건물 뒤쪽 정보
				}
			}
		}
	 
		return result;
	}
}
