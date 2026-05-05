// Exemplo do Padrão Strategy: Sistema de Pagamento

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagando R$ " + amount + " com cartão de crédito **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagando R$ " + amount + " via PayPal para " + email);
    }
}

class BoletoPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Gerando boleto no valor de R$ " + amount + ". Pague até a data de vencimento.");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double total = 0;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addItem(double price) {
        total += price;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Selecione um método de pagamento.");
            return;
        }
        paymentStrategy.pay(total);
        total = 0; // Reset after payment
    }
}

// Main class
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adicionando itens ao carrinho
        cart.addItem(50.0); // Camiseta
        cart.addItem(30.0); // Calça
        cart.addItem(20.0); // Sapatos

        // Pagamento com cartão de crédito
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        cart.checkout();

        // Adicionando mais itens
        cart.addItem(100.0); // Notebook

        // Pagamento via PayPal
        cart.setPaymentStrategy(new PayPalPayment("usuario@email.com"));
        cart.checkout();

        // Mais itens
        cart.addItem(15.0); // Livro

        // Pagamento com boleto
        cart.setPaymentStrategy(new BoletoPayment());
        cart.checkout();
    }
}