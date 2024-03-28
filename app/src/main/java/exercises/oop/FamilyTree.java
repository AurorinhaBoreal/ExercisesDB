package exercises.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {
    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<Parent> parentList = new ArrayList<>();
    ArrayList<Child> childList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    public void populatingTree() {
        parentList.add(new Parent(personList.size()+1, "Carla Pereira", 1994, true, false, "João Pereira"));
        parentList.add(new Parent(personList.size()+1, "Augusto Pereira", 1994, true, false, "João Pereira"));
        childList.add(new Child(personList.size()+1, "João Pereira", 2020, false, true, "Carla Pereira", "Augusto Pereira"));
        TreeInterface();
    }

    public void TreeInterface() {
        int action;
        System.out.println("Informe o que deseja fazer:");
        System.out.println("1 - Escolher pessoa para ver Arvore Genealógica \n"
                +"2 - Adicionar Parente \t 3 - Adicionar Criança \t 4 - Sair");
        action = scanner.nextInt();
        
        switch (action) {
            case 1:
                familyTree();
                break;
            case 2:
                AddParent();
                break;
            case 3:
                AddChild();
                break;
            case 4:
                System.out.println("Até a próxima!");
                break;
            default:
                System.out.println("Opção Inválida!");
                TreeInterface();
                break;
        }
        
        System.out.println("PARENTES:");
        parentList.forEach((parent) -> System.out.println(parent.toString()));
        System.out.println("FILHOS:");
        childList.forEach((child) -> System.out.println(child.toString()));
    }

    public void familyTree() {
        int desiredID;
        showPerson();
        System.out.println("Informe o ID da pessoas desejada:");

        desiredID = (scanner.nextInt()-1);

        if (personList.get(desiredID).isChild == true) {
            System.out.println("CRIANÇA!");
        } else if (personList.get(desiredID).isParent == true) {
            System.out.println("PARENTE!!");
        } else {
            System.out.println("Não é criança nem parente? Ta certo isso ai?!");
        }
        
    }

    public void showPerson() {
        System.out.println("PESSOAS:");
        System.out.println("| ID |      Nome     |  Nascimento  | Criança | Parente |");
        personList.forEach((person) -> System.out.println(person.toString()));
    }

    public void AddParent() {

    }

    public void AddChild() {

    }
    
    public class Person {
        private int idPerson;
        private String fullName;
        // Ahh, no banco teria um campo date que permitiria calcular a idade do usuario
        // Mas por praticidade eu vou deixar como string
        private int birthYear;
        private boolean isParent;
        private boolean isChild;

        private Person(int idPerson, String fullName, int birthYear, boolean isParent, boolean isChild) {
            this.idPerson = idPerson;
            this.fullName = fullName;
            this.birthYear = birthYear;
            this.isParent = isParent;
            this.isChild = isChild;
        }

        @Override
        public String toString() {
            return "|  "+this.idPerson+" | "+this.fullName+" |     "+this.birthYear+"     |  "+this.isChild+"  |   "+this.isParent+"  |";
        }

        public String toStringTree() {
            return "| "+this.idPerson+" | "+this.fullName+" | "+this.birthYear+" |";
        }
    }

    private class Parent extends Person {
        private int idPerson;
        private String childName;

        private Parent(int idPerson, String fullName, int birthYear, boolean isParent, boolean isChild, String childName) {
            super(idPerson, fullName, birthYear, isParent, isChild);
            personList.add(new Person(idPerson, fullName, birthYear, isParent, isChild));
            this.idPerson = idPerson;
            this.childName = childName;
        }

        @Override
        public String toString() {
            return "| "+this.idPerson+" | "+this.childName;
        }
    }

    public class Child extends Person {
        private int idPerson;
        private String parent1Name;
        private String parent2Name;

        private Child(int idPerson, String fullName, int birthYear, boolean isParent, boolean isChild, String parent1Name, String parent2Name) {
            super(idPerson, fullName, birthYear, isParent, isChild);
            personList.add(new Person(idPerson, fullName, birthYear, isParent, isChild));
            this.idPerson = idPerson;
            this.parent1Name = parent1Name;
            this.parent2Name = parent2Name;
        }

        @Override
        public String toString() {
            return "| "+this.idPerson+" | "+this.parent1Name+" | "+this.parent2Name;
        }

    }
}
