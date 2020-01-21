package inheritenceinhibernate;

public class InheritChildCheque extends InheritParentPayment{
	private String ChequeType;

	public String getChequeType() {
		return ChequeType;
	}

	public void setChequeType(String chequeType) {
		ChequeType = chequeType;
	}
}
