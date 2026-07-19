
public class StudentGrade {

    public int CalculateTotal(int[] grades){

           int total = 0;
           for(int i=0;i<grades.length;i++){

                 total+=grades[i];
           }
           return total;

    }


    public double  CalcualteAverage(int total,int numberofsubjects){

        return  (double) total / numberofsubjects;    


    }

    public char claculatGrade(double Average ){


       if(Average>=90){

            return 'O';
       }else if(Average>=80){

          return 'A';
       } else if(Average>=70){

          return 'B';
       }else if(Average>=60){

          return 'C';
       }else if(Average>=50){

          return 'D';
       }

         return 'F';

       }
    
}
