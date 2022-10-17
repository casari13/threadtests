package cat.uvic.teknos.m09.threadtests;

public class ImportantStuff2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1*1000);
            System.out.println("Done important stuff 1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void doStuff() {
        try {
            Thread.sleep(1000);
            System.out.println("Done important stuff 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
