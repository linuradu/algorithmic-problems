package nitrovery.statistics;

import java.util.Comparator;

public class CustomerInvoiceComparator implements Comparator<CustomerInvoice> {

    @Override
    public int compare(CustomerInvoice o1, CustomerInvoice o2) {
        return o1.getSum().compareTo(o2.getSum());
    }
}
