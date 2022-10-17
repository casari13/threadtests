package cat.uvic.teknos.m09.threadtests;

public class AppWithThreads {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        var importantStuff1 = new ImportantStuff1();
        var importantStuff2 = new ImportantStuff2();
        var importantStuff3 = new ImportantStuff3();

        var thread1 = new Thread(importantStuff1::doStuff);
        var thread2 = new Thread(importantStuff2::doStuff);
        var thread3 = new Thread(importantStuff3::doStuff);
        var thread4 = new Thread(AppWithThreads::doStuff4);
        var thread5 = new Thread(() -> {
            try {
                Thread.sleep(3*1000);
                System.out.println("Done important stuff 4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("The end");
    }


    private static void doStuff4()  {
        try {
            Thread.sleep(15*1000);
            System.out.println("Done important stuff 4");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
