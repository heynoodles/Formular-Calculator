package com.fc.expression.binary;
import com.fc.context.Context;
import com.fc.expression.Expression;


public class DivExpression extends BinarySignExpression {

	public DivExpression (Expression left, Expression right) {
		super(left, right);
		PRIORITY = 3;
	}
	
	public DivExpression() {}
	
	public int intepreter(Context context) {
		return super.leftExpression.intepreter(context) / super.rightExpression.intepreter(context);
	}
}
