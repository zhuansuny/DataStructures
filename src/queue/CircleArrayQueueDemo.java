package queue;
import java.util.Scanner;
public class CircleArrayQueueDemo {
	

	
		public static void main(String[] args) {
			
			CircleArray arrayQueue = new CircleArray(3);
			char key;
			boolean loop=true;
			Scanner scanner = new Scanner(System.in);
			while(loop){
				System.out.println("s(show):��ʾ����");
				System.out.println("e(exit):�˳�����");
				System.out.println("a(add):������ݵ�����");
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
	class CircleArray{
		private int maxSize; //�����������
		private int front;//����ͷ
		private int rear;//����β
		private int[] arr;//ģ����е�����
		//���й�����
		public CircleArray(int arrMaxSize){
			maxSize=arrMaxSize;
			arr=new int[maxSize];
//			front=-1;
//			rear=-1;
		}
		//�ж϶����Ƿ���
		public boolean isFull(){
			return (rear+1)%maxSize==front;
		}
		//�ж϶����Ƿ��
		public boolean isEmpty(){
			return rear==front;
		}
		//�����������
		public void addQueue(int n){
			if(isFull()){
				System.out.println("�������������ܼ�������");
				return;
			}
			arr[rear]=n;
			rear=(rear+1)%maxSize;
		}
		//����ȡ������
		public int getQueue(){
			if(isEmpty()){
				//System.out.println("���пգ�����ȡ������");
				throw new RuntimeException("���пգ�����ȡ������");
			}
			int num=arr[front];
			front=(front+1)%maxSize;
			return num;

		}
		//������������
		public void showQueue(){
			if(isEmpty()){
				System.out.println("���пգ�������");
				return;
			}
			for (int i = front; i < (front+size()); i++) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}
		//�鿴����ͷ����
		public int size(){
			return (rear+maxSize-front)%maxSize;
		}
		public int headQueue(){
			if(isEmpty()){
				//System.out.println("���пգ�����ȡ������");
				throw new RuntimeException("���пգ�������");
			}
			return arr[front];

		}
	}




