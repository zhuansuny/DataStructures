import java.util.Stack;

public class SingleLinedListDemo {
	
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		//HeroNode hero5 = new HeroNode(1, "卢俊义2", "玉麒麟3");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//按顺序插入节点 
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		//打印节点
		singleLinkedList.list();
		//反转链表
		reverseList(singleLinkedList.getHead());
		singleLinkedList.list();
		//链表反序打印
		reversePrint(singleLinkedList.getHead());
	}
	//链表反序打印方法
	public static void reversePrint(HeroNode head){
		//判断链表是否为空
		if(head.next==null){
			System.out.println("链表为空，无法打印");
		}
		HeroNode cur=head.next;
		//创建栈
		Stack<HeroNode> stack=new Stack<>();
		//将节点压入栈中
		while(cur!=null){
			stack.push(cur);
			cur=cur.next;
		}
		//从栈中取出数据并打印
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
	//将链表除头节点的其它节点反转方法
	public static void reverseList(HeroNode head){
		//判断链表是否存在一个以上的有效节点
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

//单链表
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
			System.out.println("链表为空，无法删除");
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
			System.out.printf("没有找到的节点，未删除\n",HeroNode.no);
		}
		
	}
	public void update(HeroNode newHeroNode){
		if(head.next==null){
			System.out.println("链表为空");
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
			System.out.printf("没有找到编号%d 的节点，不能修改\n",newHeroNode.no);
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
			System.out.println("准备添加的英雄编号已经存在，不能加入"+heroNode);
		}else{
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
		
	}
	
	public void list(){
		
		if(head.next==null){
			System.out.println("链表为空");
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