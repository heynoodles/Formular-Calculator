package com.fc.expression;
import com.fc.context.Context;

/**
 * ������������
 * @author Administrator
 *
 */
public class VarExpression extends Expression {

	String key = "";
	
	public VarExpression(String key) {
		this.key = key;
	}
	
	@Override
	public int intepreter(Context context) {
		// TODO Auto-generated method stub
		return context.getInstance().getValue(key);
	}

}
