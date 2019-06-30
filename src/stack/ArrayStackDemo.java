package stack;
import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key="";
		boolean loop=true;
		Scanner scanner = new Scanner(System.in);
		while(loop){
			System.out.println("show: 表示显示栈");
			System.out.println("exit: 退出程序");
			System.out.println("push: 表示添加数据到栈(入栈)");
			System.out.println("pop: 表示从栈取出数据(出栈)");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是 %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}


class ArrayStack{
	private int maxSize;
	private int[] stack;
	private int top=-1;
	
	public ArrayStack(int maxSize){
		this.maxSize=maxSize;
		stack=new int[this.maxSize];
	}
	public boolean isFull(){
		return top==maxSize-1;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public int peek(){
		return stack[top];
	}
	public void push(int value){
		if(isFull()){
			System.out.println("栈已满，无法插入");
			return;
		}
		top++;
		stack[top]=value;
	}
	public int pop(){
		if(isEmpty()){

			throw new RuntimeException("栈空，无法取出");
		}
		int value=stack[top];
		top--;
		return value;
	}
	public void list(){
		if(isEmpty()){
			System.out.println("栈空,没有数据");
			return;
		}
		for (int i = top; i >=0; i--) {
			System.out.println(stack[i]);
		}
		
	}
	
	
	/*************************************/
	//计算器方法
	public int priority(int oper){
		if(oper=='*'||oper=='/'){
			return 1;
		}else if(oper=='*'||oper=='/'){
			return 0;
		}else{
			return -1;
		}
	}
	
	public boolean isOper(char val){
		return val=='+'||val=='-'||val=='*'||val=='/';
	}
	public int cal(int num1,int num2,char oper ){
		int res=0;
		switch(oper){
		case '+':
			res=num1+num2;
			break;
		case '-':
			res=num2-num1;
			break;
		case '*':
			res=num2*num1;
			break;
		case '/':
			res=num2/num1;
			break;
		default:
			break;
		}
		return res;
	}
}