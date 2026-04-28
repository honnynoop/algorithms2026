import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.x > o.x) return 1;
        else if (this.x < o.x) return -1;
        else if (this.y > o.y) return 1;
        else if (this.y < o.y) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
}

public class Main {
    static int[] seg = new int[10000];
    static int n;
    static int m;
    
    static void update(int start, int end, int node, int index, int change){
        if (index < start || index > end) return;

        seg[node] += change;

        if (start != end){
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, change);
            update(mid + 1, end, node * 2 + 1, index, change);
        }
    }
    
    static int summ(int start, int end, int node, int left, int right){
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return seg[node];
        int mid = (start + end) / 2;
        return summ(start, mid, node * 2, left, right) + summ(mid + 1, end, node * 2 + 1, left, right);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Pair> p = new ArrayList<>();
        
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            p.add(new Pair(a, b));
            if (i % 100000 == 0) System.gc();
        }
        
        Collections.sort(p);
        
        long solution = 0l;
        for (int i = 0; i < p.size(); i++) {
            a = p.get(i).x;
            b = p.get(i).y;
            update(1, n, 1, b, 1);
            solution += summ(1, n, 1, b + 1, n);
            
        }
        
        System.out.println(solution);
    }
}
