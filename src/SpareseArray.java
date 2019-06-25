import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SpareseArray {
	public static void main(String[] args) {
		int chessArr1[][]=new int[11][11];//����ԭ��������
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;                //��ԭ������и�ֵ
		chessArr1[3][3]=2;
		System.out.println("ԭ���������");
		//����ԭ����
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				System.out.print(chessArr1[i][j]+" ");
			}
			System.out.println();
		}	
		//��ȡԭ���������ݸ���
		int sum=0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j]!=0){
					 sum++;
				}
			}
		}
		int CA2[][]= new int[sum+1][3];//����ϡ����������
		//����ԭ�����ϡ�����鸳ֵ
		CA2[0][0]=chessArr1.length;
		CA2[0][1]=chessArr1[0].length;
		CA2[0][2]=sum;
		int cout=0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j <  chessArr1[i].length; j++) {
				if(chessArr1[i][j]!=0){
					 cout++;
					 CA2[cout][0]=i;
					 CA2[cout][1]=j;
					 CA2[cout][2]=chessArr1[i][j];
				}
			}
		}
		
		//ϡ���������
		File f =new File("d:/map.txt");
//		try (FileWriter fw =new FileWriter(f);){
//			fw.write("��g");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 try (
	                FileOutputStream fos  = new FileOutputStream(f);
	                DataOutputStream dos =new DataOutputStream(fos);
	        ){
	            //dos.writeBoolean(true);
			 for (int i = 0; i < CA2.length; i++) {
				 for (int j = 0; j < CA2[i].length; j++) {
					 dos.writeInt(CA2[i][j]);
				}	 
			}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 try (
	                FileInputStream fis  = new FileInputStream(f);
	                DataInputStream dis =new DataInputStream(fis);
	        ){
			 
			 for (int i = 0; i < CA2.length; i++) {
				 for (int j = 0; j < CA2[i].length; j++) {
					 CA2[i][j] = dis.readInt();
				}
				 
			}

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	         
		 
		 System.out.println("ϡ�����������");
		for (int i = 0; i < CA2.length; i++) {
			for (int j = 0; j <  CA2[i].length; j++){
					System.out.print(CA2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("ϡ������תԭ����");
		int CA3[][]=new int[CA2[0][0]][CA2[0][1]];//����ϡ������תԭ��������
		//����ϡ�������ԭ���鸳ֵ
		for (int i = 1; i < CA2.length; i++) {
			CA3[CA2[i][0]][CA2[i][1]]=CA2[i][2];
		}
		//����ԭ����
		for (int i = 0; i < CA3.length; i++) {
			for (int j = 0; j < CA3.length; j++) {
				System.out.print(CA3[i][j]+" ");
			}
			System.out.println();
		}
	}
}
