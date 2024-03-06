import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface DiscountStrategy {
    double applyDiscount(double total);
}

// Implementações concretas do Strategy
class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

class FreeShipping implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        System.out.println("Frete gratis aplicado");
        return total;
    }
}

// Contexto que utiliza a estratégia
class ShoppingCart {
    private List<Double> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(double price) {
        products.add(price);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {
        // TODO: Implementar a lógica de cálculo do total
        double total = products.stream().mapToDouble(Double::doubleValue).sum();

        // Verificar se há uma estratégia de desconto configurada
        if (discountStrategy != null) {
            total = discountStrategy.applyDiscount(total);
        }
        return total;  // Retornar o total calculado
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instâncias das estratégias de desconto
        DiscountStrategy tenPercentDiscount = new TenPercentDiscount();
        DiscountStrategy freeShipping = new FreeShipping();

        // Criando o carrinho de compras
        ShoppingCart cart = new ShoppingCart();

        // Adicionando produtos ao carrinho
        String productName = scanner.nextLine();
        double productPrice = scanner.nextDouble();
        cart.addProduct(productPrice);

        // Escolhendo a estratégia de desconto
        int strategyChoice = scanner.nextInt();

        // Configurando a estratégia no carrinho
        switch (strategyChoice) {
            case 1:
                cart.setDiscountStrategy(tenPercentDiscount);
                break;
            case 2:
                cart.setDiscountStrategy(freeShipping);
                break;
            default:
                System.out.println("Escolha invalida. Nenhum desconto aplicado.");
        }

        // TODO: Chamar o método calculateTotal e exibir o resultado
        double total = cart.calculateTotal();
        System.out.println("Total da compra: R$" + total);
    }
}