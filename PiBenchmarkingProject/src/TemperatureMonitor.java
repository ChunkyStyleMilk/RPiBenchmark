import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class TemperatureMonitor implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private double maxTemp = Double.MIN_VALUE;
    private final long sampleIntervalMs;

    public TemperatureMonitor(long sampleIntervalMs) {
        this.sampleIntervalMs = sampleIntervalMs;
    }

    public void start() {
        running.set(true);
        new Thread(this, "TempMonitor").start();
    }

    public void stop() {
        running.set(false);
    }

    public double getMaxTemp() {
        return maxTemp == Double.MIN_VALUE ? 0.0 : maxTemp;
    }

    @Override
    public void run() {
        while (running.get()) {
            try {
                // Raspberry Pi-specific command:
                ProcessBuilder pb = new ProcessBuilder("bash", "-c", "vcgencmd measure_temp");
                Process p = pb.start();

                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                    String line = br.readLine();

                    if (line != null && line.startsWith("temp=") && line.endsWith("'C")) {

                        String tempStr = line.substring(5, line.length() - 2);
                        double temp = Double.parseDouble(tempStr);
                        if (temp > maxTemp) {
                            maxTemp = temp;
                        }

                    }
                }
                p.waitFor();

            } catch (Exception e) {
                // ignore or log
            }

            try {
                Thread.sleep(sampleIntervalMs);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}