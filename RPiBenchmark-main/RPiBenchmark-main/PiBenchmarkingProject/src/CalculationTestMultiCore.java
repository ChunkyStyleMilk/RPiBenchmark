import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CalculationTestMultiCore {
    public static void main(String[] args) throws Exception {

        System.out.println("Running single-thread test...");
        long[] singleCounts = runSingleThreadTest();
        System.out.println("Single-thread counts:");
        System.out.println("  Integer calculations: " + singleCounts[0]);
        System.out.println("  Double calculations: " + singleCounts[1]);
        System.out.println("  String concatenations: " + singleCounts[2]);

        // Define the types for which we want to run the calculation.
        String[] types = {"int", "double", "string"};
        int numProcesses = 3; // Number of processes (cores) to use per calculation type.

        // Retrieve the Java executable and classpath.
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + "/bin/java";
        String classpath = System.getProperty("java.class.path");

        // For each calculation type, spawn numProcesses processes concurrently.
        for (String type : types) {
            System.out.println("Running multi-core processing for " + type + " calculations...");
            List<Process> processes = new ArrayList<>();

            // Launch multiple processes for the current type.
            for (int i = 0; i < numProcesses; i++) {
                ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, "CalculationWorker", type);
                processes.add(pb.start());
            }

            // Collect and sum the counts from all processes.
            long totalCount = 0;
            for (Process p : processes) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = reader.readLine();
                p.waitFor();
                try {
                    long count = Long.parseLong(line.trim());
                    totalCount += count;
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing output: " + line);
                }
            }

            System.out.println("Total " + type + " calculations: " + totalCount);
            System.out.println("--------------------------------------------");
        }
    }

    public static long[] runSingleThreadTest() {
        long intCount = 0;
        long doubleCount = 0;
        long stringCount = 0;
        long duration = 5000;
        long endTime = System.currentTimeMillis() + duration;

        // In this example, all three calculations are executed sequentially in one loop.
        while (System.currentTimeMillis() < endTime) {
            int a = 1, b = 2;
            int c = a + b;
            intCount++;

            double d = 1.5, e = 2.5;
            double f = d * e;
            doubleCount++;

            String s = "Hello" + "World";
            stringCount++;
        }
        return new long[]{intCount, doubleCount, stringCount};
    }
}