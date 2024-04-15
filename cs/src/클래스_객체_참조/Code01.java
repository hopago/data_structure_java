package 클래스_객체_참조;

public class Code01 {
    public static void main(String[] args) {
        Person01 person = new Person01();
        person.name = "Hopago";
        person.number = "01000000000";
        System.out.println(person.name + " : " + person.number);

        Person01[] members = new Person01[1000];
        members[0] = person;
        members[1] = new Person01();
        members[1].name = "Dopago";
        members[1].number = "01011111111";

        System.out.println(members[1].name + " : " + members[1].number);
    }
}
