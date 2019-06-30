package stack;
//计算器实现
public class Calculator {
	public static void main(String[] args) {
		String expression ="14+13*4-2";//定义算术表达式
		//创建两个栈，一个存放数字一个存放运算符
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);
		//定义需要的相关变量
		int index=0;
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;
		char ch=' ';
		String keepNum="";
		while(true){
			ch = expression.substring(index, index+1).charAt(0);//将表达式逐个字符取出
			//判断取出字符是否为运算符
			if(operStack.isOper(ch)){
				//判断运算符栈是否为空
				if(!operStack.isEmpty()){
					//运算符栈不为空，则判断当前运算符与栈顶运算符的优先级
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
						//如果当前运算符小于栈顶运算符的优先级，则取出数字栈中两个数字以及运算符栈中的一个运算符进行计算
						num1=numStack.pop();
						num2=numStack.pop();
						oper=operStack.pop();
						//使用运算方法进行运算
						res=numStack.cal(num1, num2, (char) oper);
						//将运算结果插入到数字栈中，并将当前运输符插入到运算符栈
						numStack.push(res);
						operStack.push(ch);
					}else{
						//当前运算符大于栈顶运算符的优先级，则直接入栈
						operStack.push(ch);
					}
				}else{
					//运算符栈为空，则直接入栈
					operStack.push(ch);
				}
			}else{
		    //判断取出字符是数字
				keepNum+=ch;
				//首先判断是否是最后一个字符
				if(index==expression.length()-1){
					//是最后一个字符，直接入栈
					numStack.push(Integer.parseInt(keepNum));
				}else{
					//不是最后一个字符，判断下一个字符是否是运算符
					if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))){
						//下一个字符是运算符，则入栈并将keepNum清零，否则继续循环并拼接字符串keepNum
						numStack.push(Integer.parseInt(keepNum));
						keepNum="";
					}
				}
			}
			//index递增
			index++;
			//扫描到expression最后退出循环
			if(index>=expression.length()){
				break;
			}
		}
		////当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
		while(true){
			//如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字
			if(operStack.isEmpty()){
				break;
			}
			//不为空则逐步从数字栈取出两个数字，运算符栈取出一个进行运算，得出的结果在插入到数字栈中，直到运算符栈为空
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, (char) oper);
			numStack.push(res);
		}
		//将数栈的最后数，pop出，就是结果
		System.out.printf("表达式%s=%d",expression,numStack.pop());
	}
}
