package sort;
//选择排序
public class SelectSort {
	public static void main(String[] args) {
		int num=80000;
		int[] a=new int[num];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random()*10000);
		}
		long start=System.currentTimeMillis();
		SelectSort.selectSort(a);
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println("排序时间为"+time+"ms");
		//SelectSort.selectSort(a);
	}
	
	public static void selectSort(int[] a){

		for (int i = 0; i < a.length-1; i++) {
			int min=a[i];
			int minIndex = i;
			for (int j = i+1; j < a.length; j++) {
				if(min>a[j]){
					min=a[j];
					minIndex=j;
				}
			}
			if(minIndex!=i){
				a[minIndex]=a[i];
				a[i]=min;
			}
		}
		System.out.println("排序后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
