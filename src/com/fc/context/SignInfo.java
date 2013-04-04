package com.fc.context;
/**
 * 从operator中读取SignInfo信息
 * @author Administrator
 *
 */
public class SignInfo implements Comparable<Object>{
	String name;
	String classURL;
	int priority;
	
	public SignInfo(String name, String classURL, int priority) {
		this.name = name;
		this.classURL = classURL;
		this.priority = priority;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getClassURL() {
		return this.classURL;
	}
	
	public int getPiority() {
		return this.priority;
	}
	
	public String toString() {
		return ("operator: " + name + " class url: " + classURL + " priority: " + priority);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof SignInfo) {
			SignInfo outp = (SignInfo)o;
			return (outp.getPiority()> priority) ? 1:((outp.getPiority()== priority) ? 0 : -1); 
		} else {
			return 0;
		}
	}
}
