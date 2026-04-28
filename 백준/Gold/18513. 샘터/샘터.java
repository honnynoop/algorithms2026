import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,K;//치킨집 개수 , 집의 개수
	public static int[] store;//치킨집 위치
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

 		N = Integer.parseInt(st.nextToken()); //치킨집 개수를 입력받는다.
 		K = Integer.parseInt(st.nextToken()); //집의 개수를 입력받는다.
 		store = new int[N]; //치킨집위치를 저장하기위한 store변수이다.
 		v = new HashMap<Integer,Integer>(); //해당위치를 방문했는지 즉, 집위치를 선택했는지 확인용도,중복되면 안되니까
 		st = new StringTokenizer(br.readLine().trim());
 		for (int i = 0; i < N; i++) {
			store[i] = Integer.parseInt(st.nextToken());
			cnt--; //bfs에서 치킨집위치를 전부 넣을 것인데 치킨집은 집의 개수가 아니므로 ++시 상쇄하기위함
		}
 		
 		bfs();//bfs호출
 		
		System.out.println(sum);
	}
	public static HashMap<Integer, Integer> v; //위치가 음수인 경우가 있어서 배열인덱스는 활용못함 그래서 해시맵활용
	//해당 해시맵은 해당위치를 방문했는지 확인하기 위한 용도이다.
	public static int cnt; //현재 선택된 집의 개수를 저장하기위함
	public static long sum = 0; //답이 저장될 변수이다.(치킨지수의 합)
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();//0번 인덱스에는 위치,1번인덱스는 치킨집위치
		for (int i = 0; i < store.length; i++) {
			v.put(store[i], 1); //치킨집도 집이 위치할수 없으므로 방문처리한다.
			queue.offer(new int[] {store[i],store[i]}); //치킨집을 전부 큐에 넣는다.
		}
		
		//bfs의 특성상 치킨집 위치를 기반으로 +1,-1씩 위치시킬 집을 찾아나간다면
		//집의 위치가 k개 전부 설정되었을떄, sum은 최소이다.
		while(!queue.isEmpty()) {
			int[] pos = queue.poll(); //큐에서 꺼낸다.
			cnt++;
			sum+=Math.abs(pos[0]-pos[1]); //pos[0]은 집의위치이고 pos[1]은 가까운 치킨집의 위치이다.
			if(cnt==K) { //집의 위치를 전부 설정했다면 리턴
				
				return;
			}
			
			if(v.get(pos[0]+1)==null) { //해당위치에서 +1 떨어진곳이 방문하지않는 위치라면 
				v.put(pos[0]+1, 1); //방문처리후
				queue.offer(new int[] {pos[0]+1,pos[1]}); //큐에넣는다. pos[1]은 가까운 치킨집 위치이다.
			}
			if(v.get(pos[0]-1)==null) {
				v.put(pos[0]-1, 1);
				queue.offer(new int[] {pos[0]-1,pos[1]});
			}
		}
	}
}