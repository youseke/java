package ex01_06;

public class Main {
	public static void main(String[] args) {
		new Thread(uncheck( () -> {System.out.println("Zzz"; Thread.sleep(1000);).start();	
}

	public static Runnable uncheck(RunnableEx runner) {
		new Thread(runner).start();
		return runner;

	}
}