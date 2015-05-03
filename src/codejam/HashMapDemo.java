package codejam;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args){
		HashMap<Integer, String> hm=new HashMap<Integer,String>(10);
		hm.put(new Integer(1), "Amina");
		hm.put(new Integer(2), "John");
		for(Map.Entry<Integer,String> e: hm.entrySet()){
			System.out.print(e.getKey() +":"+e.getValue());
		}
	}
}
