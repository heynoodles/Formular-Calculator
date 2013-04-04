package com.fc.calculator;

import java.util.Stack;

import com.fc.context.Context;
import com.fc.expression.Expression;
import com.fc.expression.VarExpression;
import com.fc.expression.binary.AddExpression;
import com.fc.expression.binary.DivExpression;
import com.fc.expression.binary.MulExpression;
import com.fc.expression.binary.SubExpression;

public class CalculatorImpl1 implements iCalculator {
	Expression expression;
	
	public CalculatorImpl1(String inStr) {
	   String postStr = inExp2postExp(inStr);
	   expression = geneExpression(postStr);	  
	}
	
	/*
     * ���ݺ�׺���ʽ�������յ�Expression
     */	
	@Override
	public Expression geneExpression(String postStr) {
		  // ���յı��ʽ
		  Expression expression;
		  char[] charArray = postStr.toCharArray();
		  Expression left;
		  Expression right;
		  Stack<Expression> stack = new Stack<Expression>();
		  for (int i = 0; i < charArray.length; i++) {
			switch(charArray[i]) {
				case '+':
					right = stack.pop();
					left = stack.pop();
					stack.push(new AddExpression(left, right));
					break;
				case '-':
					right = stack.pop();
					left = stack.pop();
					stack.push(new SubExpression(left, right));
					break;
				case '*':
					right = stack.pop();
					left = stack.pop();
					stack.push(new MulExpression(left, right));
					break;
				case '/':
					right = stack.pop();
					left = stack.pop();
					stack.push(new DivExpression(left, right));
					break;
				default:
					stack.push(new VarExpression(String.valueOf(charArray[i])));
				}
			}
			expression = stack.pop();
			return expression;
	}
   /*
	 * ����׺���ʽת��Ϊ��׺���ʽ
   */
	@Override
	public String inExp2postExp(String inExp) {
		  System.out.println("��׺���ʽ�� " + inExp);
		  Stack<String> s1 = new Stack<String>();
		  Stack<String> s2 = new Stack<String>();
		  String postExp = "";
		  
		  s1.push("#");
		  
		  char[] charArray =  inExp.toCharArray();
		  String operator = "";
		  for (int i = 0; i < charArray.length; i++) {
			  switch(charArray[i]) {
			  case '+':
				while (!s1.empty()) {
					operator = s1.pop();
					if (operator.equals("#") || operator.equals("(") || operator.equals(")")) {
						System.out.println("here");
						s1.push(operator);
						s1.push("+");
						break;
					} else {
						s2.push(operator);
					}
				}
				break;
			  case '-':
				while (!s1.empty()) {
					operator = s1.pop();
					if (operator.equals("#") || operator.equals("(") || operator.equals(")")) {
						s1.push(operator);
						s1.push("-");
						break;
					} else {
						s2.push(operator);
					}
				}
				break; 
			  case '*':
			  while (!s1.empty()) {
				operator = s1.pop();
				if (operator.equals("#") || operator.equals("+") || operator.equals("-") || operator.equals("(") || operator.equals(")")) {
					s1.push(operator);
					s1.push("*");
					break;
				} else {
					s2.push(operator);
				}
			  }
			  break; 
			  case '/':
				 while (!s1.empty()) {
					operator = s1.pop();
					if (operator.equals("#") || operator.equals("+") || operator.equals("-") || operator.equals("(") || operator.equals(")")) {
						s1.push(operator);
						s1.push("/");
						break;
					} else {
						s2.push(operator);
					}
				  }
				  break; 
			  case '(':
				  s1.push("(");
				  break;
			  case ')':
				  while (!(operator = s1.pop()).equals("(")) {
					  s2.push(operator);
				  }
				  break;
			  default:
				  s2.push(String.valueOf(charArray[i]));
				  break;
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
		  
		  System.out.println("��ꡱ��ʽ�� " + postExp);
		  return postExp;
	}
	
	public int run(Context context) {
		return expression.intepreter(context);
	}
}




