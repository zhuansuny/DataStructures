package sort;
//插入排序
//相当于重新建立一个数组，将原数组的数据逐次按大小插入新数组中
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
		System.out.println("排序时间为"+time+"ms");
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
		System.out.println("排序后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
