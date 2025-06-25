package Strategy_Pattern;

public class ShoppingCart {
	private PaymentStrategy paymentstrategy;

	public void SetPaymentStrategy(PaymentStrategy paymentstrategy) {

		this.paymentstrategy = paymentstrategy;

	}

	public void checkout(int amount) {
		if (paymentstrategy == null) {
			System.out.println("paymentstrategy set kr bhai");
		}
		else {
			paymentstrategy.pay(amount);
		}
	}

}
