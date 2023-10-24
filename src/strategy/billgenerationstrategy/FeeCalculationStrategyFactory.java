package strategy.billgenerationstrategy;

public class FeeCalculationStrategyFactory {

    private FeeCalculationStrategy feeCalculationStrategy;

    public FeeCalculationStrategy getFeeCalculationStrategy()
    {
        return new LowFeeCalculationStrategy();
    }
}
