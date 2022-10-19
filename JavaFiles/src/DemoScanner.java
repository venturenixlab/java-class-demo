import java.util.Scanner;

public class DemoScanner {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Input something here:");
    String s = scan.nextLine();
    System.out.println("String: " + s);
  }
}