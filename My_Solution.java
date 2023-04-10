package misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class main_misc2 {
	
	//private static HashMap<Integer,Integer> cache = new HashMap<>();
	public static void main(String[] args) {
		//(a+b)%k = ((a % k)+(b % k)) % k
		
		int[][]v = {{0,2,1},{1,1,1},{2,0,0}};
		int n = v.length;
		System.out.println(organizing_containers(v,n));
		
		
	
		
	
	
	
	}
	
	private static int organizing_containers(int[][]v,int n) {
		//n-1:maximum type of object
		//All operations:O(2*n^2 + 2*n) = O(n^2)
		
		//O(n^2)
		HashMap<Integer,Integer> h = new HashMap<>();
		for(int i = 0;i < v.length;i++){
		    for(int j = 0;j < v[i].length;j++) {
		    	if(h.containsKey(j)){
		    		h.replace(j,h.get(j)+v[i][j]);
		    	}
		    	else {
		    		h.put(j,v[i][j]);
		    	}
		    }
		}
		//System.out.println(h);
		
		//O(n^2)
		ArrayList<Integer> l = new ArrayList<>();
		
		for(int i = 0;i < v.length;i++) {
			int s = 0;
			for(int j = 0;j < v[i].length;j++){
				s += v[i][j];
				if(j == v[i].length-1) {
					l.add(s);
				}
			}
		}
		//System.out.println(l);
		
		//O(n)
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0;i < n;i++) {
			/*if(h.get(i).equals(null)) {
				continue;
			}*/
			a.add(h.get(i));
		}
		
		//System.out.println(a);
		
		l.sort(Comparator.naturalOrder());
		a.sort(Comparator.naturalOrder());
		
		//O(n)
		for(int i = 0;i < l.size();i++) {
			if(!l.get(i).equals(a.get(i))){
				//Impossible
				System.out.println("Impossible");
				return 0;
			}
		}
				
		//Possible
		System.out.println("Possible");
		return 1;
	}
	
	
	
	
	}

	
		

	
	
	

	
