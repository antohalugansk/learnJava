package TwoThreads;

public class Main {
    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();

        Thread thread1 = new Thread(new NumberPrinter("Вася", 1, sharedPrinter));
        Thread thread2 = new Thread(new NumberPrinter("Петруха", 2, sharedPrinter));

        thread1.start();
        thread2.start();
    }
}
