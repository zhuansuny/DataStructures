//Լɪ������
public class Josepfu {
	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1,2,5);
	}
}

class CircleSingleLinkedList{
	private Boy first=new Boy(-1);
	public void addBoy(int nums){
		if(nums<1){
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy=null;
		for (int i = 1; i <=nums; i++) {
			Boy boy=new Boy(i);
			if(i==1){
				first=boy;
				first.setNext(first);
				curBoy=first;
			}else{
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
	}
	public void showBoy(){
		if(first==null){
			System.out.println("����Ϊ��");
			return;
		}
		Boy curBoy=first;
		while(true){
			System.out.printf("���%d\n",curBoy.getNo());
			if(curBoy.getNext()==first){
				break;
			}
			curBoy=curBoy.getNext();
		}
	}
	
	public void countBoy(int startNo,int countNum,int nums){
		if(first==null||startNo<1||startNo>nums){
			System.err.println("���������������������");
			return;
		}
		Boy helper=first;
		while(true){
			if(helper.getNext()==first){
				break;
			}
			helper=helper.getNext();
		}
		for (int i = 0; i < startNo-1; i++) {
			first=first.getNext();
			helper=helper.getNext();		
		}
		
		while(true){
			if(helper==first){
				break;
			}
			for (int i = 0; i < countNum-1; i++) {
				first=first.getNext();
				helper=helper.getNext();
			}
			System.out.printf("�к�%d��Ȧ\n",first.getNo());
			first=first.getNext();
			helper.setNext(first);
			
		}
		System.out.println("�����к�"+first.getNo());
	}
}
class Boy{
	private int no;
	private Boy next;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	public Boy(int no){
		this.no=no;
	}
	
}