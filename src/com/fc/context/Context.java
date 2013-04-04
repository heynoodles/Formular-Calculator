package com.fc.context;
import java.util.HashMap;

/**
 * �����ģ���װ��һ��hashmap��
 * ���õ���ģʽ��
 * @author Administrator
 *
 */
public class Context {
	
	private static Context context = new Context();
	
	private Context() {
	}
	
	public static Context getInstance() {
		return context;
	}
	
	private HashMap<String, Integer> varHashMap = new HashMap<String, Integer>();
	
	public void put(String key, Integer value) {
		varHashMap.put(key, value);
	}
	
	public boolean containsKey(String key) {
		return varHashMap.containsKey(key);
	}
	
	public int getValue(String key) {
		return varHashMap.get(key);
	}
	
}
