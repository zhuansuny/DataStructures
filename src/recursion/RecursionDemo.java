package recursion;
//µ›πÈ √‘π¨Œ Ã‚
public class RecursionDemo {
	public static void main(String[] args) {
		//System.out.println(factorial(11));//Ω◊≥À
		int[][] map=new int[15][10];
		//System.out.println( map[0].length);
		for (int i = 0; i < map[0].length; i++) {
			map[0][i]=1;
			map[map.length-1][i]=1;
			//map[2][i]=1;
		}
		for (int i = 0; i < map.length; i++) {
			map[i][0]=1;
			map[i][map[0].length-1]=1;
		}
		map[2][1]=1;
		map[2][2]=1;
		boolean b=setWay(map,1,1);
		System.out.println(b);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void test(int[] b){
		b[0]=4;
	}
	//Ω◊≥À∑Ω∑®
	public static long factorial(long n){
		if(n>1){
			return n*factorial(n-1);
		}
		return 1;
	}
	//√‘π¨Œ Ã‚
	public static boolean setWay(int[][] map,int i,int j){
		if(map[map.length-2][map[0].length-2]==2){
			return true;
		}
		if(map[i][j]==0){
			map[i][j]=2;
			if(setWay(map,i+1,j)){
				return true;
			}else if(setWay(map,i,j+1)){
				return true;
			}else if(setWay(map,i-1,j)){
				return true;
			}else if(setWay(map,i,j-1)){
				return true;
			}else{
				map[i][j]=3;
				return false;
			}
		}else{
			return false;
		}
	}
}
