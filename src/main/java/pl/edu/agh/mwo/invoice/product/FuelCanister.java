package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;
import pl.edu.agh.mwo.invoice.Invoice;

public class FuelCanister extends Product {
    public FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"), new BigDecimal("5.56"));
    }

    @Override
    public BigDecimal getPriceWithTax() {
        LocalDate currentDay = Invoice.getCurrentDate();
        final int year = LocalDate.now().getYear();
        final int month = 4;
        final int day = 26;
        LocalDate transportDay = LocalDate.of(year, month, day);
        if (currentDay.equals(transportDay)) {
            return getPrice().add(getExcise());
        } else {
            return super.getPriceWithTax();
        }
    }
}
