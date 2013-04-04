package com.fc.context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.fc.expression.Expression;
import com.fc.expression.binary.BinarySignExpression;
import com.fc.expression.unary.UnarySignExpression;

@SuppressWarnings("restriction")
public class SignFactory {
	public static Map<String, SignInfo> signlist = new HashMap<String, SignInfo>(); 
	
	static {
		initSignList();
	}
	
	public static void main(String[] args) {
		//Expression exp = SignFactory.getExpression("/");
		//System.out.println(exp.getClass().getName());
		
		SignFactory signFactory = new SignFactory();
		System.out.println(signFactory);
	}
	
	/*
	 * ��ʼ��signlist
	 */
	private static void initSignList() {
		SAXBuilder builder = new SAXBuilder();
		Document read_doc = null;
		try {
			read_doc = builder.build("./bin/com/fc/config/operator.xml");
		} catch (JDOMException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		SignInfo si = null;
		Element stu = read_doc.getRootElement(); // ��ȡ���ڵ�
		List<Element> list = stu.getChildren("binaryOperator"); // ��ȡ��Ԫ�ص������ӽڵ�
		List<Element> unarylist = stu.getChildren("unaryOperator");
		for (int i = 0; i < list.size(); i++) { // �����ӽڵ㣬��ȡ�������ԡ��ӽڵ���ı���
			Element e = list.get(i);
			String classURL = e.getChildText("class");
			String name = e.getAttribute("name").getValue();
			String pri = e.getAttribute("priority").getValue();
			si = new SignInfo(name, classURL, Integer.parseInt(pri));
			signlist.put(name, si);
		}
		for (int i = 0; i < unarylist.size(); i++) { // �����ӽڵ㣬��ȡ�������ԡ��ӽڵ���ı���
			Element e = unarylist.get(i);
			String classURL = e.getChildText("class");
			String name = e.getAttribute("name").getValue();
			String pri = e.getAttribute("priority").getValue();
			si = new SignInfo(name, classURL, Integer.parseInt(pri));
			signlist.put(name, si);
		}

	}
	
	public String toString() {
		String result = "";
		Set<String> operator = signlist.keySet();
		Iterator<String> it = operator.iterator();
		while (it.hasNext()) {
			result = result + signlist.get(it.next()) + "\r\n";
		}
		return result;
	}
	
	/*
	 * op1�����ȼ�����op2���򷵻�true
	 */
	public static boolean comparePriority(String op1, String op2) {
		
		if (isSymbol(op1) && isSymbol(op2)) {
			SignInfo si1 = signlist.get(op1);
			SignInfo si2 = signlist.get(op2);
		
			if (si1.compareTo(si2) == -1) {
				return true;
			}
		}
		return false;
		
	}
	
	/*
	 * sign�Ƿ�ΪһĿ�����
	 */
	public static boolean isUnarySymbol (String sign) {
		if (isSymbol(sign)) {
			Expression exp = SignFactory.getExpression(sign);
			if (exp instanceof UnarySignExpression) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/*
	 * sign�Ƿ�Ϊ��Ŀ�����
	 */
	public static boolean isBinarySymbol(String sign) {
		if (isSymbol(sign)) {
			Expression exp = SignFactory.getExpression(sign);
			if (exp instanceof BinarySignExpression) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	
	/*
	 * sign�Ƿ�Ϊ���еķ���
	 */
	public static boolean isSymbol(String sign) {
		return signlist.containsKey(sign);
	}
	
	/*
	 * ����sign��ʵ����
	 */
	public static Expression getExpression(String sign) {
		Expression cc = null;
		if (signlist.containsKey(sign)) {
			try {
				cc = (Expression) Class.forName((String)(((SignInfo)signlist.get(sign)).getClassURL())).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cc;
		}
		return null;
	}
}
