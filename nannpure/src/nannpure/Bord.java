package nannpure;

import java.util.ArrayList;

public class Bord {
	//数独のボード
	static int[][] bord = Main.createBord();
	//数値を入れ替え可能な場所
	final ArrayList<Integer> unLockList = unInputCell();
	//数値の候補
	static boolean[][] chaValue = new boolean[81][10];
	
	//未入力あるかの確認(すべて入力済みなら false)
	public boolean allZerochack() {
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				if(bord[he][wi] == 0)  return true;
			}
		}
		return false;
	}

	//数値を入れ替えれる場所を記録する
	public static ArrayList<Integer> unInputCell(){
		ArrayList<Integer> unLockList = new ArrayList<>();
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				if(bord[he][wi] == 0)  unLockList.add(he * 9 + wi);
			}
		}
		return unLockList;
	}
	
	//候補の少ない順に並べる
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
	
	//すべてのマスの重複確認
	public void allLook () {
//		allTrue();
		for(int i = 0; i < 81;i++) {
			int he = i / 9;
			int wi = i % 9;
			cellLook(he,wi,i);
		}
		
		
	}
	//一マス分のセルの重複確認
	public static void cellLook (int he,int wi,int selectCell) {		
		//ブロックで修復していないかの確認
		int stHe = he - he % 3;
		int stWi = wi - wi % 3;
		for(int i = 0;i < 3;i++) {
			for (int j = 0;j < 3 ;j++) {
				 if(bord[stHe + i][stWi +j] != 0 ) 
					 chaValue[selectCell][bord[stHe + i][stWi +j]] = false;
			}
		}
		//縦横にセルが重複してないかの確認
		for(int i = 0;i < 9;i++) {
			if(bord[he][i] != 0)
				 chaValue[selectCell][bord[he][i]] = false;
			if(bord[i][wi] != 0)
				 chaValue[selectCell][bord[i][wi]] = false;
		}	
	}
	//全てのセルの数値の候補を初期化する
	public void allTrue () {
		for (int i=0; i < 81;i++) {
			for (int value=1;value < 10;value ++) {
				chaValue[i][value] = true;
			}
		}
	}
}

