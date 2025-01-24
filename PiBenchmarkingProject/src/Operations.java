public class Operations {

    private static int intCounter = 0;
    private static int doubleCounter = 0;
    private static int stringCounter = 0;

    public static int integerOps(){
        Timer.resetTimer();
        while(!Timer.isDone()){

            int benchy = 5+5;
            intCounter++;

        }
        Timer.resetTimer();
        return intCounter;
    }

    public static int doubleOps(){

        while(!Timer.isDone()){

            double benchy = 235.023958 + 985.54902;
            doubleCounter++;

        }
        Timer.resetTimer();
        return doubleCounter;
    }

    public static int stringOps(){

        while(!Timer.isDone()){

            String first = "Hello";
            String second = "World!";
            String benchy = first.concat(second);
            stringCounter++;

        }
        Timer.resetTimer();
        return stringCounter;
    }

}
