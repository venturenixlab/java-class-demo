import java.util.Arrays;

class DemoTailRecursion {
  static final char[] chars = new char[] { 'a', 'b', 'c', 'd', 'e' };

  public static int indexOf(char[] chars, char s) {
    // base condition
    if (chars[chars.length - 1] == s) {
      return chars.length - 1;
    }
    // recursive
    return indexOf(Arrays.copyOfRange(chars, 0, chars.length - 1), s);
  }

  public static void main(String[] args) {
    System.out.println(DemoTailRecursion.indexOf(chars, 'd')); // print 3
  }
}