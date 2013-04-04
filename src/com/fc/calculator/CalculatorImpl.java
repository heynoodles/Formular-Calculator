package com.fc.calculator;


import java.util.Stack;

import com.fc.context.Context;
import com.fc.context.SignFactory;
import com.fc.expression.Expression;
import com.fc.expression.VarExpression;
import com.fc.expression.binary.BinarySignExpression;
import com.fc.expression.unary.UnarySignExpression;

public class CalculatorImpl implements iCalculator {

	Expression expression;
	
	public CalculatorImpl(String inStr) {
		String postStr = inExp2postExp(inStr);
		expression = geneExpression(postStr);
	}
	
	
	public static void main(String args[]) {
		
	}
	
	@Override
	public Expression geneExpression(String postStr) {
		Expression expression;
		char[] charArray = postStr.toCharArray();
		Expression uexp;
		Expression left;
		Expression right;
		Stack<Expression> stack = new Stack<Expression>();
		for (int i = 0; i < charArray.length; i++) {
			String expStr = String.valueOf(charArray[i]);
			if (SignFactory.isBinarySymbol(expStr)) {
				right = stack.pop();
				left = stack.pop();
				BinarySignExpression exp = (BinarySignExpression) SignFactory.getExpression(expStr);
				exp.setLeftRight(left, right);
				stack.push(exp);
			} else if (SignFactory.isUnarySymbol(expStr)) {
				uexp = stack.pop();
				UnarySignExpression exp = (UnarySignExpression)SignFactory.getExpression(expStr);
				exp.setExpression(uexp);
				stack.push(exp);
			} else {
				stack.push(new VarExpression(expStr));
			}
		}
		expression = stack.pop();
		return expression;
	}	

	@Override
	public String inExp2postExp(String inExp) {
		System.out.println("中缀表达式： " + inExp);
		Stack<String> s1 = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		String postExp = "";
		  
		s1.push("#");
		  
		char[] charArray =  inExp.toCharArray();
		String operator = "";
		for (int i = 0; i < charArray.length; i++) {
			String expStr = String.valueOf(charArray[i]);
			if (SignFactory.isSymbol(expStr)) {
				while (!s1.empty()) {
					operator = s1.pop();
					if (SignFactory.comparePriority(operator, expStr) || operator.equals("#") || operator.equals("(") || operator.equals(")")) {
						s1.push(operator);
						s1.push(expStr);
						break;
					} else {
						s2.push(operator);
					}
				}
			} else if (expStr.equals("(")) {
				  s1.push("(");
			} else if (expStr.equals("")) {
				  while (!(operator = s1.pop()).equals("(")) {
					  s2.push(operator);
				  }				
			} else {
				 s2.push(expStr);
			}
		}			
		
		while (!s1.empty()) {
			 operator = s1.pop();
			 s2.push(operator);
		 }
		  
		while (!s2.empty()) {
			 if (!(operator = s2.pop()).equals("#")) {
				 postExp = operator + postExp;
			 }
		 }
		  
		 System.out.println("后辍表达式： " + postExp);
		 return postExp;
	}

	@Override
	public int run(Context context) {
		return expression.intepreter(context);
	}

}
