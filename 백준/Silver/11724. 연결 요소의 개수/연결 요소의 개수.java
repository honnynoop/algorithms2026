
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		for(int i = 1; i < arr.length; i++)
			arr[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ap = find(arr, a);
			int bp = find(arr, b);
			if(ap != bp) {
				arr[ap] = bp;
			}
		}
		
		List<Integer> temp = new ArrayList<>();
		for(int i = 1; i < arr.length; i++) {
			int p = find(arr, arr[i]);
			if(!temp.contains(p)) {
				temp.add(p);
			}
		}
		
		bw.write(temp.size() + "");
		bw.close();

	}
	
	public static int find(int[] arr, int n) {
		if(arr[n] != n)
			arr[n] = find(arr, arr[n]);
		return arr[n];
	}
}
