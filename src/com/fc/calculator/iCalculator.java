package com.fc.calculator;

import com.fc.context.Context;
import com.fc.expression.Expression;

public interface iCalculator {
	public Expression geneExpression(String postStr);
	public String inExp2postExp (String inExp);
	public int run(Context context);
}
