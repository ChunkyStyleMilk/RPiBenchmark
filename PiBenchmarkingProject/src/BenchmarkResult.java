public class BenchmarkResult {
    private final long integerCount;
    private final long doubleCount;
    private final long stringCount;
    private final double maxCpuTemp;

    public BenchmarkResult(long integerCount, long doubleCount, long stringCount, double maxCpuTemp) {
        this.integerCount = integerCount;
        this.doubleCount = doubleCount;
        this.stringCount = stringCount;
        this.maxCpuTemp = maxCpuTemp;
    }

    public long getIntegerCount()       { return integerCount; }
    public long getDoubleCount()        { return doubleCount; }
    public long getStringCount()        { return stringCount; }
    public double getMaxCpuTemp()       { return maxCpuTemp; }

    @Override
    public String toString() {
        return String.format(
                "Integers: %,d; Doubles: %,d; Strings: %,d; Max CPU Temp: %.2f°C",
                integerCount, doubleCount, stringCount, maxCpuTemp
        );
    }
}