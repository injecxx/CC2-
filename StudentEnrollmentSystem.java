//Parrocha, Joshua Anthony L.

public class StudentEnrollmentSystem {
    public static void main(String[] args) {
        String[] studentNames = {"Sherley", "Grey", "John", "Carla", "Wendy"};
        
        // 2D array to store grades for each student in 3 subjects
        double[][] grades = {
            {75, 95, 91}, //Sherley's grades
            {87, 98, 89}, //Grey's grades
            {76, 81, 73}, //John's grades
            {85, 80, 94}, //Carla's grades
            {95, 91, 98}, //Wendy's grades
        };
        
        //Calculate and display average grades for each student
        System.out.println("Student's Average Grade:");
        for (int i = 0; i < studentNames.length; i++) {
            double sum = 0;
            for (double grade : grades[i]) {
                sum += grade; //Sum up the grades
            }
            double average = sum / grades[i].length; //Calculate average
            System.out.printf("%-10s: %.2f%n", studentNames[i], average);
        }
    }
}