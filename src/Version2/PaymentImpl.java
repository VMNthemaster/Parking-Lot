package Version2;

public class PaymentImpl implements PaymentInterface {

    private static int totalAmount;

    static {
        totalAmount = 0;
    }

    public void payTicket(int ticketValue) {
        totalAmount += ticketValue;
    }

    public static int getTotalAmount() {
        return totalAmount;
    }
}
