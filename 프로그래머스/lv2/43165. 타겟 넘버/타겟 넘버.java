public class Solution {

	
	static int count;
	static int N;
	public int solution(int[] numbers, int target) {
		count=0;
		N=numbers.length;
		dfs(0,0,numbers,target);
		return count;
	}
	public void dfs(int cnt, int tot,int[] numbers, int target) {
		if(cnt==N) {
			if(tot==target) {
				count++;
			}
			return ;
		}
	    dfs(cnt+1, tot+numbers[cnt], numbers, target);
	    dfs(cnt+1, tot-numbers[cnt], numbers, target);
	}

}
