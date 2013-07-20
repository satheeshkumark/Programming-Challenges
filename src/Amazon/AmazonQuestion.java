package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonQuestion {

	public static List<Integer> intersection(List<Integer> a, List<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		List<Integer> outputList = new ArrayList<Integer>();
		int i = 0, j = 0;
		Integer previous = null;
		while(i < a.size() && j < b.size()){
			Integer avalue = a.get(i);
			Integer bvalue = b.get(j);
			if((avalue.intValue() == bvalue.intValue()) && (previous == null || previous.intValue() != avalue.intValue())){
				outputList.add(avalue);
				i++;
				j++;
			}
			else if(avalue.intValue() <  bvalue.intValue())
				i++;
			else
				j++;				
		}
		return outputList;
	}
	
	
	public static void main(String args[]){
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(4);
		l1.add(2);
		l1.add(73);
		l1.add(11);
		l1.add(-5);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(-5);
		l2.add(73);
		l2.add(-1);
		l2.add(9);
		l2.add(9);
		l2.add(4);
		l2.add(7);
		List<Integer> l3 = intersection(l1,l2);
		for(Integer i : l3)
			System.out.println(i);
	}
}
