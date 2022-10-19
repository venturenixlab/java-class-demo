public class DemoRecursion {

  public static int sum(int x) {
    // base condition to exit
    if (x <= 1) { // 1.2
      return 1; //
    }
    return sum(x - 1) + sum(x - 2); // 1.1 -> sum(3-1)+sum(3-2)
  }

  public static int getEvenNumberMultiplier(int x) {
    // if x = 10, return 2 * 4 * 6 * 8 * 10
    // if x = 6, return 2 * 4 * 6
    // if x = 20, return 2 * 4 * ... * 20
    // if x = 19, return 2 * 4 * ... * 18
    // if x = 1, return 0
    // where x >= 2
    if (x <= 1) {
      return 0;
    }
    // int v = x % 2 == 0 ? x : x - 1;
    int v;
    if (x % 2 == 0) {
      v = x;
    } else {
      v = x - 1;
    }

    if (v == 2) {
      return 2;
    }
    return v * getEvenNumberMultiplier(v - 2);
  }

  public static String reverseString(String s) {
    // if s = "ABC", return "CBA"
    // if s = "AC D", return "D CA"
    // if s = " A B ", return " B A "
    // if s = "", return ""
    // if s = null, return null
    // tips: s.length()
    // tips: if s = "ABCD", s.subString(1,3) = "BC"
    // tips: if s = "ABCD", s.substring(3, 4) = "D"
    if (s == null) {
      return null;
    }
    if (s.length() <= 1) {
      return s;
    }
    return s.substring(s.length() - 1, s.length()) + reverseString(s.substring(0, s.length() - 1));
  }

  static final Integer[] integers = new Integer[] { 1, 3, 4, 7, 7, 11 };

  public static void findTheFirstEvenNumber(int x) {
    if (x < integers.length && integers[x] % 2 == 0) {
      System.out.println("The even number is: " + integers[x]);
      return;
    } else if (x > integers.length - 1) {
      return;
    }
    findTheFirstEvenNumber(x + 1);

    System.out.println("No even number is found starting from index:" + x);
  }

  public static void main(String[] args) {
    System.out.println(DemoRecursion.sum(4));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(6));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(5));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(4));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(3));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(2));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(1));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(0));
    System.out.println("Multiplier=" + DemoRecursion.getEvenNumberMultiplier(-1));
    DemoRecursion.findTheFirstEvenNumber(0);
    DemoRecursion.findTheFirstEvenNumber(1);
    DemoRecursion.findTheFirstEvenNumber(2);
    DemoRecursion.findTheFirstEvenNumber(3);
    DemoRecursion.findTheFirstEvenNumber(4);
    DemoRecursion.findTheFirstEvenNumber(5);
    System.out.println(DemoRecursion.reverseString("ABCD"));
  }
}
