package TwoThreads;

class NumberPrinter implements Runnable {
    private final String name;
    private final int threadId;
    private final SharedPrinter sharedPrinter;

    public NumberPrinter(String name, int threadId, SharedPrinter sharedPrinter) {
        this.name = name;
        this.threadId = threadId;
        this.sharedPrinter = sharedPrinter;
    }

    @Override
    public void run() {
        sharedPrinter.print(name, threadId);
    }
}
