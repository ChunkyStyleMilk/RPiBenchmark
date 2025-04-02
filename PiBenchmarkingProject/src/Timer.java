

public class Timer {

    private static long duration = 5000;
    private static long startTime = System.currentTimeMillis();
    private static int currentSecond = 1;

    public Timer(){

    }

    public void startTimer(){

        System.out.println("Starting Timer...");

        while(System.currentTimeMillis() - startTime < duration) {

            if((System.currentTimeMillis() - startTime) / 1000 == currentSecond) {

                System.out.println(currentSecond);
                currentSecond++;

            }
        }
    }

    public boolean isDone(){

        return System.currentTimeMillis() - startTime >= duration;

    }
    public void resetTimer(){

        startTime = System.currentTimeMillis();
        currentSecond = 1;

    }
}
