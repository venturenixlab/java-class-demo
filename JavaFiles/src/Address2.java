import java.util.function.Predicate;

public class Address2 {
  private static final int MAX_ADDRESS_LINE_LENGTH = 30;

  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String cityCode;
  private String countryCode;

  public Address2(String addressLine1, String addressLine2, String addressLine3, String cityCode, String countryCode) {
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.addressLine3 = addressLine3;
    this.cityCode = cityCode;
    this.countryCode = countryCode;
  }

  public Address2() {
  }

  public boolean isAddressLineValid() {
    // if(!checkSymbol(addressLine1)||!checkSymbol(addressLine2)||!checkSymbol(addressLine3)){
    // return false;
    // }

    // if (addressLine1.length() <= 30 && addressLine2.length() <= 30 &&
    // addressLine3.length() <= 30) {
    // return true;
    // } //
    // return false;
    Predicate<String> isAddressLineValid = e -> {
      if (e == null || e.length() <= MAX_ADDRESS_LINE_LENGTH)
        return true;
      return false;
    };
    if (isAddressLineValid.test(this.addressLine1)
        && isAddressLineValid.test(this.addressLine2)
        && isAddressLineValid.test(this.addressLine3)) {
      return true;
    }
    return false;
  }

  public String getCityCode() {
    return this.cityCode;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public String getAddressLine1() {
    return this.addressLine1;
  }

  public String getAddriessLin2() {
    return this.addressLine2;
  }

  public String getAddressLine3() {
    return this.addressLine3;
  }

  public Address2 setCityCode(String cityCode) {
    this.cityCode = cityCode;
    return this;
  }

  public Address2 setCountryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  public Address2 setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public Address2 setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public Address2 setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  // private boolean checkSymbol(String address){
  // if (address==nul)return true;
  // return Pattern.matches("^[a-zA-Z0-9 ]+$", address);
  // }

  public void printStatus() {
    System.out.print("Address: " + this.addressLine1 + ", " + this.addressLine2 + ", " + this.addressLine3
        + "\nCity code " + this.cityCode + "\nCountry Code: " + this.countryCode);
  }

  public static void main(String[] args) {
    Address2 address = new Address2("Flat A", "Blk 2", "Sheung Wan", "HK", "852");
    Address2 addressForTest = new Address2(null, null, null, "HK", "852");
    Address2 address1 = new Address2();
    address1.setAddressLine1("Hell").setAddressLine2("666");

    if (address.isAddressLineValid())
      address.printStatus();
    if (addressForTest.isAddressLineValid())
      address.printStatus();
    if (address1.isAddressLineValid())
      address.printStatus();

  }
}

class Client {
  Address2 address;
  String name;
}
