// Builder Pattern 建造者模式
class Customer {
  static int counter = 0;
  int age;
  String name;

  public Customer() {
    Customer.counter++;
  };

  // Private Constructor
  private Customer(Builder builder) {
    this.age = builder.age;
    this.name = builder.name;
    Customer.counter++;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "[age=" + this.age + ", name=" + this.name + "]";
  }

  // Static Class
  public static class Builder {
    int age;
    String name;

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Customer build() {
      return new Customer(this);
    }
  }
}


class DemoBuilderPattern {
  public static void main(String[] args) {
    // builder pattern to create Customer Instance
    Customer customer = Customer.builder().age(13).name("Tommy").build();
    System.out.println(customer.toString());
    // Normal way to create Custome Instance
    Customer customer2 = new Customer();
    customer2.setAge(3);
    customer2.setName("Mary");
    System.out.println(customer2.toString());

    System.out.println("No of customer created: " + Customer.counter);

  }
}
