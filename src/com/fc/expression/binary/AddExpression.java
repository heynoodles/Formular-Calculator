package com.fc.expression.binary;
import java.security.SignatureException;

import com.fc.context.Context;
import com.fc.expression.Expression;


public class AddExpression extends BinarySignExpression {
	
	public AddExpression (Expression left, Expression right) {
		super(left, right);
		PRIORITY = 4; 
	}
	
	public AddExpression() {}
	
	public int intepreter(Context context) {
		return super.leftExpression.intepreter(context) + super.rightExpression.intepreter(context);
	}
}
