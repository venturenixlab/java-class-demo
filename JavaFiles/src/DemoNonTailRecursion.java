import java.util.HashMap;

class DemoNonTailRecursion {
  static HashMap<Integer, Customer> customerMap;
  static int CustomerId;

  static {
    customerMap = new HashMap<>();
    // in real case, we can call api to get customer and order data
    customerMap.put(++CustomerId, new Customer("Sunny", 24, "sunny123@gmail.com"));
    customerMap.put(++CustomerId, new Customer("Owie", 23, "owie@gmail.com"));
    customerMap.put(++CustomerId, new Customer("Peter", 25, "peter@gmail.com"));
  }

  public static void confirmOrder(HashMap<Integer, Customer> hashMap) {
    // base condition
    if (hashMap.size() <= 0) {
      return;
    }
    // HashMap<Integer, Customer> shallowCopy = new HashMap<>();
    // shallowCopy.putAll(hashMap);
    // Remove top customer in Hashmap for recursive use
    // Process lockInventory step and sendOrderConfirmEmail
    Customer customer = (Customer) hashMap.remove(hashMap.size());
    // Lock Inventory
    lockInventory(customer.getName());
    // non-tail recursive
    confirmOrder(hashMap); // pass by object reference
    // Send email to customer
    if (customer.isValidEmail()) {
      sendOrderConfirmEmail(customer.getEmail());
    }
  }

  public static void lockInventory(String emailAddr) {
    System.out.println("Lock the Quantity in Inventory ... Customer: " + emailAddr);
  }

  public static void sendOrderConfirmEmail(String emailAddr) {
    System.out.println("Sending email to ... " + emailAddr);
  }

  public static void main(String[] args) {
    DemoNonTailRecursion.confirmOrder(customerMap);
  }
}