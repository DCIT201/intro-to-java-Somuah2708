import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        System.out.println("Temperature Converter");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");

        // Get the user's choice
        int choice = getValidChoice(scanner);

        // Based on the user's choice, prompt for the temperature input and perform the conversion
        if (choice == 1) {
            // Convert Celsius to Fahrenheit
            System.out.print("Enter temperature in Celsius: ");
            double celsius = getValidTemperature(scanner);
            double fahrenheit = convertCelsiusToFahrenheit(celsius);
            System.out.printf("%.2f Celsius is %.2f Fahrenheit.%n", celsius, fahrenheit);
        } else {
            // Convert Fahrenheit to Celsius
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = getValidTemperature(scanner);
            double celsius = convertFahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f Fahrenheit is %.2f Celsius.%n", fahrenheit, celsius);
        }

        // Close the scanner object to prevent resource leak
        scanner.close();
    }

    // Method to get a valid choice (1 or 2) from the user
    private static int getValidChoice(Scanner scanner) {
        int choice = -1;
        while (choice != 1 && choice != 2) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.next(); // consume the invalid input
            }
        }
        return choice;
    }

    // Method to get a valid temperature input from the user
    private static double getValidTemperature(Scanner scanner) {
        double temperature = Double.NaN;
        while (Double.isNaN(temperature)) {
            if (scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                if (temperature < -273.15) {
                    System.out.println("Temperature cannot be lower than absolute zero (-273.15). Please try again.");
                    temperature = Double.NaN; // Reset temperature to force a valid input
                }
            } else {
                System.out.println("Invalid input. Please enter a valid temperature.");
                scanner.next(); // consume the invalid input
            }
        }
        return temperature;
    }

    // Method to convert Celsius to Fahrenheit
    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
