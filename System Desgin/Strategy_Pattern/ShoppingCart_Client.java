package Strategy_Pattern;

public class ShoppingCart_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentStrategy p = new Card_payment();
		ShoppingCart cart = new ShoppingCart();
		cart.SetPaymentStrategy(p);
		cart.checkout(1000);
		cart.SetPaymentStrategy(new Paypal_Payment());
		cart.checkout(120);
		cart.SetPaymentStrategy(null);
		cart.checkout(120);

	}

}
