package inheritenceinhibernate;

/**
 * Hibernate supports 3 types of Inheritance Mappings:
 *
 * 1. Table per class hierarchy - one table will be created
 * 2. Table per sub-class hierarchy -- first hibernate will saves the data related to super class object into the super class related table in the database and then CreditCard object data in CreditCard
 * related table in the database, so first base class data will be saved
 * 3. Table per concrete class hierarchy
 *
 * If we save the derived class object like
 * CreditCard or Cheque then automatically Payment class object will also be saved into the database
 *  and in the database all the data will be stored into a single table only, which is base class table for sure.
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
