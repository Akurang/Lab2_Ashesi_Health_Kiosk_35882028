import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Ashesi Health Kiosk");

        System.out.print("\nEnter service code (P/L/T/C): ");
        String letterSelection = input.nextLine();
        String upperLetterSelection = letterSelection.toUpperCase();

        // Task 1
        switch(upperLetterSelection){
            case "P":
                System.out.println("Go to: Pharmacy Desk");
                break;
            case "L":
                System.out.println("Go to: Lab Desk");
                break;
            case "T":
                System.out.println("Go to: Triage Desk");
                break;
            case "C":
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
        }

        // Declare variables 
        int healthMetric = 0;
        double roundBMI = 0;
        int numberTablets = 0;
        double angle = 0;
        double sin = 0;
        double cos = 0;

        // Task 2

        if(upperLetterSelection.equals("T")){
            System.out.println("\nEnter the health metric: 1 for BMI, 2 for Dosage round-up, 3 for simple trig helper");
            healthMetric = input.nextInt();

            if(healthMetric == 1){
                System.out.print("Enter weight(kg): ");
                double weight = input.nextDouble();

                System.out.print("Enter height(m): ");
                double height = input.nextDouble();

                double bmi = (weight) / Math.pow(height,2);
                roundBMI = Math.round(bmi * 10) / 10.0;

                System.out.print("BMI: " + roundBMI);
                if(roundBMI < 18.5){
                    System.out.println(" Category: Underweight");
                }
                else if(roundBMI <= 24.9){
                    System.out.println(" Category: Normal");
                }
                else if(roundBMI <= 29.9){
                    System.out.println(" Category: Overweight");
                }
                else{
                    System.out.println(" Category: Obese");
                }
            }
            else if (healthMetric == 2){
                System.out.print("Enter the required dosage (mg): ");
                double dosage = input.nextDouble();

                numberTablets = (int) Math.ceil(dosage / 250.0);

                System.out.println("Tablets: "+ numberTablets);
            }
            else if (healthMetric == 3){
                System.out.print("Enter an angle in degrees: ");
                angle = input.nextDouble();

                double rad = Math.toRadians(angle);

                sin = Math.round(Math.sin(rad)*1000)/1000.0;
                cos = Math.round(Math.cos(rad)*1000)/1000.0;

                System.out.println("sin(" + angle + "°) = " + sin);
                System.out.println("cos(" + angle + "°) = " + cos);
            }
            else{
                System.out.println("Enter either number 1, 2 or 3 only");
            }
        }

        // Task 3
        char upperChar = (char) (Math.random() * 26 + 'A');
        int randNum1 = 3 + (int)(Math.random()*7);
        int randNum2 = 3 + (int)(Math.random()*7);
        int randNum3 = 3 + (int)(Math.random()*7);
        int randNum4 = 3 + (int)(Math.random()*7);

        String shortId = "" + upperChar + randNum1 + randNum2 + randNum3 + randNum4;

        System.out.println("\nGenerated ID: " + shortId);

        if(shortId.length() != 5){
            System.out.println("Invalid length");
        }
        else if (!Character.isLetter(shortId.charAt(0))){
            System.out.println("Invalid: first char must be a letter");
        }
        else if(!Character.isDigit(shortId.charAt(1)) || 
                !Character.isDigit(shortId.charAt(2)) || 
                !Character.isDigit(shortId.charAt(3)) || 
                !Character.isDigit(shortId.charAt(4))){
            System.out.println("Invalid: last 4 must be digits");
        }
        else{
            System.out.println("ID OK");       
        }

        // Task 4
        System.out.print("\nEnter your first name: ");
        String firstName = input.next();

        char baseCode = Character.toUpperCase(firstName.charAt(0));
        System.out.println("Base code = " + baseCode);

        char shiftedLetter = (char)('A' + (baseCode - 'A' + 2) % 26);
        System.out.println("Shifted letter of base code = " + shiftedLetter);

        String lastTwo = shortId.substring(shortId.length() - 2);
        System.out.println("Last two characters for ID (task 3): " + lastTwo);

        int metricValue = 0;

        if(upperLetterSelection.equals("T")){
            if(healthMetric == 1){
                metricValue = (int) Math.round(roundBMI);
                System.out.println("BMI = " + roundBMI + " (rounded value = " + metricValue + ")");
            }
            else if(healthMetric == 2){
                metricValue = numberTablets;
                System.out.println("Tablet count = " + metricValue);
            }
            else if(healthMetric == 3){
                metricValue = (int) Math.round(sin * 100);
                System.out.println("sin(" + angle + "°) * 100 = " + metricValue);
            }
        }

        String displayCode = shiftedLetter + lastTwo + "-" + metricValue;
        System.out.println("Display Code: " + displayCode);

        // Task 5
        System.out.print("\nSummary: ");
        String serviceName = "";
        
        switch(upperLetterSelection){
            case "P":
                serviceName = "PHARMACY";
                break;
            case "L":
                serviceName = "LAB";
                break;
            case "T":
                serviceName = "TRIAGE";
                break;
            case "C":
                serviceName = "COUNSELING";
                break;
        }

        System.out.print(serviceName + " | ID=" + shortId + " | ");
        
        if(upperLetterSelection.equals("T") && healthMetric == 1){
            System.out.print("BMI=" + roundBMI + " | ");
        }
        
        System.out.println("Code=" + displayCode);

        input.close();
    }
}
