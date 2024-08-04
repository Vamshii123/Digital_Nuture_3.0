public class DependencyInjectionExample {

    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);
        
        // Use the service to get a customer
        Customer customer = customerService.getCustomerById(1);
        System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
    }

    // Repository Interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Concrete Repository Implementation
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Dummy implementation for demonstration
            return new Customer(id, "John Doe");
        }
    }

    // Service Class
    static class CustomerService {
        private final CustomerRepository customerRepository;

        // Constructor injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Customer Class
    static class Customer {
        private final int id;
        private final String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
// File: src/main/java/DependencyInjectionExample.java

public class DependencyInjectionExample {

    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);
        
        // Use the service to get a customer
        Customer customer = customerService.getCustomerById(1);
        System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
    }

    // Repository Interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Concrete Repository Implementation
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Dummy implementation for demonstration
            return new Customer(id, "John Doe");
        }
    }

    // Service Class
    static class CustomerService {
        private final CustomerRepository customerRepository;

        // Constructor injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Customer Class
    static class Customer {
        private final int id;
        private final String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}