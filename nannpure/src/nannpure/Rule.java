package nannpure;

public class Rule extends Bord{
	public boolean allRule() {
		if(hewiRule()&&blockRule())	return true;
		return false;
	}
	public boolean hewiCheak(int he,int wi) {
		for (int i = he + 1;i < 9;i++) {
			if(bord[he][wi] == bord[i][wi])	return false;
		}
		for (int i = wi + 1;i < 9;i++) {
			if(bord[he][wi] == bord[he][i])	return false;
		}
		return true;
	}
	public boolean hewiRule() {
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				if(bord[he][wi] == 0)	continue; 
				if(!hewiCheak(he, wi)) return false;
			}
		}
		return true;
	}
	public boolean blockRule() {
		for(int he = 0;he < 9;he+=3) {
			for(int wi =0;wi < 9;wi+=3) {
				int[] brock = blockCut(he, wi);
				if(!blockCheak(brock)) return false;
			}
		}
		return true;
	}
	public int[] blockCut(int he,int wi) {
		int[] brock = new int[9];
		int m = 0;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				brock[m++] = bord [he+i][wi+j];
			}
		}
		return brock;
	}
	public boolean blockCheak(int[] brock) {

		for(int i = 0;i < 9;i++) {
			for(int j = i+1;j < 9;j++) {
				if(brock[i] ==0)	continue;
				if(brock[i] == brock[j]) return false;
			}
		}
		return true;
	}
}

