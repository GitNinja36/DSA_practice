public class bit {

    public static boolean isOdd(int num) {
        return ((num & 1) == 1);
    }

    public static int getIthBit(int num, int i) {
        if((num | (1 << i)) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearIthBit(int num, int i) {
        return num & (~(1 << i));
    }

    public static int updateIthBit(int num, int i, int newBit){
        if(newBit == 0){
            return clearIthBit(num, i);
        }else{
            return setIthBit(num, i);
        }
    }
    
    public static int clearLastIthBit(int num, int i){
        return (num & ((~0) << i));
    }

    public static int clearRangeIthBit(int num, int i, int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        return num & (a|b);
    }

    public static boolean isPowerOfTwo(int num){
        return (num&(num-1)) == 0;
    }

    public static int countSetBit(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count ++;
            }
            n = n >> 1; 
        }
        return count;
    }
    
    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n > 0){
            if((n & 1) != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1; 
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(isOdd(8));
        // System.out.println(getIthBit(9, 3));
        System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIthBit(15, 2));
        // System.out.println(clearRangeIthBit(10, 2, 4));
        // System.out.println(isPowerOfTwo( 16));
        // System.out.println(countSetBit(15));
        // System.out.println(fastExpo(5, 3));
    }
}
