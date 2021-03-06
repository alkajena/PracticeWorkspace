package sortingTechnique;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeMap map=new TreeMap();
		map.put(100, "alka");
		map.put(200, "abcd");
		map.put(400, "abbd");
		List list=new LinkedList(map.entrySet());
		Collections.sort(list,new MyComparator());
		System.out.println(list);
	}

}

class MyComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Map.Entry entry1=(Map.Entry)arg0;
		Map.Entry entry2=(Map.Entry)arg1;
		return ((String)entry2.getValue()).compareTo((String)entry1.getValue());
	}
	
}
