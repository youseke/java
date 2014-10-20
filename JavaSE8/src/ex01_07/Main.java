package ex01_07;

public class Main {

    public static void main(String[] args) {
        new Thread(andThen(() -> {
            System.out.println("First runnable instance");
        }, () -> {
            System.out.println("Second runnable instance");
        })).start();
    }

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
