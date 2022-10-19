import java.util.ArrayList;
import java.util.Arrays;

public class DemoArrayList {
  public static void main(String[] args) {

    String[] colorsArray = new String[3];
    colorsArray[0] = "Red";
    colorsArray[1] = "Green";
    colorsArray[2] = "Blue";
    System.out.println("Original Array:" + Arrays.toString(colorsArray));
    System.out.println("Original Array:" + colorsArray);

    ArrayList<String> strings = new ArrayList<>();
    strings.add("ABC");
    strings.add("BCD");
    strings.add("BCDE");
    System.out.println(strings.toString());
    System.out.println(strings);
    
  }
}
