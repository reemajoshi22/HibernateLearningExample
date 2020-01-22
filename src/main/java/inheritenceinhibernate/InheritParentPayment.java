package inheritenceinhibernate;

/**
 * 1.in table per class hierarchy all the data is saved in a single table
 *
 *
 * 2. Table per sub class :
 * If we save the CreditCard class object, then first hibernate will
 * saves the data related to super class object into the super class related
 * table in the database and then CreditCard object data in
 * CreditCard related table in the database, so first base class data will be saved
 *
 * 3. Table Per Concrete Class -
 * Once we save the derived class object, then derived
 * class data and base class data will be saved in the derived class
 * related table in the database
 * for this type we need the tables for derived classes, but not for the base class
 * in the mapping file we need to use one new element
 * <union-subclass — >under <class —>
 */
public class InheritParentPayment {
	private int paymentId;
	private double amount;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
