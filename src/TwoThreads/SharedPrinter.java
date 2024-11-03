package TwoThreads;

class SharedPrinter {
    private int counter = 1;
    private boolean isThread1Turn = true; // флаг, который определяет, чей ход сейчас

    public synchronized void print(String name, int threadId) {
        try {
            while (counter <= 10) {
                if ((threadId == 1 && !isThread1Turn) || (threadId == 2 && isThread1Turn)) {
                    wait(); // ждем, пока не будет очередь текущего потока
                }

                if (counter > 10) break; // выход, если счетчик превысил 10

                System.out.println(counter + " - я Поток " + name);
                counter++;
                isThread1Turn = !isThread1Turn; // меняем очередь

                notify(); // уведомляем другой поток

                Thread.sleep(1000); // задержка на 1 секунду
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток прерван: " + name);
        }
    }
}
