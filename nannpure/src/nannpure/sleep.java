package nannpure;

public class sleep {
	public void st () {
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException e){
		    e.printStackTrace();
		}
	}
}
