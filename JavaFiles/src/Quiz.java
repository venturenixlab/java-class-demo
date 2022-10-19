// Question 1
class Password{
  private String password;

  Password(String x){
    this.password = x;
  }
}

class Quiz {
  public static void main(String[] args) {
    Password p1 = new Password("ABC");
    Password p2 = new Password("ABC");
    Password p3 = new Password("BCD");
    String s1 = new String("abc");
    
    System.out.print(p1 == p2);
    System.out.print(p2 == p3);
    System.out.print(p1.equals(p2));
    System.out.print("abc".equals(s1));
  }
}
/**
What is the output?
A: truefalsetruetrue
B: falsefalsefalsetrue
C: falsefalsetruetrue
D: truefalsetruefalse
E：falsefalsefalsefalse
*/