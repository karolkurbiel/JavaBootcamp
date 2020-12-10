package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

class Log implements Comparable<Log>{
    private final LocalDateTime timeMarker;
    private final OperationType operationType;
    private final BigDecimal balanceBefore;
    private final BigDecimal balanceAfter;
    private final BigDecimal debtLimitBefore;
    private final BigDecimal debtLimitAfter;

    public Log(OperationType operationType, BigDecimal balanceBefore, BigDecimal balanceAfter) {
        this.timeMarker = LocalDateTime.now();
        this.operationType = operationType;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;

        this.debtLimitBefore = null;
        this.debtLimitAfter = null;

    }

    public Log(OperationType operationType, BigDecimal balanceBefore, BigDecimal balanceAfter, BigDecimal debtLimitBefore, BigDecimal debtLimitAfter) {
        this.timeMarker = LocalDateTime.now();
        this.operationType = operationType;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.debtLimitBefore = debtLimitBefore;
        this.debtLimitAfter = debtLimitAfter;
    }

    public LocalDateTime getTimeMarker() {
        return timeMarker;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public BigDecimal getBalanceBefore() {
        return balanceBefore;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public BigDecimal getDebtLimitBefore() {
        return debtLimitBefore;
    }

    public BigDecimal getDebtLimitAfter() {
        return debtLimitAfter;
    }

    @Override
    public String toString() {
        return "Log{" +
                "timeMarker=" + timeMarker +
                ", OPERATION_TYPE=" + operationType +
                ", balanceBefore=" + balanceBefore +
                ", balanceAfter=" + balanceAfter +
                ((debtLimitBefore != null && debtLimitAfter != null) ? (", debtLimitBefore=" + debtLimitBefore + ", debtLimitAfter=" + debtLimitAfter) : ("") ) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(timeMarker, log.timeMarker) &&
                operationType == log.operationType &&
                Objects.equals(balanceBefore, log.balanceBefore) &&
                Objects.equals(balanceAfter, log.balanceAfter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeMarker, operationType, balanceBefore, balanceAfter);
    }

    @Override
    public int compareTo(Log o) {
        return o.getTimeMarker().compareTo(this.getTimeMarker());
    }
}
