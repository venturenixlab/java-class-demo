
class DemoFibonacci {
    static void printFun(int test) {
        if (test < 1) {
            return;
        }
        System.out.printf("%d ", test);
        printFun(test - 1);
        System.out.printf("%d ", test);
        return;
    }

    public static void main(String[] args) {
        printFun(3);
    }
}