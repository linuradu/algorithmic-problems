package nitrovery.statistics;

public class CustomerInvoice {

    private Long id;
    private String customerName;
    private Double sum;

    public CustomerInvoice(Long id, String customerName, Double sum) {
        this.id = id;
        this.customerName = customerName;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
