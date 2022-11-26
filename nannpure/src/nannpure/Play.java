package nannpure;

public class Play extends Rule{
	int target = 0;

	
	public void input () {
		int he = unLockList.get(target) / 9;
		int wi = unLockList.get(target) % 9;
		int value = 1;
		cellLook(he, wi,unLockList.get(target));	//93165‰ñ	//27727
		while (true) {
			if(chaValue[unLockList.get(target)][value]) break;
			if(value == 9) {
				backTarget(he,wi);
				return;
			}
			value++;
		}
		chaValue[unLockList.get(target)][value] = false;
		bord[he][wi] = value; 
		if(allRule())target++;
	}
	
	
	
	public void backTarget(int he,int wi) {
		for(int i = 1;i < 10;i++) {
			chaValue[unLockList.get(target)][i] = true;
		}
		bord[he][wi] = 0;
		target--;	
	}
	
	

	public void allLook () {

		for(int i=0;i<81;i++) {
			int he = i / 9;
			int wi = i % 9;
			cellLook(he,wi,i);
		}
		
		
	}

	public static void cellLook (int he,int wi,int selectCell) {		
		int stHe = he - he % 3;
		int stWi = wi - wi % 3;
		for(int i = 0;i < 3;i++) {
			for (int j = 0;j < 3 ;j++) {
				 if(bord[stHe + i][stWi +j] != 0 ) 
					 chaValue[selectCell][bord[stHe + i][stWi +j]] = false;
			}
		}
		for(int i = 0;i < 9;i++) {
			if(bord[he][i] != 0)
				 chaValue[selectCell][bord[he][i]] = false;
			if(bord[i][wi] != 0)
				 chaValue[selectCell][bord[i][wi]] = false;
		}	
	}

}
