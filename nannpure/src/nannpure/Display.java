package nannpure;

public class Display extends Bord{
	public void display() {
		
		for(int he = 0;he < 9;he++) {
			for(int wi =0;wi < 9;wi++) {
				System.out.print(bord[he][wi]);
				if(wi % 3 == 2 && wi!= 8) System.out.print("|");
			}
			System.out.println();
			if(he % 3 == 2 && he!= 8) System.out.println("---|---|---");
		}
		System.out.println();
		new sleep().st();
	}

}
