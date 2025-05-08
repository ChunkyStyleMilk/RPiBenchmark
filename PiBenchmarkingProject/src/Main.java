
public class Main {

    public static void main(String[] args) throws InterruptedException {

        TemperatureMonitor monitor = new TemperatureMonitor(500);

        System.out.println("Initializing Single-Thread Processing...");

        monitor.start();

        long sInteger = Operations.integerOps();
        long sDouble = Operations.doubleOps();
        long sString = Operations.stringOps();

        long mInteger = 0;
        long mDouble = 0;
        long mString = 0;

        monitor.stop();
        double maxTemp = monitor.getMaxTemp();

        BenchmarkResult sResult = new BenchmarkResult(sInteger, sDouble, sString, maxTemp);

        System.out.println("Initializing Multi-Thread Processing...");

        monitor = new TemperatureMonitor(500);
        monitor.start();

        MultiThreadOperations w1 = new MultiThreadOperations(1);
        MultiThreadOperations w2 = new MultiThreadOperations(2);
        MultiThreadOperations w3 = new MultiThreadOperations(3);

        Thread t1 = new Thread(w1, "Worker-1");
        Thread t2 = new Thread(w2, "Worker-2");
        Thread t3 = new Thread(w3, "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        monitor.stop();
        maxTemp = monitor.getMaxTemp();

        long totalInt    = w1.getIntCount()    + w2.getIntCount()    + w3.getIntCount();
        long totalDouble = w1.getDoubleCount() + w2.getDoubleCount() + w3.getDoubleCount();
        long totalString = w1.getStringCount() + w2.getStringCount() + w3.getStringCount();

        BenchmarkResult mResult = new BenchmarkResult(totalInt, totalDouble, totalString, maxTemp);

        System.out.println("Single-Thread Results:");
        System.out.println(sResult);

        System.out.println("Multi-Thread Results:");
        System.out.println(mResult);

    }

}

