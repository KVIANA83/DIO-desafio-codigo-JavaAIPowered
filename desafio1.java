import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {
    private static final UserManager instance = new UserManager();
    private final List<User> users = new ArrayList<>();

    private UserManager() {
        // Construtor privado para evitar instanciação direta
    }

    public static UserManager getInstance() {
        return instance;
    }

    public void addUser(String name) {
        int nextId = users.size() + 1;
        User newUser = new User(nextId, name);
        users.add(newUser);
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        UserManager userManager = UserManager.getInstance();

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            userManager.addUser(name);
        }

        userManager.listUsers();
    }
}
