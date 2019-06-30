package stack;
import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key="";
		boolean loop=true;
		Scanner scanner = new Scanner(System.in);
		while(loop){
			System.out.println("show: ��ʾ��ʾջ");
			System.out.println("exit: �˳�����");
			System.out.println("push: ��ʾ������ݵ�ջ(��ջ)");
			System.out.println("pop: ��ʾ��ջȡ������(��ջ)");
			System.out.println("���������ѡ��");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ�������� %d\n", res);
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
	
	public void push(int value){
		if(isFull()){
			System.out.println("ջ�������޷�����");
			return;
		}
		top++;
		stack[top]=value;
	}
	public int pop(){
		if(isEmpty()){

			throw new RuntimeException("ջ�գ��޷�ȡ��");
		}
		int value=stack[top];
		top--;
		return value;
	}
	public void list(){
		if(isEmpty()){
			System.out.println("ջ��,û������");
			return;
		}
		for (int i = top; i >=0; i--) {
			System.out.println(stack[i]);
		}
		
	}
}