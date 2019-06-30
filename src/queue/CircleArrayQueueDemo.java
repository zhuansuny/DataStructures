package queue;
import java.util.Scanner;
public class CircleArrayQueueDemo {
	

	
		public static void main(String[] args) {
			
			CircleArray arrayQueue = new CircleArray(3);
			char key;
			boolean loop=true;
			Scanner scanner = new Scanner(System.in);
			while(loop){
				System.out.println("s(show):显示队列");
				System.out.println("e(exit):退出程序");
				System.out.println("a(add):添加数据到队列");
				System.out.println("g(get):从队列取出数据");
				System.out.println("h(head):查看队列头的数据");
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
					System.out.println("请输入一个整数");
					int value=scanner.nextInt();
					arrayQueue.addQueue(value);
					break;
				case 'g':
					try{
						System.out.println("取出的数据是"+arrayQueue.getQueue());
					}catch(Exception e){
						System.out.println(e.getMessage());
					}	
					break;
				case 'h':
					try{
						System.out.println("队列头的数据是"+arrayQueue.headQueue());
					}catch(Exception e){
						System.out.println(e.getMessage());
					}	
					break;
				default:
					break;
				
				
			}
		}
			System.out.println("程序退出");
	}
}
	class CircleArray{
		private int maxSize; //队列最大容量
		private int front;//队列头
		private int rear;//队列尾
		private int[] arr;//模拟队列的数组
		//队列构造器
		public CircleArray(int arrMaxSize){
			maxSize=arrMaxSize;
			arr=new int[maxSize];
//			front=-1;
//			rear=-1;
		}
		//判断队列是否满
		public boolean isFull(){
			return (rear+1)%maxSize==front;
		}
		//判断队列是否空
		public boolean isEmpty(){
			return rear==front;
		}
		//队列添加数据
		public void addQueue(int n){
			if(isFull()){
				System.out.println("队列已满，不能加入数据");
				return;
			}
			arr[rear]=n;
			rear=(rear+1)%maxSize;
		}
		//队列取出数据
		public int getQueue(){
			if(isEmpty()){
				//System.out.println("队列空，不能取出数据");
				throw new RuntimeException("队列空，不能取出数据");
			}
			int num=arr[front];
			front=(front+1)%maxSize;
			return num;

		}
		//遍历队列数据
		public void showQueue(){
			if(isEmpty()){
				System.out.println("队列空，无数据");
				return;
			}
			for (int i = front; i < (front+size()); i++) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}
		//查看队列头数据
		public int size(){
			return (rear+maxSize-front)%maxSize;
		}
		public int headQueue(){
			if(isEmpty()){
				//System.out.println("队列空，不能取出数据");
				throw new RuntimeException("队列空，无数据");
			}
			return arr[front];

		}
	}




