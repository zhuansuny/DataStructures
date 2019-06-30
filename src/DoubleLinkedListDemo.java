
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("双向链表测试");
		//先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		//HeroNode2 hero5 = new HeroNode2(2, "卢俊义2", "玉麒麟3");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		//doubleLinkedList.update(hero5);
		doubleLinkedList.list();
		
		
	}
}

class DoubleLinkedList{
	private HeroNode2 head =new HeroNode2(0,"","");
	
	// 返回头节点
	public HeroNode2 getHead() {
		return head;
	}
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移， 一定小心
			temp = temp.next;
		}
	}
	// 添加一个节点到双向链表的最后.
	public void add(HeroNode2 heroNode) {

		// 因为head节点不能动，需要一个辅助遍历 temp
		HeroNode2 temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 找到链表的最后
			if (temp.next == null) {//
				break;
			}
			// 如果没有找到最后, 将将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	public void addByOrder(HeroNode2 heroNode){
		HeroNode2 temp = head.next;
		boolean flag =false;
		while(true){
			if(temp==null){
				break;
			}
			if(temp.no>heroNode.no){
				break;
			}else if(temp.no==heroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			System.out.println("准备添加的英雄编号已经存在，不能加入"+heroNode);
		}else{
			if(temp==null){
				head.next=heroNode;
				heroNode.pre=head;
			}else{
				temp.pre.next=heroNode;
				heroNode.next=temp;
				heroNode.pre=temp.pre;
				temp.pre=heroNode;
			}
			
		}
		
	}
	// 修改一个节点的内容, 双向链表的节点内容修改和单向链表一样
		public void update(HeroNode2 newHeroNode) {
			// 判断是否空
			if (head.next == null) {
				System.out.println("链表为空~");
				return;
			}
			// 找到需要修改的节点, 根据no编号
			// 定义一个辅助变量
			HeroNode2 temp = head.next;
			boolean flag = false; // 表示是否找到该节点
			while (true) {
				if (temp == null) {
					break; // 已经遍历完链表
				}
				if (temp.no == newHeroNode.no) {
					// 找到
					flag = true;
					break;
				}
				temp = temp.next;
			}
			// 根据flag 判断是否找到要修改的节点
			if (flag) {
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			} else { // 没有找到
				System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
			}
		}
	
		public void del(int no) {
			HeroNode2 temp = head;
			boolean flag = false; // 标志是否找到待删除节点的
			while(true) {
				if(temp == null) { //已经到链表的最后
					break;
				}
				if(temp.no == no) {
					//找到的待删除节点的前一个节点temp
					flag = true;
					break;
				}
				temp = temp.next; //temp后移，遍历
			}
			//判断flag
			if(flag) { //找到
				// 可以删除
				// temp.next = temp.next.next;[单向链表]
				temp.pre.next = temp.next;
				// 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
				if (temp.next != null) {
					temp.next.pre = temp.pre;
				}
			}else {
				System.out.printf("要删除的 %d 节点不存在\n", no);
			}
		}
}


class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	
	public HeroNode2(int no,String name,String nickname ){
		this.no=no;
		this.name=name;
		this.nickname=nickname;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}