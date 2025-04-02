public class CalculationWorker {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java CalculationWorker <calculation_type>");
            System.exit(1);
        }
        String type = args[0].toLowerCase();
        long duration = 5000; // Run for 5 seconds
        long startTime = System.currentTimeMillis();
        long count = 0;

        switch (type) {
            case "int":
                while (System.currentTimeMillis() - startTime < duration) {
                    int a = 1, b = 2;
                    int c = a + b;
                    count++;
                }
                break;
            case "double":
                while (System.currentTimeMillis() - startTime < duration) {
                    double d = 1.5, e = 2.5;
                    double f = d * e;
                    count++;
                }
                break;
            case "string":
                while (System.currentTimeMillis() - startTime < duration) {
                    String s = "Hello" + "World";
                    count++;
                }
                break;
            default:
                System.err.println("Unsupported calculation type: " + type);
                System.exit(1);
        }
        // Output the count so that the master process can capture it.
        System.out.println(count);
    }
}