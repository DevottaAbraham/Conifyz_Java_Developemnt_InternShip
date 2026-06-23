

public class Student {

    private String studentName;

    private int studentId;

    private int[] grades;

    public Student (String studentName , int studentId, int numberofsubjects){

        this.studentName=studentName;

        this.studentId=studentId;

        this.grades=new int[numberofsubjects];
    }

    public String getStudentName(){

        return studentName;
    

    }

    public int getStudentId(){

        return studentId;
    }

    public int[] getGrades(){

        return  grades;
    }

    public void setStudentName(String studentName){
        
        this.studentName=studentName;
    }

    public void setStudentId(int studentId){

        this.studentId=studentId;
    }

    public void setGrades(int[] grades){

        this.grades=grades;
    }
    
    

    

}
