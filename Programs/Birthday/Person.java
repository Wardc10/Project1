public class Person {
    //stores a persons birthday as an integer (1-365)
    private int birthday;

    //constructor for Person
    public Person(int birthday){
        this.birthday = birthday;
    }

    //getter for birthday
    public int getBirthday(){
        return birthday;
    }

    //removed setter because a birthday shouldn't be changed after a Person object is 'born' (created)
}