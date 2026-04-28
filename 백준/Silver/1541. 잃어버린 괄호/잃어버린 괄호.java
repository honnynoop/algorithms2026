import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		String s=scann.next();
		ArrayList<Integer> nums=new ArrayList<>();
		ArrayList<String> opps=new ArrayList<>();
		char[] cs=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < cs.length; i++) {
			if(cs[i]=='+' || cs[i]=='-') {
				nums.add(Integer.parseInt(sb.toString()));
				opps.add(cs[i]+"");
				sb.setLength(0);
			}else {
				sb.append(cs[i]);
			}
		}
		nums.add(Integer.parseInt(sb.toString()));
		//로직
		int cnt=0; //-개수
		for (String t: opps) {
			if(t.equals("-")) cnt++;
		}
		int sum=0;
		if(cnt==0) {
			for (int t: nums) {
				sum+=t;
			}
			System.out.println(sum);
		}else  {
			int index=0;
			for (int i=0; i<opps.size(); i++) {
				if(opps.get(i).equals("-")) {
					index=i;
					break;
				}
			}
			for (int i=0; i<index+1; i++) {
				sum+=nums.get(i);
			}
			int tot=0;
			for (int i=index+1; i<nums.size(); i++) {
				tot+=nums.get(i);
			}
			System.out.println(sum-tot);
		}
	}
}