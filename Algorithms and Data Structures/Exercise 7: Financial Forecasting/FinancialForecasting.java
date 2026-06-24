// ============================================================
//  Exercise 7: Financial Forecasting
//  Algorithm  : Recursion + Memoization
// ============================================================

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // ── Approach 1: Simple Recursion — O(n) ──
    // Calculates future value after 'years' years
    // Formula: FV = PV * (1 + growthRate)^years
    public static double futureValueRecursive(double presentValue,
                                               double growthRate,
                                               int years) {
        // Base case
        if (years == 0) return presentValue;

        // Recursive case
        return futureValueRecursive(presentValue * (1 + growthRate),
                                    growthRate,
                                    years - 1);
    }

    // ── Approach 2: Memoized Recursion — O(n) time, O(n) space ──
    // Avoids recomputation for same year values
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double futureValueMemo(double presentValue,
                                          double growthRate,
                                          int years) {
        // Base case
        if (years == 0) return presentValue;

        // Check cache
        if (memo.containsKey(years)) return memo.get(years);

        // Compute and store
        double result = futureValueMemo(presentValue, growthRate, years - 1)
                        * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    // ── Approach 3: Iterative (for comparison) — O(n) ──
    public static double futureValueIterative(double presentValue,
                                               double growthRate,
                                               int years) {
        double value = presentValue;
        for (int i = 0; i < years; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Tool ===\n");

        double presentValue = 10000.0;   // ₹10,000 initial investment
        double growthRate   = 0.08;      // 8% annual growth
        int    years        = 5;

        System.out.printf("Present Value : ₹%.2f%n", presentValue);
        System.out.printf("Growth Rate   : %.0f%%%n", growthRate * 100);
        System.out.printf("Years         : %d%n%n", years);

        // ── Simple Recursion ──
        System.out.println("--- Simple Recursion ---");
        double rv = futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years : ₹%.2f%n", years, rv);

        // ── Memoized Recursion ──
        System.out.println("\n--- Memoized Recursion ---");
        memo.clear();
        double mv = futureValueMemo(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years : ₹%.2f%n", years, mv);

        // ── Iterative ──
        System.out.println("\n--- Iterative (for comparison) ---");
        double iv = futureValueIterative(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years : ₹%.2f%n", years, iv);

        // ── Year-by-Year Forecast ──
        System.out.println("\n--- Year-by-Year Forecast (Recursive) ---");
        System.out.printf("%-6s %-20s%n", "Year", "Projected Value");
        System.out.println("-------------------------------");
        for (int y = 0; y <= years; y++) {
            double val = futureValueRecursive(presentValue, growthRate, y);
            System.out.printf("%-6d ₹%-20.2f%n", y, val);
        }

        // ── Analysis ──
        System.out.println("\n--- Time Complexity Analysis ---");
        System.out.println("Simple Recursion  : O(n) — one call per year");
        System.out.println("Memoized Recursion: O(n) time, O(n) space — avoids recomputation");
        System.out.println("Iterative         : O(n) time, O(1) space — most efficient");
        System.out.println("\nConclusion: Memoization helps when same subproblems repeat.");
        System.out.println("            For simple forecasting, iterative is most optimal.");
    }
}
