package co.com.application.appvalidation.records;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecordExampleMain {

    public static void main(String[] args) {
        // Creando transacciones usando método estático de fábrica

        Transaction t1 = Transaction.deposit("Alice", new BigDecimal("1000.00"));
        Transaction t2 = Transaction.withdrawal("Bob", new BigDecimal("500.00"));
        Transaction t3 = Transaction.withdrawal("Charlie", new BigDecimal("200.00"));

        List<Transaction> transactions = List.of(t1, t2, t3);

        // Filtrando transacciones de retiro usando Stream API
        List<Transaction> withdrawals = transactions.stream()
                .filter(t -> t.type() == Transaction.Type.WITHDRAWAL)
                .collect(Collectors.toList());

        System.out.println("Withdrawals:");
        withdrawals.forEach(System.out::println);
    }

  
}