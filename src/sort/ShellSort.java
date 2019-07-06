package sort;
//希尔排序（属于插入排序）
//希尔排序把按数据长度的1/2分组，对每组使用直接插入排序算法排序；接着在之前的1/2（即数据长度的1/4）分组以此类推，
//组数越来越少，每组包含的关键词越来越多，当组数为1时，整个文件恰被分成一组，算法便终止

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
		System.out.println("排序时间为"+time+"ms");
	}
	// 希尔排序采用交换法, 
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
		
		
		System.out.println("排序后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	//对交换式的希尔排序进行优化->移位法
		public static void shellSort2(int[] arr) {
			
			// 增量gap, 并逐步的缩小增量
			for (int gap = arr.length / 2; gap > 0; gap /= 2) {
				// 从第gap个元素，逐个对其所在的组进行直接插入排序
				for (int i = gap; i < arr.length; i++) {
					int j = i;
					int temp = arr[j];
					if (arr[j] < arr[j - gap]) {
						while (j - gap >= 0 && temp < arr[j - gap]) {
							//移动
							arr[j] = arr[j-gap];
							j -= gap;
						}
						//当退出while后，就给temp找到插入的位置
						arr[j] = temp;
					}

				}
			}
//			System.out.println("排序后：");
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
		}
}
