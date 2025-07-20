public class practiceRecursion { 

    public static int fab(int n){
        if(n == 1 || n == 0){
            return n;
        }
        return fab(n-1)+fab(n-2);
    }

    public static void main(String[] args) {
        System.out.print(fab(10));
    }
}