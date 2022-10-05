enum Direction {
  NORTH(1, 'N', "it is North"),
  EAST(2, 'E', "it is East"),
  SOUTH(-1, 'S', "it is South"),
  WEST(-2, 'W', "it is West");

  private int code;
  private char dbValue;
  private String description;

  private Direction(int code, char dbValue, String description) {
    this.code = code;
    this.dbValue = dbValue;
    this.description = description;
  }

  public int getCode() {
    return this.code;
  }

  public char getDbValue() {
    return this.dbValue;
  }

  public String getDescription() {
    return this.description;
  }

  public Direction opposite() {
    return Direction.get(this.code * -1);
  }

  public static boolean isOpposite(Direction d1, Direction d2) {
    return d1.getCode() * -1 == d2.getCode();
  }

  public static Direction get(int code) {
    for (Direction d : values()) {
      if (d.code == code)
        return d;
    }
    // return null;
    throw new IllegalArgumentException(
        "Cannot parse into an element of Direction by code : '" + code + "'");
  }

  public static Direction get(char dbValue) {
    for (Direction d : values()) {
      if (d.dbValue == dbValue)
        return d;
    }
    // return null;
    throw new IllegalArgumentException(
        "Cannot parse into an element of Direction dbValue: '" + dbValue + "'");
  }
}

public class DemoEnum {
  public static void main(String[] args) {
    System.out.println(Direction.get('N')); // print NORTH
    System.out.println(Direction.get(-1)); // print SOUTH
    System.out.println(Direction.WEST.opposite()); // print EAST
    System.out.println(Direction.isOpposite(Direction.SOUTH, Direction.NORTH)); // print true
    System.out.println(Direction.isOpposite(Direction.SOUTH, Direction.EAST)); // print false
    System.out.println(Direction.valueOf("NORTH")); // print enum Direction.NORTH
    System.out.println(Direction.NORTH); // print enum Direction.NORTH
    System.out.println(Direction.NORTH.name()); // print enum Direction.NORTH
  }
}
