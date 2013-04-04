package com.fc.expression.binary;
import com.fc.context.Context;
import com.fc.expression.Expression;

/**
 * ¼õ·¨ÔËËã·û
 * @author Administrator
 *
 */
public class SubExpression extends BinarySignExpression {

	public SubExpression (Expression left, Expression right) {
		super(left, right);
		PRIORITY = 4;
	}
	
	public SubExpression() {}
	
	public int intepreter(Context context) {
		return super.leftExpression.intepreter(context) - super.rightExpression.intepreter(context);
	}
}
