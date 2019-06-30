package stack;
//������ʵ��
public class Calculator {
	public static void main(String[] args) {
		String expression ="14+13*4-2";//�����������ʽ
		//��������ջ��һ���������һ����������
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);
		//������Ҫ����ر���
		int index=0;
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;
		char ch=' ';
		String keepNum="";
		while(true){
			ch = expression.substring(index, index+1).charAt(0);//�����ʽ����ַ�ȡ��
			//�ж�ȡ���ַ��Ƿ�Ϊ�����
			if(operStack.isOper(ch)){
				//�ж������ջ�Ƿ�Ϊ��
				if(!operStack.isEmpty()){
					//�����ջ��Ϊ�գ����жϵ�ǰ�������ջ������������ȼ�
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
						//�����ǰ�����С��ջ������������ȼ�����ȡ������ջ�����������Լ������ջ�е�һ����������м���
						num1=numStack.pop();
						num2=numStack.pop();
						oper=operStack.pop();
						//ʹ�����㷽����������
						res=numStack.cal(num1, num2, (char) oper);
						//�����������뵽����ջ�У�������ǰ��������뵽�����ջ
						numStack.push(res);
						operStack.push(ch);
					}else{
						//��ǰ���������ջ������������ȼ�����ֱ����ջ
						operStack.push(ch);
					}
				}else{
					//�����ջΪ�գ���ֱ����ջ
					operStack.push(ch);
				}
			}else{
		    //�ж�ȡ���ַ�������
				keepNum+=ch;
				//�����ж��Ƿ������һ���ַ�
				if(index==expression.length()-1){
					//�����һ���ַ���ֱ����ջ
					numStack.push(Integer.parseInt(keepNum));
				}else{
					//�������һ���ַ����ж���һ���ַ��Ƿ��������
					if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))){
						//��һ���ַ��������������ջ����keepNum���㣬�������ѭ����ƴ���ַ���keepNum
						numStack.push(Integer.parseInt(keepNum));
						keepNum="";
					}
				}
			}
			//index����
			index++;
			//ɨ�赽expression����˳�ѭ��
			if(index>=expression.length()){
				break;
			}
		}
		////�����ʽɨ����ϣ���˳��Ĵ� ��ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������.
		while(true){
			//�������ջΪ�գ�����㵽���Ľ��, ��ջ��ֻ��һ������
			if(operStack.isEmpty()){
				break;
			}
			//��Ϊ�����𲽴�����ջȡ���������֣������ջȡ��һ���������㣬�ó��Ľ���ڲ��뵽����ջ�У�ֱ�������ջΪ��
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, (char) oper);
			numStack.push(res);
		}
		//����ջ���������pop�������ǽ��
		System.out.printf("���ʽ%s=%d",expression,numStack.pop());
	}
}
