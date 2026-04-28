import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, totalMax;
	static Box[] boxes;
	static int[] maximum;
	static Box bottom;
	static Map<Integer, Box> weightToBox;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		boxes = new Box[N];
		maximum = new int[10001];
		totalMax = 0;
		weightToBox = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			boxes[i] = new Box(i+1, width, height, weight);
			weightToBox.put(weight, boxes[i]);
		}
		Arrays.sort(boxes, (o1, o2) -> Integer.compare(o1.width, o2.width));
		
		for(int i=0;i<N;i++) {
			Box b = boxes[i];
			
			int max = 0;
			int index = 0;
			for(int w=0;w<b.weight;w++) {
				if(max<maximum[w]) {
					max = maximum[w];
					index = w;
				}
			}
			maximum[b.weight] = max+b.height;
			if(max!=0)
				b.nxt = weightToBox.get(index);
			if(maximum[b.weight]>totalMax) {
				totalMax = maximum[b.weight];
			}
		}
		int index = 0;
		for(int i=0;i<10001;i++) {
			if(maximum[i]==totalMax) {
				index = i;
				break;
			}
		}
		Box bottom = weightToBox.get(index);
		Stack<Integer> stack = new Stack<>();
		while(bottom!=null) {
			stack.add(bottom.index);
			bottom = bottom.nxt;
		}
		System.out.println(stack.size());
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	
	static class Box{
		
		int index, width, height, weight;
		Box nxt;
		Box(int index, int width, int height, int weight){
			this.index = index;
			this.width = width;
			this.height = height;
			this.weight = weight;
		}
	}
}