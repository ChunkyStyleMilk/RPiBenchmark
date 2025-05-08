public class Operations {

    public static long integerOps() {

        long counter = 0L;
        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            int benchy = 5+5;
            counter++;

        }
        return counter;
    }

    public static long doubleOps(){

        long counter = 0L;
        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            double benchy = 5.023958 + 5.54902;
            counter++;

        }

        return counter;
    }

    public static long stringOps(){

        long counter = 0L;
        long endTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < endTime) {

            String first = "Hello";
            String second = "World!";
            String benchy = first.concat(second);
            counter++;

        }
        return counter;
    }

}
