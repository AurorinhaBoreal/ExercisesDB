package exercises.logic;
import java.util.Scanner;

public class AgeExercise {
        Scanner myS = new Scanner(System.in);    
        String name;        
        int age;
    public void VerifyingAge() {
        name = getName(myS);
        age = getAge(myS, name);
        myS.close();
        String msgAdult = AgeVerify(age) == true ? "maior" : "menor";
        System.out.println(String.format("Olá %s, você possui %d anos. \nPortanto você é %s de idade.", name, age, msgAdult));
    }
    
    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private String getName(Scanner myS) {
         System.out.println("Olá, qual seu nome?");

         String setName = myS.nextLine();
         return setName;
    }

    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private int getAge(Scanner myS, String name) {
        System.out.printf("Olá %s, qual a sua idade? \n", name);

        int setAge = myS.nextInt();
        return setAge;
    }

    // Como os métodos são utilizados apenas nessa classe, não tem necessidade de torna-los públicos
    private boolean AgeVerify(int age) {
        if (age >= 18) {
            return true;
        }
        else {
            return false;
        }
    }
}