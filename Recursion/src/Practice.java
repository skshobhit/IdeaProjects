public class Practice {
    public static int factorial(int n) {
        if (n < 0) {
            return -1;

        }
        if (n == 0) {
            return 1;
        }
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;

    }
    public static long fact(int n){
        if (n==0 || n==1){
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }
    public static int length(String s) {
        if(s.equals("")){
            return 0;
        }else{
            return 1 + length(s.substring(1));
        }
    }


    public static void main(String[] args) {
        System.out.println(fact(10));
        printChars("hello");
        System.out.println(power(2,7));
        int[] arr = {1,2,3,4,6,7,9,20,50};
        System.out.println(linearsearch(arr,100));

    }
    public static void printChars(String s) {
        if (s.equals("")){
            System.out.println("");

        }else{
            System.out.println(s.charAt(0));
            printChars(s.substring(1));

        }
    }
    public static int summation(int n){
        if (n<=0){
            return 0;
        }
        return n + summation(n-1);
    }
    public static double power(double base, int exp) {
        if (exp == 0 ) {
            return 1;
        }else if (exp<0){
            return 1.0/power(base, exp*-1);

        } else{
            return power(base,exp-1)* base;
        }
    }
    public static int gcd(int bigger, int smaller){
        if (bigger < smaller){
            return gcd(smaller,bigger);
        }
        if (bigger % smaller==0){
            return smaller;
        } else{
            return gcd(smaller, bigger % smaller);

        }
    }
    public static int linearsearch(int[] arr, int target){
        int loc = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== target){
                return i;
            }

        }
        return -1;
    }
    private static int linearserarch(int [] arr, int target, int index){
        if (index >= arr.length){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }
        return linearserarch(arr, target, index+1);
    }
}