import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface Observer
interface Observer {
    void update(String productName);
}

// Classe concreta Observer
class User implements Observer {
    private String name;
    private boolean wantsNotification; // Adicionando atributo para armazenar a escolha de notificação

    public User(String name) {
        this.name = name;
        this.wantsNotification = true; // Por padrão, um usuário deseja notificações
    }

    public boolean shouldReceiveNotifications() {
        return wantsNotification;
    }

    @Override
    public void update(String productName) {
    if (shouldReceiveNotifications()) {
        System.out.println("Notificacao recebida" + name + ": Novo produto adicionado - " + productName);
    } else {
        System.out.println("Programa Encerrado");
    }
}

    

    public void setWantsNotification(boolean wantsNotification) {
        this.wantsNotification = wantsNotification;
    }
}

// Interface Observable
interface CatalogObservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String productName);
}

// Classe concreta Observable
class Catalog implements CatalogObservable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String productName) {
        for (Observer observer : observers) {
            if (((User) observer).shouldReceiveNotifications()) {
                observer.update(productName);
            }
        }
    }

    public void addProduct(String name, String description, double price) {
        notifyObservers(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando catálogo e usuário
        Catalog catalog = new Catalog();
        User user = new User("");

        // Inscrição do usuário no catálogo
        catalog.addObserver(user);

        // Adicionando novo produto
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir a quebra de linha após nextDouble
        String subscribeChoice = scanner.nextLine().toUpperCase();
        
        while (!subscribeChoice.equals("S") && !subscribeChoice.equals("N")) {
            subscribeChoice = scanner.nextLine().toUpperCase();
        }

        // Verificando a escolha de notificação do usuário
        user.setWantsNotification(subscribeChoice.equalsIgnoreCase("S"));

        // Adicionando produto ao catálogo
        catalog.addProduct(name, description, price);
       
       if (user.shouldReceiveNotifications()) {
            System.out.println(""); 
        } else {
            System.out.println("Programa Encerrado.");
        } 
        
    }
}
