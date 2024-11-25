package Exception_Code;

class ExShowDivide {
    public static void division(final int sum, final int amount) {
        System.out.println("Computing a division.");
        System.out.println("Avg = " + sum / amount);
    }

    public static void main(final String[] args) {
        division(100,4);
        division(100,0);
        System.out.println("Exit main().");
    }
}
