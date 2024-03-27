package exercises.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {
    ArrayList<Parent> parentList = new ArrayList<>();
    ArrayList<Child> childList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void populatingTree() {
        parentList.add(new Parent(parentList.size()+1, "Carla Pereira", "12/01/1994", true, false, "João Pereira"));
        parentList.add(new Parent(parentList.size()+1, "Augusto Pereira", "12/01/1994", true, false, "João Pereira"));
        childList.add(new Child(childList.size()+1, "João Pereira", "03/07/2020", false, true, "Carla Pereira", "Augusto Pereira"));
        TreeInterface();
    }

    public void TreeInterface() {
        System.out.println("Informe o que deseja fazer:");
        System.out.println("1 - Ver Arvore Genealógica \t");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < parentList.size(); j++) {
                System.out.println(parentList.get(j).toString());
            }
            for (int j = 0; j < childList.size(); j++) {
                System.out.println(childList.get(j).toString());
            }
            
        }
    }

    public class Person {
        private int idPerson;
        private String fullName;
        // Ahh, no banco teria um campo date que permitiria calcular a idade do usuario
        // Mas por praticidade eu vou deixar como string
        private String birthDate;
        private boolean isParent;
        private boolean isChild;

        private Person(int idPerson, String fullName, String birthDate, boolean isParent, boolean isChild) {
            this.idPerson = idPerson;
            this.fullName = fullName;
            this.birthDate = birthDate;
            this.isParent = isParent;
            this.isChild = isChild;
        }

        @Override
        public String toString() {
            return "|   "+this.idPerson+"    |    "+this.fullName+"    | "+this.birthDate+" | "+this.isParent+" | "+this.isChild+" |";
        }
    }

    private class Parent extends Person {
        private int idPerson;
        private String childName;

        public Parent(int idPerson, String fullName, String birthDate, boolean isParent, boolean isChild, String childName) {
            super(idPerson, fullName, birthDate, isParent, isChild);
            this.idPerson = idPerson;
            this.childName = childName;
        }

        @Override
        public String toString() {
            return "|"+parentList.get(idPerson-1).toString()+" | "+this.childName;
        }
    }

    private class Child extends Person {
        private int idPerson;
        private String parent1Name;
        private String parent2Name;

        public Child(int idPerson, String fullName, String birthDate, boolean isParent, boolean isChild, String parent1Name, String parent2Name) {
            super(idPerson, fullName, birthDate, isParent, isChild);
            this.idPerson = idPerson;
            this.parent1Name = parent1Name;
            this.parent2Name = parent2Name;
        }

        @Override
        public String toString() {
            return "|"+childList.get(idPerson-1).toString()+" | "+this.parent1Name+" | "+this.parent2Name;
        }
    }
}
