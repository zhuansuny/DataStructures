import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key;
		boolean loop=true;
		Scanner scanner = new Scanner(System.in);
		while(loop){
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key= scanner.next().charAt(0);
			switch(key){
			case 's':
				arrayQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop=false;
				break;
			
			case 'a':
				System.out.println("������һ������");
				int value=scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try{
					System.out.println("ȡ����������"+arrayQueue.getQueue());
				}catch(Exception e){
					System.out.println(e.getMessage());
				}	
				break;
			case 'h':
				try{
					System.out.println("����ͷ��������"+arrayQueue.headQueue());
				}catch(Exception e){
					System.out.println(e.getMessage());
				}	
				break;
			default:
				break;
			
			
		}
	}
		System.out.println("�����˳�");
}
}
class ArrayQueue{
	private int maxSize; //�����������
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//ģ����е�����
	//���й�����
	public ArrayQueue(int arrMaxSize){
		maxSize=arrMaxSize;
		arr=new int[maxSize];
		front=-1;
		rear=-1;
	}
	//�ж϶����Ƿ���
	public boolean isFull(){
		return rear==maxSize-1;
	}
	//�ж϶����Ƿ��
	public boolean isEmpty(){
		return rear==front;
	}
	//������������
	public void addQueue(int n){
		if(isFull()){
			System.out.println("�������������ܼ�������");
			return;
		}
		rear++;
		arr[rear]=n;
	}
	//����ȡ������
	public int getQueue(){
		if(isEmpty()){
			//System.out.println("���пգ�����ȡ������");
			throw new RuntimeException("���пգ�����ȡ������");
		}
		front++;
		int num=arr[front];
		arr[front]=0;
		return num;

	}
	//������������
	public void showQueue(){
		if(isEmpty()){
			System.out.println("���пգ�������");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	//�鿴����ͷ����
	public int headQueue(){
		if(isEmpty()){
			//System.out.println("���пգ�����ȡ������");
			throw new RuntimeException("���пգ�������");
		}
		return arr[front+1];

	}
}

