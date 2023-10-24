package strategy.billgenerationstrategy;

import models.Ticket;

public class LowFeeCalculationStrategy implements FeeCalculationStrategy{



    @Override
    public long getFeeAmount(Ticket ticket) {
        return 0;
    }
}
