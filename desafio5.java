import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }

    // TODO: Implementar método de conversão de USD para outra moeda (por exemplo, JPY)
    // Dica: Você pode criar métodos adicionais conforme necessário.
        // Método para converter USD para JPY
    public double convertUSDtoJPY(double amount) {
        // Assume uma taxa de conversão fixa de 110 JPY por 1 USD
        return amount * 0.85;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        OldCurrencyConverter oldConverter = new OldCurrencyConverter();
        CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

        // TODO: Chamar o método para converter USD para a nova moeda desejada (por exemplo, JPY)
        double convertedJPY = adapter.convertUSDtoJPY(input);
        // TODO: Imprimir o resultado da conversão

        System.out.println("USD: " + input);
        // TODO: Imprimir o resultado da conversão com a nova moeda (por exemplo, JPY)
        System.out.println("EUR: " + convertedJPY);
       
    }
}