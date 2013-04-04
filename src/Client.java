import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fc.calculator.CalculatorImpl;
import com.fc.calculator.CalculatorImpl1;
import com.fc.calculator.iCalculator;
import com.fc.context.Context;



public class Client {
	
	public static void main(String[] args) throws IOException {
		String expstr = getStr();
		Context context = getValue(expstr);
		iCalculator cal = new CalculatorImpl(expstr);
		System.out.println(cal.run(context));
	}
	
	
	public static String getStr() throws IOException {
		System.out.println("请输入表达式");
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}
	
	public static Context getValue(String expStr) throws IOException {
		Context context = Context.getInstance();
		for (char c: expStr.toCharArray()) {
			if (!context.containsKey(String.valueOf(c)) && c!='+' && c!= '-' && c!= '*' && c!= '/' && c!= '(' && c!= ')' && c!='!') {
				System.out.println(c+" = ");
				String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				context.put(String.valueOf(c), Integer.parseInt(in));
			}
		}
		return context;
	}
}
