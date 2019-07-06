package sort;
//√∞≈›≈≈–Ú
public class BubbleSort {
	public static void main(String[] args) {
		int num=80000;
		int[] a=new int[num];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random()*10000);
		}
		
		long start=System.currentTimeMillis();
		BubbleSort.bubbleSort(a);
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println("≈≈–Ú ±º‰Œ™"+time+"ms");
	}
	public static void bubbleSort(int[] a){
		int temp;
		boolean flag=false;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j]>a[j+1]){
					flag=true;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			if(flag==false){
				break;
			}else{
				flag=false;
			}
		}
		System.out.println("≈≈–Ú∫Û£∫");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
