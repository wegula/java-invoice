package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {

		if (name == null || price == null || name.isEmpty() || price.compareTo(BigDecimal.ZERO)<0){
			throw new IllegalArgumentException("Product name or value cannot be null or empty");
		}
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {

		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {

		return this.price.add(this.price.multiply(this.taxPercent));
	}
}
