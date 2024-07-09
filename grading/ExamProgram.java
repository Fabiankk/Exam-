import java.util.Scanner;

public class ExamProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
// d0 while will help choose between viewing coursework results, exam results or exiting
        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults(scanner);
                    break;
                case 2:
                    viewExamResults(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
// I have put this in a way it asks you to fill each mark out of the maximum
    public static void viewCourseworkResults(Scanner scanner) {
        int[] courseworkMarks = new int[5];
        String[] assessments = {"Assignment 1", "Assignment 2", "Assignment 3", "CAT 1", "CAT 2"};
        int[] maxMarks = {5, 5, 10, 15, 15};
        double totalMaxMarks = 50; // Sum of maxMarks array

        for (int i = 0; i < courseworkMarks.length; i++) {
            System.out.print("Enter marks for " + assessments[i] + " (out of " + maxMarks[i] + "): ");
            courseworkMarks[i] = scanner.nextInt();
        }

        double courseworkTotal = 0;
        for (int i = 0; i < courseworkMarks.length; i++) {
            courseworkTotal += courseworkMarks[i];
        }

        double courseworkPercentage = (courseworkTotal / totalMaxMarks) * 50;
        System.out.println("Coursework total marks: " + courseworkTotal);
        System.out.println("Coursework percentage (50%): " + courseworkPercentage);

        boolean hasDoneTwoThirds = checkCourseworkCompletion(courseworkMarks);
        if (!hasDoneTwoThirds) {
            System.out.println("You have not completed 2/3 of the coursework. You are required to repeat the unit.");
        }
    }
//This calculates the final mark of the exam 
    public static void viewExamResults(Scanner scanner) {
        System.out.print("Enter final exam marks (out of 100): ");
        int finalExamMarks = scanner.nextInt();

        System.out.print("Enter total coursework percentage (50%): ");
        double courseworkPercentage = scanner.nextDouble();

        double finalExamPercentage = (finalExamMarks / 100.0) * 50;
        double totalScore = courseworkPercentage + finalExamPercentage;

        System.out.println("Final exam percentage (50%): " + finalExamPercentage);
        System.out.println("Total score: " + totalScore);
    }

    public static boolean checkCourseworkCompletion(int[] courseworkMarks) {
        int countCompleted = 0;
        for (int marks : courseworkMarks) {
            if (marks > 0) {
                countCompleted++;
            }
        }
        // At least 2/3 of 5 assessments
        return countCompleted >= 3; 
    }
}