
public class Contador04 {
	
	private long cont1 = 0;
	private long cont2 = 0;
	
	private final Object lock1 = new Object(); 
	private final Object lock2 = new Object(); 
	
	public void incrementar1() {
		synchronized(lock1) {
			cont1++;
		}
	}
	
	public void incrementar2() {
		synchronized(lock2) {
			cont2++;
		}
	}
	
	public long getCont1() {
		synchronized(lock1) {
			return cont1;
		}
	}
	
	public long getCont2() {
		synchronized(lock2) {
			return cont2;
		}
	}
}
