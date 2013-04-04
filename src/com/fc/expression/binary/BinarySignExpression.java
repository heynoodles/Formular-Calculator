package com.fc.expression.binary;
import com.fc.expression.Expression;
import com.fc.expression.SignExpression;

/**
 * Ë«Ä¿ÔËËã·û
 * @author Administrator
 *
 */
public abstract class BinarySignExpression extends SignExpression{
	
	public Expression leftExpression;
	public Expression rightExpression;
	
	public BinarySignExpression(Expression left, Expression right) {
		leftExpression = left;
		rightExpression = right;
	}
	
	public BinarySignExpression() {}
	
	public void setLeftRight(Expression left, Expression right) {
		this.leftExpression = left;
		this.rightExpression = right;
	}

}
