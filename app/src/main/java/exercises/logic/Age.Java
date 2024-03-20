package exercises.logic;
import java.util.Scanner;

public class Age {
    private String name;
    private int age;

    public Age() {
        Scanner myS = new Scanner(System.in);
        name = getName(myS);
        age = getAge(myS, name);
        myS.close();
        
        String msgAdult = AgeVerify(age) == true ? "maior" : "menor";
        String.format("Olá %s, você possui %d anos. \nPortanto você é %s de idade.", name, age, msgAdult);
    }
    
    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private String Name(Scanner myS) {
         System.out.println("Olá, qual seu nome?");

         String n = myS.nextLine();
         return n;
    }

    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private int Age(Scanner myS, String name) {
        System.out.printf("Olá %s, qual a sua idade? \n", name);

        int a = myS.nextInt();
        return a;
    }

    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private boolean AgeVerify(int age) {
        if (age >= 18) return true;
        else return false;
    }
}