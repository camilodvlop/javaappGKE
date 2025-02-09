package co.com.application.appvalidation.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
     * Record Transaction con lógica avanzada.
     */
    public record Transaction(String user, BigDecimal amount, Type type, LocalDateTime timestamp) {
        
        // Constructor compacto para validar datos
        public Transaction {
            Objects.requireNonNull(user, "User cannot be null");
            Objects.requireNonNull(amount, "Amount cannot be null");
            Objects.requireNonNull(type, "Type cannot be null");
            Objects.requireNonNull(timestamp, "Timestamp cannot be null");

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
        }

        // Métodos de fábrica estáticos
        public static Transaction deposit(String user, BigDecimal amount) {
            return new Transaction(user, amount, Type.DEPOSIT, LocalDateTime.now());
        }

        public static Transaction withdrawal(String user, BigDecimal amount) {
            return new Transaction(user, amount, Type.WITHDRAWAL, LocalDateTime.now());
        }

        // Método adicional con lógica de negocio
        public BigDecimal applyFee() {
            BigDecimal feeRate = switch (type) {
                case DEPOSIT -> BigDecimal.ZERO;
                case WITHDRAWAL -> new BigDecimal("0.02"); // 2% de comisión en retiros
            };
            return amount.multiply(feeRate);
        }

        // Enum anidado dentro del record
        public enum Type {
            DEPOSIT, WITHDRAWAL
        }
    }