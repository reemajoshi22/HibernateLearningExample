package oneToManyBiderectional;

public class Customer {

    private int customerId;
    private String customerName;
    private int forevenId;
    private Vendor parentObjets;

    public Vendor getParentObjets() {
        return parentObjets;
    }

    public void setParentObjets(Vendor parentObjets) {
        this.parentObjets = parentObjets;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getForevenId() {
        return forevenId;
    }

    public void setForevenId(int forevenId) {
        this.forevenId = forevenId;
    }

}