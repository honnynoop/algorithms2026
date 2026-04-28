import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
public class Solution {
	static int IT;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		IT=Integer.parseInt(br.readLine());
		TreeSet<String> ts=new TreeSet<>();
		LinkedList<String> names=new LinkedList<>();
		for (int i = 1; i <= IT; i++) {
			int N=Integer.parseInt(br.readLine());
			ts.clear();
			names.clear();
			for (int j = 0; j < N; j++) {
				String name=br.readLine();
				ts.add(name);
			}
			for (Iterator<String> iterator = ts.iterator(); iterator.hasNext();) {
				names.add(iterator.next());
			}
			Collections.sort(names, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()>o2.length()){
						return 1;
					}else if(o1.length()<o2.length()){
						return -1;
					}else{
						return o1.compareTo(o2);
					}
				}
			});
			
			
			System.out.println("#"+i);
			for (String sss: names) {
				System.out.println(sss);
			}
		}
	}
}