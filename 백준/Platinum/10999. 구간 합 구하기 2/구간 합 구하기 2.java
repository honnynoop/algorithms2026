import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] nums;
	static long[] tree;
	static long[] lazy;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		make(N+1);
		nums=new long[N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			nums[i]=Long.parseLong(st.nextToken());
		}
		init(nums,1,1,N);
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M+K; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			if(a==1) {
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				long d=Long.parseLong(st.nextToken());
				update(1, 1,N, b,c, d);
				
			}else if(a==2) {
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				long s=sum(1,1,N,b,c);
				sb.append(s).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
    // 생성자에서 세그먼트 트리의 전체노드 수 계산 (즉, 배열 길이)
    static void make(int n) {
        // 트리의 높이 계산
        //double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
        // 트리의 노드 수 계산
        //long treeNodeCount = Math.round(Math.pow(2, treeHeight));
        // 트리의 길이 설정
        tree = new long[4*N+1];
        lazy = new long[4*N+1];
    }
    static void init(long[] a, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a,node*2, start, (start+end)/2);
            init(a,node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
    }
    static void update_lazy(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end-start+1)*lazy[node];
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
       
    }
    static long sum(int node, int start, int end, int left, int right) {
        update_lazy(node, start, end);
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lsum = sum(node*2, start, (start+end)/2, left, right);
        long rsum = sum(node*2+1, (start+end)/2+1, end, left, right);
        
        return lsum+rsum;
    }
    static void update(int node, int start, int end, int left, int right, long diff) {
        update_lazy(node, start, end);
        if (left > end || right < start) {
            return;
        }
        if (left <= start && end <= right) {
        	
            tree[node] += (end-start+1)*diff;
            if (start != end) {
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return;
        }
        update(node*2, start, (start+end)/2, left, right, diff);
        update(node*2+1, (start+end)/2+1, end, left, right, diff);
        tree[node] = tree[node*2] + tree[node*2+1];
    }
}