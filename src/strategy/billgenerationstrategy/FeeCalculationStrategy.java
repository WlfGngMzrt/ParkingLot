package strategy.billgenerationstrategy;

import models.Ticket;

public interface FeeCalculationStrategy {
    long getFeeAmount(Ticket ticket);
}
