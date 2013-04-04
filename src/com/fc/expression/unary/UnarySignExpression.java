package com.fc.expression.unary;

import com.fc.expression.Expression;
import com.fc.expression.SignExpression;

public abstract class UnarySignExpression extends SignExpression {

	 public Expression expression;
	 
	 public UnarySignExpression(Expression expression) {
		 this.expression = expression;
	 }
	 
	 public UnarySignExpression() {}
	 
	 public void setExpression(Expression expression) {
		 this.expression = expression; 
	 }

}
