public class Operations {

    private static int intCounter = 0;
    private static int doubleCounter = 0;
    private static int stringCounter = 0;

    public static int integerOps() {

        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            int benchy = 5+5;
            intCounter++;

        }
        return intCounter;
    }

    public static int doubleOps(){

        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            double benchy = 5.023958 + 5.54902;
            doubleCounter++;

        }

        return doubleCounter;
    }

    public static int stringOps(){

        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            String first = "Hello";
            String second = "World!";
            String benchy = first.concat(second);
            stringCounter++;

        }
        return stringCounter;
    }

}
