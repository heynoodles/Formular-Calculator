package com.fc.expression;

/**
 * 所有符号类的抽象类
 * @author Administrator
 *
 */
public abstract class SignExpression extends Expression {

	protected int PRIORITY = 13;
	
	public int getPriority() {
		return PRIORITY;
	}
}
