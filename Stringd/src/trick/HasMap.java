package trick;

import java.util.HashMap;

public class HasMap {

	public static void main(String[] args) {

		HashMap<String, String> hm = new HashMap<>();
		hm.put("k", "ko");
		hm.put("k", "ok");
		hm.put("l", "lo");
		
		for(String key : hm.keySet())
			System.out.println(hm.get(key));
	}

}
