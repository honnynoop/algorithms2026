import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Room {
		int s;
		int e;
		public Room(int s, int e) {
			this.s = s;
			this.e = e;
		}
			
	}
	static class RoomComp implements Comparator<Room>{
		@Override
		public int compare(Room r1, Room r2) {
			int t=Integer.compare(r1.e, r2.e);
			if(t==0){
				// des 
				return Integer.compare(r1.s, r2.s);
			}else return t;  //asc
		}
	}
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		ArrayList<Room> rooms=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			rooms.add(new Room(scann.nextInt(), scann.nextInt()));
		}
		rooms.sort(new Comparator<Room>() {

			@Override
			public int compare(Room r1, Room r2) {
		        if(r1.e< r2.e) { return -1; 
		        }else if(r1.e> r2.e) { return 1; 
		        }else {
		        	if(r1.s< r2.s) { return -1; 
			        }else if(r1.s> r2.s) { return 1; 
			        }else {
			        	return 0;
			        }
		        }
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		int count=0;
		int prev=0;
		for (Room r: rooms) {
			if(prev<=r.s){
				prev=r.e;
				count++;
			}
		}
		
		System.out.println(count);
	}
}