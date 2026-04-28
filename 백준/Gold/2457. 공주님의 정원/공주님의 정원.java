import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int projCount = Integer.parseInt(br.readLine());
		project[] projArray = new project[projCount];
		for (int i = 0; i < projCount; i++) {
			st = new StringTokenizer(br.readLine());
			projArray[i] = new project(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(projArray);

		int start = 0;
		int count = 0;
		int end = 301;
		project latest;
		while (end < 1200) {
			latest = null;
			for (int i = start; i < projCount; i++) {
				if (end >= projArray[i].start && end < projArray[i].end) {
					latest = projArray[i];
					start = i;
				}
			}

			if (latest != null) {
				end = latest.end;
				count++;
			} else {
				System.out.println(0);
				return;
			}
		}
		System.out.println(count);
	}

	static class project implements Comparable<project> {
		int start;
		int end;

		public project(int sMonth, int sDay, int eMonth, int eDay) {
			super();
			this.start = sMonth * 100 + sDay;
			this.end = eMonth * 100 + eDay;
		}

		@Override
		public int compareTo(project o) {
			return Integer.compare(end, o.end);
		}
	}
}