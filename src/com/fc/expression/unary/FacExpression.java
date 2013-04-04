package com.fc.expression.unary;

import com.fc.context.Context;
import com.fc.expression.Expression;
/**
 * ½×³ËÔËËã
 * @author Administrator
 *
 */
public class FacExpression extends UnarySignExpression {

	public FacExpression(Expression expression) {
		super(expression);
		PRIORITY = 2;
	}
	
	public FacExpression() {
		PRIORITY = 2;
	}
	
	@Override
	public int intepreter(Context context) {
		// TODO Auto-generated method stub
		int a = super.expression.intepreter(context);
		int result = 1;
		for (int i = a; i > 0; i--) {
			result = result * i;
		}
		return result;
	}

}
