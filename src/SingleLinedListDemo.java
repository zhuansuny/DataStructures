import java.util.Stack;

public class SingleLinedListDemo {
	
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		//HeroNode hero5 = new HeroNode(1, "¬����2", "������3");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//��˳�����ڵ� 
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		//��ӡ�ڵ�
		singleLinkedList.list();
		//��ת����
		reverseList(singleLinkedList.getHead());
		singleLinkedList.list();
		//�������ӡ
		reversePrint(singleLinkedList.getHead());
	}
	//�������ӡ����
	public static void reversePrint(HeroNode head){
		//�ж������Ƿ�Ϊ��
		if(head.next==null){
			System.out.println("����Ϊ�գ��޷���ӡ");
		}
		HeroNode cur=head.next;
		//����ջ
		Stack<HeroNode> stack=new Stack<>();
		//���ڵ�ѹ��ջ��
		while(cur!=null){
			stack.push(cur);
			cur=cur.next;
		}
		//��ջ��ȡ�����ݲ���ӡ
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
	//�������ͷ�ڵ�������ڵ㷴ת����
	public static void reverseList(HeroNode head){
		//�ж������Ƿ����һ�����ϵ���Ч�ڵ�
		if(head.next==null||head.next.next==null){
			return;
		}
		HeroNode cur=head.next;
		HeroNode next=null;
		HeroNode reverseHead= new HeroNode(0,"","");
		reverseHead.next=next;
		while(cur!=null){
			next=cur.next;
			cur.next=reverseHead.next;
			reverseHead.next=cur;
			cur=next;
		}
		head.next=reverseHead.next;
	}
}

//������
class SingleLinkedList{
	private HeroNode head =new HeroNode(0,"","");
	
	public void add(HeroNode heroNode){
		HeroNode temp = head;
		while(true){
			if(temp.next==null){
				break;
			}
			temp=temp.next;
		}
		temp.next=heroNode;
	}
	
	public HeroNode getHead() {
		
		return head;
	}

	public void del(HeroNode HeroNode){
		if(head.next==null){
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return;
		}
		HeroNode temp=head;
		boolean flag=false;
		while(true){
			if(temp.next==null){
				break;
			}
			if(temp.next.no==HeroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			temp.next=temp.next.next;
		}else{
			System.out.printf("û���ҵ��Ľڵ㣬δɾ��\n",HeroNode.no);
		}
		
	}
	public void update(HeroNode newHeroNode){
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp=head.next;
		boolean flag=false;
		while(true){
			if(temp==null){
				break;
			}
			if(temp.no==newHeroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			temp.name=newHeroNode.name;
			temp.nickname=newHeroNode.nickname;
		}else{
			System.out.printf("û���ҵ����%d �Ľڵ㣬�����޸�\n",newHeroNode.no);
		}
	}
	
	public void addByOrder(HeroNode heroNode){
		HeroNode temp = head;
		boolean flag =false;
		while(true){
			if(temp.next==null){
				break;
			}
			if(temp.next.no>heroNode.no){
				break;
			}else if(temp.next.no==heroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			System.out.println("׼����ӵ�Ӣ�۱���Ѿ����ڣ����ܼ���"+heroNode);
		}else{
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
		
	}
	
	public void list(){
		
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while(true){
			if(temp==null){
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}
	}
	
}

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	public HeroNode(int no,String name,String nickname ){
		this.no=no;
		this.name=name;
		this.nickname=nickname;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}