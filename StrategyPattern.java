// Simple Strategy Pattern Example in Java

// Strategy interface
interface Strategy {
    String execute(String data);
}

// Concrete strategies
class ConcreteStrategyA implements Strategy {
    @Override
    public String execute(String data) {
        return "Strategy A: " + data.toUpperCase();
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public String execute(String data) {
        return "Strategy B: " + data.toLowerCase();
    }
}

// Context
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String data) {
        return strategy.execute(data);
    }
}

// Main class
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        System.out.println(context.executeStrategy("Hello World"));

        context.setStrategy(new ConcreteStrategyB());
        System.out.println(context.executeStrategy("Hello World"));
    }
}