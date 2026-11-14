package viva_1;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int choice;
        int count = 0;
        double hub = 150.00;
        double totalEnergy = 0;
        double totalCost = 0;
        double remaining = hub;
        int currentBattery, targetBattery;
        boolean oneUsed = false;
        boolean twoUsed = false;
        boolean threeUsed = false;
        boolean fourUsed = false;
        boolean depleted = false;
        boolean running = true;

        while (remaining > 0 && running) {
            System.out.println("");
            System.out.println("==== Solar EV Charging Hub ====");
            System.out.printf("Hub Battery: %.2f kWh %n" , remaining);
            System.out.println("1. Compact Hatch (40 kWh, max 50 kW)" + (oneUsed ? " [DONE]" : ""));
            System.out.println("2. Family SUV (75 kWh, max 120 kW)" + (twoUsed ? " [DONE]" : ""));
            System.out.println("3. Delivery Van (90 kWh, max 80 kW)" + (threeUsed ? " [DONE]" : ""));
            System.out.println("4. E-Scooter (4 kWh, max 3 kW)" + (fourUsed ? " [DONE]" : ""));
            System.out.println("0. Close hub");
            System.out.print("Select a vehicle (0-4): ");
 
            while (!sc.hasNextInt()) {
                System.out.println("Error: Please enter an integer from 0 to 4");
                sc.next();
            }
            choice = sc.nextInt();
 
            switch (choice) {
                case 1:
                    if (oneUsed) {
                        System.out.println("Error: This vehicle has already been charged.");
                    } else {
                        do {
                            System.out.print("Enter current battery level (0-99): ");
                            currentBattery = sc.nextInt();
                            if (currentBattery < 0 || currentBattery > 99){
                                System.out.println("Invalid battery level");
                            }    
                        } while (currentBattery < 0 || currentBattery > 99);
 
                        do {
                            System.out.print("Enter target battery level (" + (currentBattery + 1) + "-100): ");
                            targetBattery = sc.nextInt();
                            if (targetBattery > 100 || targetBattery <= currentBattery) System.out.println("Error: Target must be higher than the current level and at most 100.");
                        } while (targetBattery > 100 || targetBattery <= currentBattery);
 
                        double capacity = 40.0;
                        double power = 50.0;
                        double needed = capacity * (targetBattery - currentBattery) / 100.0;
                        double drawn = needed / 0.9;
                        if (drawn > remaining) {
                            drawn = remaining;
                            needed = drawn * 0.9;
                            depleted = true;
                        } else {
                            depleted = false;
                        }
                        double delivered = needed;
                        double actualDrawn = drawn;
                        double time = delivered / power * 60;
                        double cost = delivered > 30 ? (1.2 * delivered) * 0.95 : 1.2 * delivered;
                        remaining = hub - actualDrawn;
                        hub = remaining;
                        count++;
                        totalCost += cost;
                        totalEnergy += delivered;
                        oneUsed = true;
                        System.out.println("");
                        System.out.println("--- Charging Summary ---");
                        System.out.println("Vehicle: Compact Hatch");
                        System.out.printf("Battery: %d%% -> %d%%%n", currentBattery, targetBattery);
                        System.out.printf("Charging Power: %d kW%n", (int)power);
                        System.out.printf("Energy Delivered: %.2f kWh (drawn from hub: %.2f kWh)%n", delivered, actualDrawn);
                        System.out.printf("Charging Time: %.2f minutes %n", time);
                        System.out.printf("Cost: RM %.2f%n", cost);
                        System.out.printf(depleted ? "Hub Battery Depleted! Vehicle only reached %.2f%%%n": "Remaining Hub Battery: %.2f kWh%n", depleted ? (currentBattery + (delivered / capacity) * 100) : remaining);
                        System.out.println("--------------------------");
                    }
                    break;
 
                case 2:
                    if (twoUsed) {
                        System.out.println("Error: This vehicle has already been charged.");
                    } else {
                        do {
                            System.out.print("Enter current battery level (0-99): ");
                            currentBattery = sc.nextInt();
                            if (currentBattery < 0 || currentBattery > 99) System.out.println("Invalid battery level");
                        } while (currentBattery < 0 || currentBattery > 99);
 
                        do {
                            System.out.print("Enter target battery level (" + (currentBattery + 1) + "-100): ");
                            targetBattery = sc.nextInt();
                            if (targetBattery > 100 || targetBattery <= currentBattery) System.out.println("Error: Target must be higher than the current level and at most 100.");
                        } while (targetBattery > 100 || targetBattery <= currentBattery);
 
                        double capacity = 75.0;
                        double power = 60.0;
                        double needed = capacity * (targetBattery - currentBattery) / 100.0;
                        double drawn = needed / 0.9;
                        if (drawn > remaining) {
                            drawn = remaining;
                            needed = drawn * 0.9;
                            depleted = true;
                        } else {
                            depleted = false;
                        }
                        double delivered = needed;
                        double actualDrawn = drawn;
                        double time = delivered / power * 60;
                        double cost = delivered > 30 ? (1.2 * delivered) * 0.95 : 1.2 * delivered;
                        remaining = hub - actualDrawn;
                        hub = remaining;
                        count++;
                        totalCost += cost;
                        totalEnergy += delivered;
                        twoUsed = true;
                        System.out.println("");
                        System.out.println("--- Charging Summary ---");
                        System.out.println("Vehicle: Family SUV");
                        System.out.printf("Battery: %d%% -> %d%%%n", currentBattery, targetBattery);
                        System.out.printf("Charging Power: %d kW%n", (int)power);
                        System.out.printf("Energy Delivered: %.2f kWh (drawn from hub: %.2f kWh)%n", delivered, actualDrawn);
                        System.out.printf("Charging Time: %.2f minutes %n", time);
                        System.out.printf("Cost: RM %.2f%n", cost);
                        System.out.printf(depleted ? "Hub Battery Depleted! Vehicle only reached %.2f%%%n": "Remaining Hub Battery: %.2f kWh%n", depleted ? (currentBattery + (delivered / capacity) * 100) : remaining);
                        System.out.println("--------------------------");
                    }
                    break;
 
                case 3:
                    if (threeUsed) {
                        System.out.println("Error: This vehicle has already been charged.");
                    } else {
                        do {
                            System.out.print("Enter current battery level (0-99): ");
                            currentBattery = sc.nextInt();
                            if (currentBattery < 0 || currentBattery > 99) System.out.println("Invalid battery level");
                        } while (currentBattery < 0 || currentBattery > 99);
 
                        do {
                            System.out.print("Enter target battery level (" + (currentBattery + 1) + "-100): ");
                            targetBattery = sc.nextInt();
                            if (targetBattery > 100 || targetBattery <= currentBattery) System.out.println("Error: Target must be higher than the current level and at most 100.");
                        } while (targetBattery > 100 || targetBattery <= currentBattery);
 
                        double capacity = 90.0;
                        double power = 60.0;
                        double needed = capacity * (targetBattery - currentBattery) / 100.0;
                        double drawn = needed / 0.9;
                        if (drawn > remaining) {
                            drawn = remaining;
                            needed = drawn * 0.9;
                            depleted = true;
                        } else {
                            depleted = false;
                        }
                        double delivered = needed;
                        double actualDrawn = drawn;
                        double time = delivered / power * 60;
                        double cost = delivered > 30 ? (1.2 * delivered) * 0.95 : 1.2 * delivered;
                        remaining = hub - actualDrawn;
                        hub = remaining;
                        count++;
                        totalCost += cost;
                        totalEnergy += delivered;
                        threeUsed = true;
                        System.out.println("");
                        System.out.println("--- Charging Summary ---");
                        System.out.println("Vehicle: Delivery Van");
                        System.out.printf("Battery: %d%% -> %d%%%n", currentBattery, targetBattery);
                        System.out.printf("Charging Power: %d kW%n", (int)power);
                        System.out.printf("Energy Delivered: %.2f kWh (drawn from hub: %.2f kWh)%n", delivered, actualDrawn);
                        System.out.printf("Charging Time: %.2f minutes %n", time);
                        System.out.printf("Cost: RM %.2f%n", cost);
                        System.out.printf(depleted ? "Hub Battery Depleted! Vehicle only reached %.2f%%%n": "Remaining Hub Battery: %.2f kWh%n", depleted ? (currentBattery + (delivered / capacity) * 100) : remaining);
                        System.out.println("--------------------------");
                    }
                    break;
 
                case 4:
                    if (fourUsed) {
                        System.out.println("Error: This vehicle has already been charged.");
                    } else {
                        do {
                            System.out.print("Enter current battery level (0-99): ");
                            currentBattery = sc.nextInt();
                            if (currentBattery < 0 || currentBattery > 99) System.out.println("Invalid battery level");
                        } while (currentBattery < 0 || currentBattery > 99);
 
                        do {
                            System.out.print("Enter target battery level (" + (currentBattery + 1) + "-100): ");
                            targetBattery = sc.nextInt();
                            if (targetBattery > 100 || targetBattery <= currentBattery) System.out.println("Error: Target must be higher than the current level and at most 100.");
                        } while (targetBattery > 100 || targetBattery <= currentBattery);
 
                        double capacity = 4.0;
                        double power = 3.0;
                        double needed = capacity * (targetBattery - currentBattery) / 100.0;
                        double drawn = needed / 0.9;
                        if (drawn > remaining) {
                            drawn = remaining;
                            needed = drawn * 0.9;
                            depleted = true;
                        } else {
                            depleted = false;
                        }
                        double delivered = needed;
                        double actualDrawn = drawn;
                        double time = delivered / power * 60;
                        double cost = delivered > 30 ? (1.2 * delivered) * 0.95 : 1.2 * delivered;
                        remaining = hub - actualDrawn;
                        hub = remaining;
                        count++;
                        totalCost += cost;
                        totalEnergy += delivered;
                        fourUsed = true;
                        System.out.println("");
                        System.out.println("--- Charging Summary ---");
                        System.out.println("Vehicle: E-Scooter");
                        System.out.printf("Battery: %d%% -> %d%%%n", currentBattery, targetBattery);
                        System.out.printf("Charging Power: %d kW%n", (int)power);
                        System.out.printf("Energy Delivered: %.2f kWh (drawn from hub: %.2f kWh)%n", delivered, actualDrawn);
                        System.out.printf("Charging Time: %.2f minutes %n", time);
                        System.out.printf("Cost: RM %.2f%n", cost);
                        System.out.printf(depleted ? "Hub Battery Depleted! Vehicle only reached %.2f%%%n": "Remaining Hub Battery: %.2f kWh %n", depleted ? (currentBattery + (delivered / capacity) * 100) : remaining);
                        System.out.println("--------------------------");
                    }
                    break;
 
                case 0:
                    System.out.println("hub closed by operator. ");
                    running = false;
                    break;
 
                default:
                    System.out.println("Error: Invalid vehicle selection.");
            }
        }
 
        System.out.println("");
        System.out.println("===== Hub Report =====");
        System.out.println("Vehicles Charged: " + count);
        System.out.printf("Total Energy Delivered: %.2f kWh %n", totalEnergy);
        System.out.printf("Total Revenue: RM %.2f%n ", totalCost);
        System.out.printf("Hub Battery Left: %.2f kWh %n", remaining);
 
        sc.close();
    }
}
