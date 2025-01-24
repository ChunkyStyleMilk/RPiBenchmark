
public class Main {

    public static void main(String[] args) {

        Timer.startTimer();

        for(int i = 0; i < 3; i++){

            if(i == 0){

                System.out.println(Operations.integerOps());

            }else if(i == 1){

                System.out.println(Operations.doubleOps());

            }else{

                System.out.println(Operations.stringOps());

            }
        }
    }
}