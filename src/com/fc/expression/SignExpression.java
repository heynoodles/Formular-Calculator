package com.fc.expression;

/**
 * ���з�����ĳ�����
 * @author Administrator
 *
 */
public abstract class SignExpression extends Expression {

	protected int PRIORITY = 13;
	
	public int getPriority() {
		return PRIORITY;
	}
}
