package sort;
//��������
//�൱�����½���һ�����飬��ԭ�����������ΰ���С������������
public class InsertSort {
	public static void main(String[] args) {
		int num=80000;
		int[] a=new int[num];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random()*10000);
		}
		long start=System.currentTimeMillis();
		InsertSort.insertSort(a);
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println("����ʱ��Ϊ"+time+"ms");
	}
	public static void insertSort(int[] a){
		int insertVal=0;
		int insertIndex=0;
		for (int i = 1; i < a.length; i++) {
			insertVal=a[i];
			insertIndex=i-1;
			while(insertIndex>=0&&insertVal<a[insertIndex]){
				a[insertIndex+1]=a[insertIndex];
				insertIndex--;
			}
			a[insertIndex+1]=insertVal;
		}
		System.out.println("�����");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
