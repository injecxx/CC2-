package finallab2;

public class Fianllab2 {

    public static void main(String[] args) {

        int[][] temperatures = {
            {18, 21, 20, 19, 23, 24, 25}, // Temperature in City 1
            {30, 32, 31, 28, 29, 30, 31}, // Temperature in City 2
            {25, 27, 26, 22, 21, 23, 24}, // Temperature in City 3
        };

        // Calculate the average temperature for each city
        for (int city = 0; city < temperatures.length; city++) {
            int total = 0;
            int highest = temperatures[city][0]; // Initialize highest with the first day's temperature

            // Loop through each day's temperature for the current city
            for (int day = 0; day < temperatures[city].length; day++) {
                total += temperatures[city][day]; // Add the current day's temperature to total
                if (temperatures[city][day] > highest) {
                    highest = temperatures[city][day]; // Update highest temperature
                }
            }

            // Calculate the average temperature
            double average = (double) total / temperatures[city].length;

            // Print outputs formatted to 2 decimal places
            System.out.println("City " + (city + 1) + ":");
            System.out.printf("Average Temperature: %.2f°C\n", average);
            System.out.printf("Highest Temperature: %.2f°C\n", (double) highest);
            System.out.println();
        }

    }
}