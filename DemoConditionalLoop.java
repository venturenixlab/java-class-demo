public class DemoConditionalLoop {
  public static void main(String[] args) {
    // 1. Overflow Concept
    // when i = -128, then i--, then i will become 127, but not -129
    // So, this loop will be infiinte
    // In Terminal, control + z to kill infiinte loop process
    for (byte i = 0; i < 128; i--) {
      System.out.println(i);
    }
    // 2. Loop with nested loop
    // The printing result should be i * j times
    for (int i = 0; i < 3; i++) {
      for (int j = 1; j <= 4; j++) {
        System.out.print(i + " " + j);
      }
    }
  }
}
