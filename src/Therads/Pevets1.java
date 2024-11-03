package Therads;

public class Pevets1 extends Thread {
    private boolean isrunning = true;
    public void run() {
        int count = 0;
        while (isrunning) {
            count++;
            if (count > 3){
                isrunning = false;
            }
            // Song
            for (int i = 0; i < 3; i++) {
                System.out.println("LALALA----------");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // будим 2 певца
                synchronized (Monitors.MICROFON) {
                    Monitors.MICROFON.notify();

                }
                // входим в режим ожидания
                synchronized (Monitors.MICROFON){
                    try {
                        Monitors.MICROFON.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }
}
