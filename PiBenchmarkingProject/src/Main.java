
public class Main {

    public static void main(String[] args) throws InterruptedException {

        int sInteger = 0;
        int sDouble = 0;
        int sString = 0;

        int mInteger = 0;
        int mDouble = 0;
        int mString = 0;

        System.out.println("Initializing Single-Thread Processing...");
        for(int i = 0; i < 3; i++){

            if(i == 0){

                sInteger = Operations.integerOps();

            }else if(i == 1){

                sDouble = Operations.doubleOps();

            }else{

                sString = Operations.stringOps();

            }
        }

        System.out.println("Finalizing Single-Thread Processing...");

        System.out.println("Initializing Multi-Thread Processing...");

        MultiThreadOperations threadOne = new MultiThreadOperations(1);
        MultiThreadOperations threadTwo = new MultiThreadOperations(2);
        MultiThreadOperations threadThree = new MultiThreadOperations(3);

        Thread thread1 = new Thread(threadOne);
        Thread thread2 = new Thread(threadTwo);
        Thread thread3 = new Thread(threadThree);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        mInteger = threadOne.getIntCounter() + threadTwo.getIntCounter() + threadThree.getIntCounter();
        mDouble = threadOne.getDoubleCounter() + threadTwo.getDoubleCounter() + threadThree.getDoubleCounter();
        mString = threadOne.getStringCounter() + threadTwo.getStringCounter() + threadThree.getStringCounter();

        printValues(sInteger, sDouble, sString, "Single Thread");
        printValues(mInteger, mDouble, mString, "Multi Thread");

    }

    public static void printValues(int iOne, int iTwo, int iThree, String type){

        System.out.println("\n" + type + ":\nNumber of integer calculations: " + iOne + "\nNumber of double calculations: " + iTwo + "\nNumber of string concatenations: " + iThree);

    }

}

