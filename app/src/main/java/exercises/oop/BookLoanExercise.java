package exercises.oop;

import java.lang.Override;
import java.util.Scanner;
import java.util.ArrayList;

public class BookLoanExercise {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<StatusBook> rentHistory = new ArrayList<>();
    int action;

    public void BookListPopulate() {
        bookList.add(new Book((bookList.size()+1), "Como ser bem suscedido", "Steve Jobs"));
        bookList.add(new Book((bookList.size()+1), "O Java e o Café", "James Gosling"));
        bookList.add(new Book((bookList.size()+1), "Métodos Estáticos", "Robertinho Javeiro"));
        bookList.add(new Book((bookList.size()+1), "Mentorando os Mentorados", "Matheus de Almeida"));
        PersonListPopulate();
    }

    private void PersonListPopulate() {
        personList.add(new Person((personList.size()+1), "Carlinhos da Silva", "912341234"));
        personList.add(new Person((personList.size()+1), "Alice Tatiane", "943214321"));
        personList.add(new Person((personList.size()+1), "Denize da Rosa", "932143214"));
        HistoryPopulate();
    }

    private void HistoryPopulate() {
        rentHistory.add(new StatusBook(1, 1, true, false));
        rentHistory.add(new StatusBook(2, 3, true, false));
        rentHistory.add(new StatusBook(2, 3, false, true));
        rentHistory.add(new StatusBook(1, 1, false, true));
        LibraryInterface();
    }
    
    private void LibraryInterface() {
        System.out.println("Olá! O que você gostaria de fazer?");
        System.out.println("1 - Se Cadastrar \t 2 - Alugar Livro \n3 - Devolver Livro \t 4 - Administrar \n5 - Sair");
        action = scanner.nextInt();
        // Capturar próxima linha vazia
        scanner.nextLine();

        switch (action) {
            case 1:
                signIn();
                break;
            case 2:
                rentBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                AdministratorInterface();
                break;
            case 5:
                System.out.println("Volte sempre! :D");
                break;
            default:
                System.out.println("Opção Inválida!");
                LibraryInterface();
                break;
        }
    }

    private void signIn() {
        int id = personList.size()+1;
        System.out.println("Olá! Para iniciar seu cadastro informe seu nome:");
        String name = scanner.nextLine();
        System.out.println("Agora informe um telefone para contato:");
        String number = scanner.nextLine();

        personList.add(new Person(id, name, number));

        System.out.println("Cadastro efetuado com Sucesso! Voltando para o Menu...");
        LibraryInterface();
    }

    private void rentBook() {
        int bookRented;
        int personRenting;
        
        System.out.println("Informe seu ID:");
        personRenting = scanner.nextInt();

        System.out.println("| IdBook |     BookName     |   Author   |");
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).rented == false) {
                System.out.println(bookList.get(i).toStringUser());    
            }
        }
        System.out.println("Informe o ID do livro que deseja alugar:");
        bookRented = scanner.nextInt();

        bookList.get(bookRented).rented = true;
        rentHistory.add(new StatusBook(bookRented, personRenting, true, false));

        System.out.println("Aluguel registrado! Voltando para o Menu...");
        LibraryInterface();
    }

    private void returnBook() {
        int bookReturned;
        int personReturning;

        System.out.println("Informe seu ID:");
        personReturning = scanner.nextInt();

        System.out.println("Informe o ID do livro que deseja retornar:");
        bookReturned = scanner.nextInt();

        bookList.get(bookReturned).rented = false;
        rentHistory.add(new StatusBook(bookReturned, personReturning, false, true));

        System.out.println("Retorno registrado! Voltando para o Menu...");
        LibraryInterface();
    }

    private void AdministratorInterface() {
        System.out.println("Bem-Vinde a Área da Administração. Escolha o que deseja:");
        System.out.println("0 - Deslogar \n1 - Verificar Histórico de Livros Alugados \n2 - Mostrar Livros \t 3 - Mostrar Usuários \n4 - Remover Livro \t 5 - Remover Usuário");
        action = scanner.nextInt();

        switch (action) {
            case 0:
                System.out.println("Voltando para o Menu...");
                LibraryInterface();
            case 1:
                showHistory();
                System.out.println("\n Retornando... \n");
                break;
            case 2:
                showBooks();
                break;
            case 3:
                showUsers();
                break;
            case 4:
                removeBook();
                break;
            case 5:
                removeUser();
                break;
            default:
                System.out.println("Opção Inválida!");
                AdministratorInterface();
                break;
        }
    }

    private void showHistory() {
        System.out.println("| IdBook | IdPerson | Rented | Returned |");
        for (int i = 0; i < rentHistory.size(); i++) {
            System.out.println(rentHistory.get(i).toString());
        }
        System.out.println("\n Retornando... \n");
        AdministratorInterface();
    }

    private void showBooks() {
        System.out.println("| IdBook |     BookName     |   Author   | Rented |");
        for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());    
        }
        System.out.println("\n Retornando... \n");
        AdministratorInterface();
    }

    private void showUsers() {
        System.out.println("| IdUser |          Name         |    Number    |");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }
        System.out.println("\n Retornando... \n");
        AdministratorInterface();
    }

    private void removeBook() {
        int bookId;
        
        showBooks();
        System.out.println("Informe o ID do Livro que deseja remover:");
        bookId = scanner.nextInt();
        bookList.remove(bookId);

        System.out.println("Livro removido! Voltando para o Painel de Administrador...");
        AdministratorInterface();
    }
    
    private void removeUser() {
        int userId;

        showUsers();
        System.out.println("Informe o ID do Usuário que deseja remover:");
        userId = scanner.nextInt();
        personList.remove(userId);

        System.out.println("Usuário removido! Voltando para o Painel de Administrador...");
        AdministratorInterface();
    }

    private class Person {
        private int idPerson;
        private String name;
        private String number;

        public Person(int idPerson, String name, String number) {
            this.idPerson = idPerson;
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return "|   "+this.idPerson+"    |    "+this.name+"    | "+this.number+" |";
        }
    }

    private class Book {
        private int idBook;
        private String name;
        private String author;
        private boolean rented;

        public Book(int idBook, String name, String author) {
            this.idBook = idBook;
            this.name = name;
            this.author = author;
            this.rented = false;
        }

        @Override
        public String toString() {
            return "|   "+this.idBook+"    | "+this.name+" | "+this.author+" | "+this.rented+" |";
        }

        public String toStringUser() {
            return "|   "+this.idBook+"    | "+this.name+" | "+this.author+" |";
        }
    }

    // Uma pessoa pode alugar muitos livros 
    // Mas um livro só pode ser alugado por uma pessoa
    private class StatusBook {
        private int idBook;
        private int idPerson;
        private boolean rented;
        private boolean returned;

        public StatusBook(int idBook, int idPerson, boolean rented, boolean returned) {
            this.idBook = idBook;
            this.idPerson = idPerson;
            this.rented = rented;
            this.returned = returned;
        }

        @Override
        public String toString() {
            return "|    "+idBook+"   |    "+idPerson+"     |  "+rented+"  |   "+returned+"  |";
        }
    }
}
