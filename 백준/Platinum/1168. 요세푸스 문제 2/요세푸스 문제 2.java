import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static private long[] tree;
	static double treeHeight ;
     // 트리의 노드 수 계산
    static long treeNodeCount ;
    
	static long init(long[] arr, int node, int start, int end ){
	    // 세그먼트 트리의 리프노드인 경우
	    if (start == end) {
	        // 리프노드에 배열의 값 저장 후 리턴
	        return tree[node] = arr[start];
	    }else{
	        // 리프노드가 아닌 경우에는 자식노드의 값을 더해서 노드의 값 초기화 후 리턴
	        return tree[node] = init(arr, node*2, start, (start+end)/2)
	                + init(arr, node*2+1, (start+end)/2+1, end);
	    }
	}
	static int next(int node, int s, int e, int norder) // (현재노드, 시작, 끝, 순서)
	{
	    if (s == e) {
	    	tree[node]--;
	    	return s;
	    }// start 와 end 의 위치가 일치하면 번호를 반환한다.
	    int mid = (s + e) / 2;
	    int ret=0;
	    if (norder <= tree[2 * node]) ret= next(2 * node, s, mid, norder);
	    else ret= next(2 * node + 1, mid + 1, e, norder - (int)tree[2 * node]);
	    tree[node]=tree[2 * node]+tree[2 * node+1];
	    return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 
        // 트리의 높이 계산
        treeHeight = Math.ceil(Math.log(N)/Math.log(2))+1;
        // 트리의 노드 수 계산
        treeNodeCount = Math.round(Math.pow(2, treeHeight));
        // 트리의 길이 설정
        tree = new long[Math.toIntExact(treeNodeCount)];
        
        long[] arr=new long[N];
        Arrays.fill(arr, 1);
		init(arr,1, 0, N-1);
		int index = 1;
		StringBuffer sb=new StringBuffer();
		sb.append("<");
	    //System.out.print("<");
	    for (int i = 0; i < N; i++)
	    {
	        // 다음 순서 구하기
	        int size = N - i; // 사람 수
	        index += K - 1;

	        if (index % size == 0) index = size;
	        else if (index > size) index %= size;
	        
	        int num = next(1, 0, N-1, index);
	          
	        if (i == N - 1) sb.append(num+1);

	        else sb.append((num+1)+", ");
	    }
	    sb.append(">");
	    System.out.println(sb.toString());
	}
	
}