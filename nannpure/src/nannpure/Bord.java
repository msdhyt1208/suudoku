package nannpure;

import java.util.ArrayList;

public class Bord {
	//���Ƃ̃{�[�h
	static int[][] bord = Main.createBord();
	//���l�����ւ��\�ȏꏊ
	final ArrayList<Integer> unLockList = unInputCell();
	//���l�̌��
	static boolean[][] chaValue = new boolean[81][10];
	
	//�����͂��邩�̊m�F(���ׂē��͍ς݂Ȃ� false)
	public boolean allZerochack() {
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				if(bord[he][wi] == 0)  return true;
			}
		}
		return false;
	}

	//���l�����ւ����ꏊ���L�^����
	public static ArrayList<Integer> unInputCell(){
		ArrayList<Integer> unLockList = new ArrayList<>();
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				if(bord[he][wi] == 0)  unLockList.add(he * 9 + wi);
			}
		}
		return unLockList;
	}
	
	//���̏��Ȃ����ɕ��ׂ�
//	public  ArrayList<Integer> sortList(){
//		allLook();
//		ArrayList<Integer> unLookList = unInputCell();		
//		ArrayList<Integer> poslist = pos(unLookList);
//		ArrayList<Integer> sortlist = sort(unLookList,poslist);
//		return sortlist;
//	}
	
	//
//	public static ArrayList<Integer> sort(ArrayList<Integer> unLookList,ArrayList<Integer> poslist){
//
//		ArrayList<Integer> sortlist = new ArrayList<>();
//		int tg = 0;
//		for(int i =0;i<10;i++) {
//			for(int cell : unLookList ) {
//				if(poslist.get(tg) == i) sortlist.add(cell);
//				tg++;
//			}
//			tg = 0;
//		}
//		return sortlist;
//	}
//	public static ArrayList<Integer> pos(ArrayList<Integer> unLookList){
//
//		ArrayList<Integer> poslist  = new ArrayList<>();
//
//		int pos = 0;
//		for(int cell : unLookList) {
//			for(int value = 1;value<10;value++) {
//				if(chaValue[cell][value]) pos++;
//			}
//			poslist.add(pos);
//			pos = 0;			
//		}
//		return poslist;
//	}	
	
	//���ׂẴ}�X�̏d���m�F
	public void allLook () {
//		allTrue();
		for(int i = 0; i < 81;i++) {
			int he = i / 9;
			int wi = i % 9;
			cellLook(he,wi,i);
		}
		
		
	}
	//��}�X���̃Z���̏d���m�F
	public static void cellLook (int he,int wi,int selectCell) {		
		//�u���b�N�ŏC�����Ă��Ȃ����̊m�F
		int stHe = he - he % 3;
		int stWi = wi - wi % 3;
		for(int i = 0;i < 3;i++) {
			for (int j = 0;j < 3 ;j++) {
				 if(bord[stHe + i][stWi +j] != 0 ) 
					 chaValue[selectCell][bord[stHe + i][stWi +j]] = false;
			}
		}
		//�c���ɃZ�����d�����ĂȂ����̊m�F
		for(int i = 0;i < 9;i++) {
			if(bord[he][i] != 0)
				 chaValue[selectCell][bord[he][i]] = false;
			if(bord[i][wi] != 0)
				 chaValue[selectCell][bord[i][wi]] = false;
		}	
	}
	//�S�ẴZ���̐��l�̌�������������
	public void allTrue () {
		for (int i=0; i < 81;i++) {
			for (int value=1;value < 10;value ++) {
				chaValue[i][value] = true;
			}
		}
	}
}

