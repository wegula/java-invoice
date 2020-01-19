package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

	private Map <Product, Integer> productsWithQuantity = new HashMap<>();

	public void addProduct(Product product) {
		productsWithQuantity.put(product,1);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity == 0 || quantity<0){
			throw new IllegalArgumentException("Quantity cannot be equal or lower than 0");
		}
		productsWithQuantity.put(product, quantity);
	}

	public BigDecimal getSubtotal() {

		BigDecimal subTotal = new BigDecimal(0);
		for (Product product : productsWithQuantity.keySet()){
			subTotal=subTotal.add(product.getPrice().multiply(BigDecimal.valueOf(productsWithQuantity.get(product))));
		}
		return subTotal;
	}

	public BigDecimal getTax() {

		BigDecimal taxValue = new BigDecimal(0);
		for (Product product : productsWithQuantity.keySet()){
			taxValue=taxValue.add(product.getTaxPercent().multiply(product.getPrice().multiply(BigDecimal.valueOf(productsWithQuantity.get(product)))));
		}
		return taxValue;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Product product : productsWithQuantity.keySet()){
			total=total.add(product.getPriceWithTax().multiply(BigDecimal.valueOf(productsWithQuantity.get(product))));
		}
		return total;
	}
}
