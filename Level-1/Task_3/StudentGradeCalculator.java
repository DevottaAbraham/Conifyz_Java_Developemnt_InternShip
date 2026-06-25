import java.util.Scanner;


public class StudentGradeCalculator {

    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter The Student Name : ");

        String studentName=sc.nextLine();

        System.out.println("Enter The Student ID: ");

        int studentId=sc.nextInt();

        System.out.println("Enter The Number of Subjects: ");

        int numberofsubjects=sc.nextInt();

        

        Student student = new Student(studentName,studentId,numberofsubjects);


       for (int i = 0; i < student.getGrades().length; i++) {

    System.out.print("Enter Mark " + (i + 1) + ": ");
    student.getGrades()[i] = sc.nextInt();

    while (student.getGrades()[i] < 0 || student.getGrades()[i] > 100) {

        System.out.println("Invalid Mark! Please enter marks between 0 and 100.");

        System.out.print("Enter Mark " + (i + 1) + ": ");
        student.getGrades()[i] = sc.nextInt();
    }
}
   

    StudentGrade logic = new StudentGrade();

       int total = logic.CalculateTotal(student.getGrades());

    double average = logic.CalcualteAverage(total, student.getGrades().length);

       char grade = logic.claculatGrade(average);

     
       System.out.println("\t ******************** ");

       System.out.println("\t Student ReposrtCard");

       
       System.out.println("\t ******************** ");


       System.out.println(" \t Student Name :"+student.getStudentName());



       System.out.println("\t Student ID :"+student.getStudentId());

       System.out.println(" \t Total Marks :"+total);

       System.out.println("\t Average Marks :"+average);

       System.out.println("\t Final Grade :"+grade);
        



      sc.close();

    }


}
