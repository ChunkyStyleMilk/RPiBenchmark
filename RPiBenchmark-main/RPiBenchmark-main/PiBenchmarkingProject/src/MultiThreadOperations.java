public class MultiThreadOperations implements Runnable {

    private int threadNumber;
    public MultiThreadOperations(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    private static int intCounter = 0;
    private static int doubleCounter = 0;
    private static int stringCounter = 0;

    @Override
    public void run() {

        Timer timer = new Timer();

        for (int i = 0; i < 3; i++) {

            if(i == 0){

                intCounter = Operations.integerOps();

            }else if(i == 1){

                doubleCounter = Operations.doubleOps();

            }else{

                stringCounter = Operations.stringOps();

            }
        }
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public int getIntCounter() {
        return intCounter;
    }

    public int getDoubleCounter() {
        return doubleCounter;
    }

    public int getStringCounter() {
        return stringCounter;
    }
}