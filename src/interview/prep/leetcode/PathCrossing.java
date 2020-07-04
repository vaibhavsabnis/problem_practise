package interview.prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
	public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>(); 

		if (path.length() == 1)
			return false;

		int ns = 0; // n=+1,s=-1
		int ew = 0; // e=+1,w=-1
		
		visited.add(ns+""+ew+"");
		
		for (int i = 0; i < path.length(); i++) {
			char curr = path.charAt(i);
			switch (curr) {
			case 'N':
				ns++;
				break;
			case 'S':
				ns--;
				break;
			case 'W':
				ew--;
				break;
			case 'E':
				ew++;
				break;
			}
			
			String coordinate = (ns+""+ew+""); 
			if(visited.contains(coordinate))			
				return true;
			else visited.add(coordinate);
		}
		return false;

	}

	public static void main(String[] args) {

		System.out.println(new PathCrossing().isPathCrossing("NNSWWEWSSESSWENNW"));
	}

}
