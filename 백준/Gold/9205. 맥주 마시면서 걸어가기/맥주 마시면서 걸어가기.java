import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static final StringBuilder sb = new StringBuilder();
    static int N;
    static Node home;
    static Node festival;
    static final String happy = "happy";
    static final String sad = "sad";
    static int beer = 20;
    static Queue<Node> q = new LinkedList<>();
    static List<Node> store = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];

            store.clear();
            for(int i = 0; i < N+2; i++){
                String[] x = br.readLine().split(" ");
                if (i == 0){
                    home = new Node(Integer.parseInt(x[0]),Integer.parseInt(x[1]));
                }
                else if (i == N+1){
                    festival = new Node(Integer.parseInt(x[0]),Integer.parseInt(x[1]));
                }
                else{
                    store.add(new Node(Integer.parseInt(x[0]),Integer.parseInt(x[1])));
                }
            }


            if(bfs()){
                sb.append(happy+"\n");
            }
            else{
                sb.append(sad+"\n");
            }

        }

        System.out.print(sb);

        br.close();
    }

    private static boolean bfs() {
        q = new LinkedList<>();
        q.add(home);
        while(!q.isEmpty()){
            Node now = q.poll();
//            System.out.println(now.toString());
            if (dist(now, festival) <= 1000){
                return true;
            }
            for(int idx = 0; idx < store.size(); idx++){
                if (dist(store.get(idx), now) <= 1000 && !visited[idx]){ //
                    visited[idx] = true;
                    q.add(new Node(store.get(idx).x, store.get(idx).y));
                }
            }

        }


        return false;
    }

    private static int dist(Node now, Node dest) {
        return Math.abs(now.x-dest.x) + Math.abs(now.y - dest.y);
    }
}