package S_O;

public class Invoice {
	Pen pen;

	public Invoice(Pen pen) {
		// TODO Auto-generated constructor stub
		this.pen = pen;
	}

	public int CreateInvoice() {
		return (int) ((pen.price) * 1.18) + 2;
	}

//	public void SendMail() {
//		System.out.println("Sending Gmail");
//
//	}

//	public void print() {
//		System.out.println("Printing Invoice");
//
//	}

}
