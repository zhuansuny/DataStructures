package sort;
//ϣ���������ڲ�������
//ϣ������Ѱ����ݳ��ȵ�1/2���飬��ÿ��ʹ��ֱ�Ӳ��������㷨���򣻽�����֮ǰ��1/2�������ݳ��ȵ�1/4�������Դ����ƣ�
//����Խ��Խ�٣�ÿ������Ĺؼ���Խ��Խ�࣬������Ϊ1ʱ�������ļ�ǡ���ֳ�һ�飬�㷨����ֹ

public class ShellSort {
	public static void main(String[] args) {
		int num=80000;
		int[] a=new int[num];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random()*10000);
		}
		long start=System.currentTimeMillis();
		ShellSort.shellSort2(a);
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println("����ʱ��Ϊ"+time+"ms");
	}
	// ϣ��������ý�����, 
	public static void shellSort(int[] a){
		int temp=0;
		for(int gap=a.length/2;gap>0;gap/=2){
			for(int i=gap;i<a.length;i++){
				for(int j=i-gap;j>=0;j-=gap){
					if(a[j]>a[j+gap]){
						temp=a[j];
						a[j]=a[j+gap];
						a[j+gap]=temp;
					}
				}
			}
		}
		
		
		System.out.println("�����");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	//�Խ���ʽ��ϣ����������Ż�->��λ��
		public static void shellSort2(int[] arr) {
			
			// ����gap, ���𲽵���С����
			for (int gap = arr.length / 2; gap > 0; gap /= 2) {
				// �ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
				for (int i = gap; i < arr.length; i++) {
					int j = i;
					int temp = arr[j];
					if (arr[j] < arr[j - gap]) {
						while (j - gap >= 0 && temp < arr[j - gap]) {
							//�ƶ�
							arr[j] = arr[j-gap];
							j -= gap;
						}
						//���˳�while�󣬾͸�temp�ҵ������λ��
						arr[j] = temp;
					}

				}
			}
//			System.out.println("�����");
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
		}
}
