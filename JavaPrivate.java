interface JavaPrivate {
    public abstract void multiply(int a,int b);

    public  default void addition(int a,int b){
        subtraction(a,b);
        division(a,b);
        System.out.println("Default Method Answer");
        System.out.println(a + b);
    }
    public static void modulus(int a,int b){
        division(a,b);
        System.out.println("Static method answer");
        System.out.println(a % b);
    }
    private void subtraction(int a,int b){
        System.out.println("Private Method");
        System.out.println(a-b);
    }
    private static void division(int a,int b){
        System.out.println("Private Static Method");
        System.out.println(a/b);
    }

}
