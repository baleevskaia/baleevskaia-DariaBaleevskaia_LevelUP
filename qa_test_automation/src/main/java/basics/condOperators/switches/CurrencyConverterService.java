package basics.condOperators.switches;

import java.math.BigDecimal;

public class CurrencyConverterService {

    public BigDecimal convertToRubles(CurrencyCode currencyFrom, BigDecimal amount) {
        switch (currencyFrom) {
            case USD:
                return amount.multiply(new BigDecimal("76"));
            case EUR:
                return amount.multiply(new BigDecimal("91"));
            default:
                throw new IllegalArgumentException("Unsupported currency " + currencyFrom);
        }
    }
}
