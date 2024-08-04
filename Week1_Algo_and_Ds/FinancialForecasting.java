public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base case: no more periods
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate for one less period
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    // Iterative method to calculate future value
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of years

        // Calculate future value using recursive method
        double futureValueRecursive = calculateFutureValueRecursive(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods (Recursive): $" + String.format("%.2f", futureValueRecursive));

        // Calculate future value using iterative method
        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods (Iterative): $" + String.format("%.2f", futureValueIterative));
    }
}
