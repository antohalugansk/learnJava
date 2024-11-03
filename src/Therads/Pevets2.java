package Therads;

public class Pevets2 extends Thread{
    public void run() {
        while (true) {
            // входим в режим ожидания
            synchronized (Monitors.MICROFON){
                try {
                    Monitors.MICROFON.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // Song
            for (int i = 0; i < 2; i++) {
                System.out.println("----------АФАФ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // будим 1 певца
                synchronized (Monitors.MICROFON) {
                    Monitors.MICROFON.notify();

                }
            }
        }
    }
}

