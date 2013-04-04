package com.fc.expression.binary;
import com.fc.context.Context;
import com.fc.expression.Expression;


public class MulExpression extends BinarySignExpression {

	public MulExpression (Expression left, Expression right) {
		super(left, right);
		PRIORITY = 3;
	}
	
	public MulExpression() {}
	
	public int intepreter(Context context) {
		return super.leftExpression.intepreter(context) * super.rightExpression.intepreter(context);
	}
}
