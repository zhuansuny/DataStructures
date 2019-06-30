
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("˫���������");
		//�ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		//HeroNode2 hero5 = new HeroNode2(2, "¬����2", "������3");
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
	
	// ����ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㣬���ܶ�����Ҫһ����������������
		HeroNode2 temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ��temp���ƣ� һ��С��
			temp = temp.next;
		}
	}
	// ���һ���ڵ㵽˫����������.
	public void add(HeroNode2 heroNode) {

		// ��Ϊhead�ڵ㲻�ܶ�����Ҫһ���������� temp
		HeroNode2 temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ���������
			if (temp.next == null) {//
				break;
			}
			// ���û���ҵ����, ����temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ������������
		// �γ�һ��˫������
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
			System.out.println("׼����ӵ�Ӣ�۱���Ѿ����ڣ����ܼ���"+heroNode);
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
	// �޸�һ���ڵ������, ˫������Ľڵ������޸ĺ͵�������һ��
		public void update(HeroNode2 newHeroNode) {
			// �ж��Ƿ��
			if (head.next == null) {
				System.out.println("����Ϊ��~");
				return;
			}
			// �ҵ���Ҫ�޸ĵĽڵ�, ����no���
			// ����һ����������
			HeroNode2 temp = head.next;
			boolean flag = false; // ��ʾ�Ƿ��ҵ��ýڵ�
			while (true) {
				if (temp == null) {
					break; // �Ѿ�����������
				}
				if (temp.no == newHeroNode.no) {
					// �ҵ�
					flag = true;
					break;
				}
				temp = temp.next;
			}
			// ����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
			if (flag) {
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			} else { // û���ҵ�
				System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
			}
		}
	
		public void del(int no) {
			HeroNode2 temp = head;
			boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
			while(true) {
				if(temp == null) { //�Ѿ�����������
					break;
				}
				if(temp.no == no) {
					//�ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
					flag = true;
					break;
				}
				temp = temp.next; //temp���ƣ�����
			}
			//�ж�flag
			if(flag) { //�ҵ�
				// ����ɾ��
				// temp.next = temp.next.next;[��������]
				temp.pre.next = temp.next;
				// ��������һ���ڵ㣬�Ͳ���Ҫִ��������仰��������ֿ�ָ��
				if (temp.next != null) {
					temp.next.pre = temp.pre;
				}
			}else {
				System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
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