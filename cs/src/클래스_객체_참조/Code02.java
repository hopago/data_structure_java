package 클래스_객체_참조;

public class Code02 {
    public static void main(String[] args) {
        Person01 first = new Person01();
        first.name = "Hopago";
        first.number = "010";

        Person01 second = first;
        second.name = "Hopago should be dopago";

        Person01[] members = new Person01[100];
        members[0] = first;
        members[1] = second;

        members[2] = new Person01();
        members[2].name = "Paka";
        members[2].number = "011";

        System.out.println(first.name);
    }
}
