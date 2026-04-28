import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
//정올 백준 다 통과
public class Main {
  
    public static void main(String[] args) throws Exception{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
        Stack<Tower> stack = new Stack<Tower>();
        int height, position;
        int N = Integer.parseInt(br.readLine());    // 500,000
          
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (position=1; position<=N; position++) {
            height = Integer.parseInt(st.nextToken());
              
            while(!stack.isEmpty()) {
                if(stack.peek().height >= height) {
                    System.out.print(stack.peek().position + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty())
                System.out.print(0 + " ");
              
            stack.push(new Tower(height, position));
        }
          
          
        br.close();
    }
      
    static class Tower {
        int height;         //   100,000,000
        int position;       
          
        public Tower(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }
  
}