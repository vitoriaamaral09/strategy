# strategy
Atividade Design Patterns - Aula 28-04

## Padrão Strategy

O padrão Strategy permite definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

### Exemplo em Java

O exemplo implementa um sistema de pagamento usando o padrão Strategy. Inclui diferentes métodos de pagamento (cartão de crédito, PayPal e boleto) que podem ser trocados dinamicamente em um carrinho de compras.

- `PaymentStrategy`: Interface para estratégias de pagamento.
- `CreditCardPayment`, `PayPalPayment`, `BoletoPayment`: Implementações concretas.
- `ShoppingCart`: Contexto que utiliza a estratégia para processar pagamentos.

#### Como executar

Certifique-se de ter Java instalado (JDK 8 ou superior). Compile e execute:

```bash
javac StrategyPattern.java
java StrategyPattern
```

Saída esperada:
```
Pagando R$ 100.0 com cartão de crédito **** **** **** 3456
Pagando R$ 100.0 via PayPal para usuario@email.com
Gerando boleto no valor de R$ 15.0. Pague até a data de vencimento.
```

### Dependências

JDK instalado.

### Dependências

- Python: Nenhuma dependência externa.
- Java: JDK instalado.
