public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student (int id,String name,double gpa){
        this.gpa=gpa;
        this.name=name;
        this.id=id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    void displayInfo(){
        System.out.println("Id:"+Student.this.getId()+" | Name:"+Student.this.getName()+" | Gpa:"+Student.this.getGpa());
    }
}
