package patterns.observable;

import java.util.*;

public class HighscoreList{
	private int maxSize;
	private List<Integer> results;
	private Set<HighscoreListListener> listeners = new HashSet<HighscoreListListener>();
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		this.results = new ArrayList<>();	
	}
	
	public int size() {
		return results.size();
	}
	
	public int getElement(int index) {
		return results.get(index);
		
	}
	
	public void addResult(int score) {
		
		List<Integer> prevList = new ArrayList<Integer>(results);
		int i = 0;
		
		if(results.isEmpty()) {
			results.add(score);
			
		}else {
			for (i = 0; i < size(); i++) {
			if(getElement(i) > score) {
				results.add(i, score);
				break;
				}else if(i == size()-1) {
					results.add(score);
					i+=1;
					break;
				}
			}
		}

		if(size() > maxSize) {
			results.remove(size()-1);
			
		}
		
		if(!prevList.equals(results)) {
			for (HighscoreListListener listener: listeners) {
					listener.listChanged(this, i);
			}
		}
	}
	
	public void addHighscoreListListener(HighscoreListListener hll) {
		if(!listeners.contains(hll)) {
			this.listeners.add(hll);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener hll) {
		if(listeners.contains(hll)) {
			this.listeners.remove(hll);
		}
	}
	public String toString() {
		return ""+results;
	}


	public static void main(String[] args) {
		HighscoreList hl = new HighscoreList(4);

		//hl.addResult(10);
		hl.addResult(2);
		hl.addResult(7);
		hl.addResult(5);
		//hl.addResult(20);
		hl.addResult(8);
		
		for(int i : hl.results) {
			System.out.println(i);
		}
	}


}
