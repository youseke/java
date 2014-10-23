package ex01_06;

public class CheckedToUncheckedTest {

    public static void main(String[] args) {
        new Thread(
                uncheck(() -> {
                    System.out.println("Zzz");
                    Thread.sleep(1000);
                })).start();
    }

    public static Runnable uncheck(RunnableEx r) {
        return () -> {
            try {
                r.run();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        };
    }
}
