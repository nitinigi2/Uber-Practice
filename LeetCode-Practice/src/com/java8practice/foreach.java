package src.com.java8practice;

import java.util.ArrayList;
import java.util.List;

public class foreach {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            customers.add(new Customer(i, "abc" + i));
        }

        customers.forEach(customer -> System.out.println(customer));
    }

}

class Customer {
    private int id;
    private String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
