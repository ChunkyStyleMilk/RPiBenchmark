public class MultiThreadOperations implements Runnable {

    private final int threadNumber;
    private long intCount    = 0L;
    private long doubleCount = 0L;
    private long stringCount = 0L;

    public MultiThreadOperations(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        intCount    = Operations.integerOps();
        doubleCount = Operations.doubleOps();
        stringCount = Operations.stringOps();

    }

    public int getThreadNumber() {
        return threadNumber;
    }
    public long getIntCount() {
        return intCount;
    }
    public long getDoubleCount() {
        return doubleCount;
    }
    public long getStringCount() {
        return stringCount;
    }
}