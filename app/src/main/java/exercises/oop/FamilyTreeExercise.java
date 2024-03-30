package exercises.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTreeExercise {
    // Okkay vamos lá. Explicar isso pra mim não esquecer em dois dias
    // Ja adianto, ta muito confuso! KK

    // Temos essas 3 listas
    // personList -> Informações Gerais sobre as crianças e os parentes (pais)
    // Essas informações incluem: id, nome, ano de nascimento, se é parente, se é criança
    ArrayList<Person> personList = new ArrayList<>();
    // parentList -> Informações que relacionam os parentes com as crianças
    // id do parente -> Para poder relacionar com a personList e pegar as informações
    // nome do filho (criança) -> Para poder buscar na na personList
    ArrayList<Parent> parentList = new ArrayList<>();
    // childList -> Informações que relacionam as crianças com os parentes
    // id da criança -> Para poder relacionar com a personList e pegar as informações
    // nome do parente1, nome do parente2 -> Para poder buscar na personList
    ArrayList<Child> childList = new ArrayList<>();

    // Resumidamente a personList é onde está todos os dados importantes, a parentList
    // e childList servem mais para fazermos a relação e conseguir buscarmos os dados
    // na personList
    Scanner scanner = new Scanner(System.in);
    
    public void populatingTree() {
        parentList.add(new Parent(personList.size()+1, "Carla Pereira", 1994, true, false, "João Pereira"));
        parentList.add(new Parent(personList.size()+1, "Augusto Pereira", 1994, true, false, "João Pereira"));
        childList.add(new Child(personList.size()+1, "João Pereira", 2020, false, true, "Carla Pereira", "Augusto Pereira"));
        TreeInterface();
    }

    private void TreeInterface() {
        int action;
        System.out.println("Informe o que deseja fazer:");
        System.out.println("1 - Escolher pessoa para ver Arvore Genealógica \n"
                +"2 - Adicionar Parente \t 3 - Adicionar Criança \t 4 - Sair");
        action = scanner.nextInt();
        scanner.nextLine();
        
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
    }

    private void familyTree() {
        int desiredID;
        showPerson();
        System.out.println("Informe o ID da pessoas desejada:");

        desiredID = (scanner.nextInt()-1);
        scanner.nextLine();

        if (personList.get(desiredID).isParent == true) {
            // Verifica se a pessoa selecionada é um parente, se for ele terá que pegar
            // o nome do filho na parentList, para buscar o ID do filho na personList
            // para poder buscar o filho na childList pelo ID
            // para poder ter os nomes de ambos os parentes, para poder busca-los
            // na personList, para serem encontrados seus respectivos indexes 
            // e serem apresentados suas informações...
            getParentInfo(desiredID);
        } 
        
        else if (personList.get(desiredID).isChild == true) {
            // Esse é mais simples! Como você escolheu um filho, você ja tem o index dele
            // na personList. Você SÒ vai pegar o id dele, buscar na childList,
            // pegar o nome dos parentes, buscar na personList, pegar os respectivos IDs,
            // pegar os respectivos indexes e apresentar as informações
            getChildInfo(desiredID);
        } else {
            System.out.println("Não é criança nem parente? Ta certo isso ai?!");
        }
        
        // Eu dei umas 7 voltas... Mas ta funcionando!! kk...
        // Eu... Eu vou refatorar quando eu tiver mais tempo e um conhecimento melhor!
        // Eu definitivamente preciso renomear os métodos e variaveis pra 
        // algo mais claro também...
    }

    private void getParentInfo(int desiredID) {
        String childName;
        int searchChildParents;
        // Array para armazenar os indexes da personList
        // Indexes: 0 -> Child | 1 -> Parent1 | 2 -> Parent2
        int[] indexes = {0, 0, 0};
        
        // Pega o nome da criança
        childName = parentList.get(desiredID).childName;

        // Usa o nome para buscar o ID na personList e depois o ID 
        // para buscar o index da criança na childList
        // O index na childList é necessário para ter o nome dos dois parentes
        searchChildParents = searchChild(childName);

        // Usa o nome para buscar o index na personList e ter as informações gerais
        indexes[0] = getChildIndex(childName);

        // Pega o nome dos parentes utilizando o index da criança
        // Depois busca os nomes na personList para encontrar o index
        indexes[1] = searchParent1(searchChildParents);
        indexes[2] = searchParent2(searchChildParents);

        System.out.println("Puxando as informações temos:");
        showTree(indexes);
    }

    private void getChildInfo(int desiredID) {
        int searchChildParents;
        // Array para armazenar os indexes da personList
        // Indexes: 0 -> Child | 1 -> Parent1 | 2 -> Parent2
        int[] indexes = {0, 0, 0};

        // Atribui o desiredID como o ID da criança na personList
        indexes[0] = desiredID;

        // Pega o ID da criança e depos busca o index na childList
        // O index na childList é necessário para ter o nome dos dois parentes
        searchChildParents = searchChild2(indexes[0]);

        // Pega o nome dos parentes utilizando o index da criança
        // Depois busca os nomes na personList para encontrar o index
        indexes[1] = searchParent1(searchChildParents);
        indexes[2] = searchParent2(searchChildParents);

        System.out.println("Puxando as informações temos:");
        showTree(indexes);
    }
    
    private void showTree(int[] indexes) {
        ArrayList<String> treeInfo = new ArrayList<>();

        populatingTreeASCII(treeInfo, indexes);
        loadTree(treeInfo);

        System.out.println("Informações mostradas, voltando ao menu...");
        TreeInterface();
    }

    private void loadTree(ArrayList<String> treeInfo) {
        for (int i = 0; i < treeInfo.size(); i++) {
            System.out.println(treeInfo.get(i));
        }
    }
    private void populatingTreeASCII(ArrayList<String> treeInfo, int[] indexes) {
        treeInfo.add("            ______                       _   _             _______                      ");
        treeInfo.add("           |  ____|                     (_) | |           |__   __|                     ");
        treeInfo.add("           | |__      __ _   _ __ ___    _  | |  _   _       | |     _ __    ___    ___ ");
        treeInfo.add("           |  __|    / _` | | '_ ` _ \\  | | | | | | | |      | |    | '__|  / _ \\  / _ \\");
        treeInfo.add("           | |      | (_| | | | | | | | | | | | | |_| |      | |    | |    |  __/ |  __/");
        treeInfo.add("           |_|       \\__,_| |_| |_| |_| |_| |_|  \\__, |      |_|    |_|     \\___|  \\___|");
        treeInfo.add("                                                  __/ |                                 ");
        treeInfo.add("                                                 |___/                                  \n\n\n\n");
        treeInfo.add("                                                      .");
        treeInfo.add("                                                   .:---:.");
        treeInfo.add("                                                   :------:");
        treeInfo.add("                                                ...------.");
        treeInfo.add("                                              .---:   ...::.");
        treeInfo.add("                                             .-----:..:----:");
        treeInfo.add("                                             :------.-------");
        treeInfo.add("                                          ... .:... ..::---.");
        treeInfo.add("                                         :----.  .---:   .:---.");
        treeInfo.add("                                        :-----:.:-----:.:-----:.");
        treeInfo.add("                                  .:.. .:-----:.------:.:-----:");
        treeInfo.add("   ...............................:----:.......::...:.... .::::::::::::::::::::::::::::::::::::::.");
        treeInfo.add("  :.             PARENTE I           :--:    :---:. .:---. .--:             PARENTE II           :");
        treeInfo.add("  :.           "+personList.get(indexes[1]).fullName+"         ::..  .------::------:---:           "+personList.get(indexes[2]).fullName+"        :");
        treeInfo.add("  :.               "+personList.get(indexes[1]).birthYear+"             . .:-:.:-----.:------..:-:                 "+personList.get(indexes[2]).birthYear+"              :");
        treeInfo.add("  :..................................: :-----.   .::. ... ....:::::::::::::::::::::::::::::::::::.");
        treeInfo.add("    .-:...:.....    .------. .------: :-----. .:----. :------.  .-...:....");
        treeInfo.add("    .+=*-==-==-.    .----::. .:--:.. .------:.------:.-------.  :-:+==:++-.");
        treeInfo.add("                     .    .---:.   .. .::--:. :-----.  .----.");
        treeInfo.add("                   .---: .------..:---.    .::.  ...... ........");
        treeInfo.add("                  .-----:.------.------:..----:..:-----..:-----:");
        treeInfo.add("                 .:-----:..::.  .------.:------.:------::------:");
        treeInfo.add("                  ........--:.    ..    .:::--:. ..---:.  .:--:.");
        treeInfo.add("                        .:----:..-::.        ..:.   ..::--. ..");
        treeInfo.add("                        .------.-----:.    .:----: .------:");
        treeInfo.add("                        .:-:....------.   .------:..------:");
        treeInfo.add("                             . .:--:...::. .::---:    .::.");
        treeInfo.add("                      ......:---:.....===:................");
        treeInfo.add("                      .              FILHO               :");
        treeInfo.add("                      .           "+personList.get(indexes[0]).fullName+"           :");
        treeInfo.add("                      .               "+personList.get(indexes[0]).birthYear+"               :");
        treeInfo.add("                      ::::::::::::---------:::::::::::::::");
        treeInfo.add("                                  .-=++++=-.");
        treeInfo.add("                                    :++++==.");
        treeInfo.add("                                     :=====.");
        treeInfo.add("                                    .-=====:");
        treeInfo.add("                                    .-=====:");
        treeInfo.add("                                    .======-");
        treeInfo.add("                                    :======-.");
        treeInfo.add("                                    -=======.");
        treeInfo.add("                                   .========:");
        treeInfo.add("                                   .========-");
        treeInfo.add("                                   :========-.");
        treeInfo.add("                                   -=========.");
    }

    private void showPerson() {
        System.out.println("PESSOAS:");
        System.out.println("| ID |      Nome     |  Nascimento  | Filho? | Parente? |");
        personList.forEach((person) -> System.out.println(person.toString()));
    }

    private void AddParent() {
        String fullName, childName;
        int birthYear;
        
        System.out.println("Vejo que quer adicionar um novo parente! \n"
        +"Por favor, insira as informações solicitadas:");

        fullName = getFullName();
        birthYear = getBirthYear();
        childName = getChildName();

        parentList.add(new Parent(personList.size()+1, fullName, birthYear, true, false, childName));
        
        System.out.println("O parente foi adicionado com sucesso! Voltando ao menu...");
        TreeInterface();
    }

    private void AddChild() {
        String fullName, parent1, parent2;
        int birthYear;

        System.out.println("Vejo que quer adicionar um novo filho! \n" 
        +"Por favor, insira as informações solicitadas:");

        fullName = getFullName();
        birthYear = getBirthYear();
        parent1 = getParentName();
        parent2 = getParentName();

        childList.add(new Child(personList.size()+1, fullName, birthYear, false, true, parent1, parent2));

        System.out.println("O filho foi adicionado com sucesso! Voltando ao menu...");
        TreeInterface();
    }
    
    private String getFullName() {
        String fullName;
        System.out.println("Insira seu o nome completo:");
        fullName = scanner.nextLine();
        return fullName;
    }

    private int getBirthYear() {
        int birthYear;
        System.out.println("Insira o ano de nascimento:");
        birthYear = scanner.nextInt();
        scanner.nextLine();
        return birthYear;
    }

    private String getChildName() {
        String childName;
        System.out.println("Insira o nome do filho:");
        childName = scanner.nextLine();
        return childName;
    }

    private String getParentName() {
        String parentName;
        System.out.println("Informe o nome do parente:");
        parentName = scanner.nextLine();
        return parentName;
    }
    
    private int getChildIndex(String child) {
        int childIndex = -1;

        // Pegando index da criança para apresentar as informações
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).fullName.equals(child)) {
                childIndex = i;
            }
        }
        return childIndex;
    }

    private int searchChild(String child) {
        int childID = -1;
        int childIndex = -1;

        // ANALISAR SE É POSSIVEL TROCAR PELA FUNÇÃO DO ARRAYLIST
        // Pegando ID da criança na personList por meio do nome
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).fullName.equals(child)) {
                childID = personList.get(i).idPerson;
            }
        }

        // ANALISAR SE É POSSIVEL TROCAR PELA FUNÇÃO DO ARRAYLIST
        // Pegando o index da criança na lista de crianças por meio do ID
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).idPerson == childID) {
                childIndex = i;
            }
        }
        return childIndex;
    }

    private int searchChild2(int desiredID) {
        int childID = -1;
        int childIndex = -1;

        childID = personList.get(desiredID).idPerson;
        
        // ANALISAR SE É POSSIVEL TROCAR PELA FUNÇÃO DO ARRAYLIST
        // Pegando o index da criança na lista de crianças por meio do ID
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).idPerson == childID) {
                childIndex = i;
            }
        }
        return childIndex;
    }

    private int searchParent1(int childIndex) {
        String p1Name;
        int parent = -1;
        p1Name = childList.get(childIndex).parent1Name;

        // ANALISAR SE É POSSIVEL TROCAR PELA FUNÇÃO DO ARRAYLIST
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).fullName.equals(p1Name)) parent = i;
        }

        return parent;
    }

    private int searchParent2(int childIndex) {
        String p2Name;
        int parent = -1;
        p2Name = childList.get(childIndex).parent2Name;

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).fullName.equals(p2Name)) parent = i;
        }

        return parent;
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

        public String toStringShow() {
            return "| "+this.idPerson+" | "+this.fullName+" | "+this.birthYear+" | ";
        }

        public String toStringTree() {
            return "| "+this.fullName+" | "+this.birthYear+" | ";
        }
    }

    private class Parent extends Person {
        private String childName;

        private Parent(int idPerson, String fullName, int birthYear, boolean isParent, boolean isChild, String childName) {
            super(idPerson, fullName, birthYear, isParent, isChild);
            personList.add(new Person(idPerson, fullName, birthYear, isParent, isChild));
            this.childName = childName;
        }

        public String toStringShow() {
            return this.childName+" |";
        }
    }

    private class Child extends Person {
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
    }
}
