package cat.uvic.teknos.m09.threadtests;

public class AppThreadsThatShareVariables {
    private static int counter;
    private static Object lock = new Object();

    public AppThreadsThatShareVariables(int instanceCounter) {

    }

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(AppThreadsThatShareVariables::increment);
        var t2 = new Thread(AppThreadsThatShareVariables::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value: " + counter);
    }


    private static void increment() {
        System.out.println(Thread.currentThread().getName() + " starts working");

        for (var i = 0; i < 10000; i++) {
            synchronized(lock) {
                counter++;
                if (counter % 100 == 0) {
                    System.out.println(Thread.currentThread().getName() + " reaches " + counter);
                }
            }

        }

        System.out.println("Work done by " + Thread.currentThread().getName());
    }
}
