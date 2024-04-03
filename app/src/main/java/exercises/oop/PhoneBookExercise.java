package exercises.oop;

import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBookExercise {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Number> phonebook = new ArrayList<>();
    public void PopulateBook() {
        phonebook.add(new Number(phonebook.size()+1, "Aurora Kruschewsky", "(11) 93056-4158"));
        PhoneInterface();
    }

    private void PhoneInterface() {
        int action;
        System.out.println("Selecione a opção desejada:");
        System.out.println("1 - Adicionar Número \t 2 - Ver Números \n3 - Administrar \t 4 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                AddNumber();
                break;
            case 2:
                ShowNumbers();
                PhoneInterface();
                break;
            case 3:
                AdministratorInterface();
                break;
            case 4:
                System.out.println("Até a próxima!");
                break;
            default:
                System.out.println("Ação Inválida!");
                PhoneInterface();
                break;
        }
    }

    private void AddNumber() {
        int idRegister = phonebook.size()+1;
        String contactName;
        String phoneNumber;

        // Captura a linha vazia
        scanner.nextLine();

        System.out.println("Para adicionar um número informe:");
        System.out.println("O Nome do Contato:");
        contactName = scanner.nextLine();
        
        System.out.println("O número do contato no formato (11) 99999-9999:");
        phoneNumber = scanner.nextLine();
        
        boolean strVerified = VerifyNumberFormat(phoneNumber);
        if (strVerified == true) {
            phonebook.add(new Number(idRegister, contactName, phoneNumber));
            System.out.println("O número foi adicionado com sucesso!");
        } else {
            System.out.println("Formatação do Número Incorreta! Insira as informações novamente:");
            AddNumber();
        }

        System.out.println("Retornando ao menu...");
        PhoneInterface();
    }

    private boolean VerifyNumberFormat(String phoneNumber) {
        boolean strFormat = false;
        char verify1 = phoneNumber.substring(0, 1).charAt(0);
        char verify2 = phoneNumber.substring(3, 4).charAt(0);
        char verify3 = phoneNumber.substring(10, 11).charAt(0);
        if (verify1 == '(' && verify2 == ')' && verify3 == '-') {
            strFormat = true;
        }
        
        return strFormat;
    }

    private void ShowNumbers() {
        System.out.println("| ID  |        Nome        |      Número     |");
        phonebook.forEach((number) -> {
            System.out.println(phonebook.get(phonebook.indexOf(number)).toString());
        });
    }

    private void AdministratorInterface() {
        int actionAdmin;
        System.out.println("O que deseja fazer?");
        System.out.println("0 - Deslogar \n1 - Remover Número \t 2 - Limpar Lista");
        actionAdmin = scanner.nextInt();

        switch (actionAdmin) {
            case 0:
                PhoneInterface();
                break;
            case 1:
                RemoveNumber();
                AdministratorInterface();
                break;
            case 2:
                ClearPhonebook();
                break;
            default:
                System.out.println("Ação Inválida!");
                break;
        }
    }

    private void RemoveNumber() {
        int idNumber;
        ShowNumbers();
        System.out.println("Informe o ID do Contato que deseja remover:");
        idNumber = scanner.nextInt();

        phonebook.remove(idNumber-1);

        System.out.println("\nO número foi removido com sucesso! Voltando ao menu...\n");
        AdministratorInterface();
    }

    private void ClearPhonebook() {
        while (phonebook.isEmpty() == false) {
            int i = 0;
            phonebook.remove(i);
        }
        System.out.println(phonebook.size());

        System.out.println("\n Lista limpa!\n");
        PhoneInterface();
    }

    private class Number {
        private int idRegister;
        private String contactName;
        private String phoneNumber;

        public Number(int idRegister, String contactName, String phoneNumber) {
            this.idRegister = idRegister;
            this.contactName = contactName;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "|  "+this.idRegister+"  | "+this.contactName+" | "+phoneNumber+" |";
        }
    }
}
