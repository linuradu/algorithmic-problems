package nitrovery.statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MostExpensiveInvoices {
    public static CustomerInvoiceComparator comparator = new CustomerInvoiceComparator();

    public static void main(String[] args) {
        String filePath = "main/resources/customer_invoices.txt";
        List<CustomerInvoice> customerInvoices = readCustomerInvoicesFormFile(filePath);
        customerInvoices.sort(comparator.reversed());

        customerInvoices.forEach(customerInvoice -> {
            System.out.println(customerInvoice.getCustomerName() + ": " + customerInvoice.getSum());
        });
    }

    private static List<CustomerInvoice> readCustomerInvoicesFormFile(String filePath) {
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        final List<CustomerInvoice> customerInvoices = new ArrayList<>();

        try {
//            final InputStream is2 = new FileInputStream(new File(""));

//            BufferedReader br = new BufferedReader(new FileReader(filePath));
            final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf8"), 100);

            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                CustomerInvoice customerInvoice = new CustomerInvoice(Long.parseLong(splitLine[0]), splitLine[1], Double.parseDouble(splitLine[2]));
                customerInvoices.add(customerInvoice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerInvoices;
    }

    private static void readJava8FormFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
