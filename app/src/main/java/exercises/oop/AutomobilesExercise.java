package exercises.oop;

import java.util.Scanner;

public class AutomobilesExercise {
    Scanner scanner = new Scanner(System.in);
    Tow tow = new Tow();
    String state;
    public void choosingVehicle() {
        int action;
        System.out.println("Bem vindo a Concessionária Boreal! O que deseja?");
        System.out.println("1 - Carro \t 2 - Carro Automático \n3 - Moto \t 4 - Moto com Pedal \n5 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                buyCar();
                break;
            case 2:
                buyAutomaticCar();
                break;
            case 3:
                buyMotorcycle();
                break;
            case 4:
                buyMotorcyclePedal();
                break;
            case 5:
                System.out.println("Volte sempre!");
                break;
            default:
            System.out.println("Opção Inválida!");
                choosingVehicle();
                break;
        }
    }

    private void buyCar() {
        int maxSpeed = getMaxSpeed();
        int doors = getDoors();

        Car car = new Car(doors, maxSpeed);
        useCar(car);
    }
    private void useCar(Car car) {
        int action;
        state = (car.turnOn == true) ? "Ligado" : "Desligado";
        System.out.println("O carro está "+state);
        System.out.println("1 - Ligar/Desligar \t 2 - Guinchar \t 3 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                car.On_Off();
                useCar(car);
                break;
            case 2:
                tow.Carrying("Carro");
                System.out.println(tow.toString());
                car.TowAway();
                break;
            default:
                System.out.println("Tchau Tchau!");
                break;
        }
    }

    private void buyAutomaticCar() {
        int maxSpeed = getMaxSpeed();
        int doors = getDoors();
        String brake = "Solto";

        AutomaticCar car = new AutomaticCar(doors, maxSpeed);
        useAutomaticCar(car, brake);
    }
    private void useAutomaticCar(AutomaticCar car, String brake) {
        int action;
        
        state = (car.turnOn == true) ? "Ligado" : "Desligado";
        System.out.println("O carro está "+state);
        System.out.println("O freio está "+brake);
        System.out.println("1 - Ligar/Desligar \t 2 - Apertar Freio \n3 - Guinchar \t 4 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                if (brake.equals("Pressionado")) car.On_Off();
                else System.out.println("Pressione o freio antes de ligar");
                useAutomaticCar(car, brake);
                break;
            case 2:
                car.brake();
                brake = (car.brakePressed == true) ? "Pressionado" : "Solto";
                useAutomaticCar(car, brake);
                break;
            case 3:
                tow.Carrying("Carro Automático");
                System.out.println(tow.toString());
                car.TowAway();
                break;
            default:
                System.out.println("Tchau Tchau!");
                break;
        }
    }

    private void buyMotorcycle() {
        int maxSpeed = getMaxSpeed();

        Motorcycle bike = new Motorcycle(maxSpeed);
        useMotorcycle(bike);
    }
    public void useMotorcycle(Motorcycle bike) {
        int action;
       
        state = (bike.turnOn == true) ? "Ligada" : "Desligada";
        System.out.println("A moto está "+state);
        System.out.println("1 - Ligar/Desligar \t 2 - Guinchar \t 3 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                bike.On_Off();
                useMotorcycle(bike);
                break;
            case 2:
                tow.Carrying("Moto");
                System.out.println(tow.toString());
                bike.TowAway();
                break;
            default:
                System.out.println("Tchau Tchau!");
                break;
        }
    }

    private void buyMotorcyclePedal() {
        int maxSpeed = getMaxSpeed();
        String pedal = "Solto";

        MotorcyclePedal bikePedal = new MotorcyclePedal(maxSpeed);
        useMotorcyclePedal(bikePedal, pedal);
    }
    public void useMotorcyclePedal(MotorcyclePedal bikePedal, String pedal) {
        int action;        
        
        state = (bikePedal.turnOn == true) ? "Ligada" : "Desligada";
        System.out.println("O pedal está "+pedal);
        System.out.println("A moto está "+state);
        System.out.println("1 - Ligar/Desligar \t 2 - Puxar Pedal \n3 - Guinchar \t 4 - Sair");
        action = scanner.nextInt();

        switch (action) {
            case 1:
                if (pedal.equals("Puxado")) bikePedal.On_Off();
                else System.out.println("Puxe o pedal antes de ligar");
                useMotorcyclePedal(bikePedal, pedal);
                break;
            case 2:
                bikePedal.pedal();
                pedal = (bikePedal.pedalPressed == true) ? "Puxado" : "Solto";
                useMotorcyclePedal(bikePedal, pedal);
                break;
            case 3:
                tow.Carrying("Moto com Pedal");
                System.out.println(tow.toString());
                bikePedal.TowAway();
                break;
            default:
                System.out.println("Tchau Tchau!");
                break;
        }
    }

    private int getDoors() {
        System.out.println("Quer um carro de quantas portas?");
        return scanner.nextInt(); 
    }

    private int getMaxSpeed() {
        System.out.println("Qual a velocidade máxima do veiculo?");
        return scanner.nextInt();
    }
    
    private class Automobile {
        private int wheels;
        private int maxSpeed;
        public boolean turnOn;

        private Automobile(int wheels, int maxSpeed, boolean turnOn) {
            this.wheels = wheels;
            this.maxSpeed = maxSpeed;
            this.turnOn = turnOn;
        }

        protected void On_Off() {
            turnOn = !turnOn;
        }

        protected void TowAway() {
        System.out.println("Seu veiculo foi guinchado! É isso o que você queria não?!");
        }
    }

    private class Car extends Automobile {
        private int doors = 4;

        public Car(int doors, int maxSpeed) {
            super(4, maxSpeed, false);
            this.doors = doors;
        }
    }

    private class AutomaticCar extends Car {
        private boolean brakePressed = false;

        public AutomaticCar(int doors, int maxSpeed) {
            super(doors, maxSpeed);
        }

        public void brake() {
            brakePressed = !brakePressed;
        }
    }

    private class Motorcycle extends Automobile {
        
        public Motorcycle(int maxSpeed) {
            super(2, maxSpeed, false);
        }
    }

    private class MotorcyclePedal extends Motorcycle {
        private boolean pedalPressed = false;

        public MotorcyclePedal(int maxSpeed) {
            super(maxSpeed);
        }

        public void pedal() {
            pedalPressed = !pedalPressed;
        }
    }

    private class Tow extends Automobile {
        private String carrying;

        private Tow() {
            super(4, 60, false);
            this.carrying = "Nada";
        }

        public void Carrying(String Automobile) {
            carrying = Automobile;
        }

        public String toString() {
            return "O guincho está guinchando "+carrying;
        }
    }
}
