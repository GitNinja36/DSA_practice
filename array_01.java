// import java.util.*;

public class array_01 {
    public static void update(int marks[], int n){
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + n;
        }
    }

    public static void print(int marks[]) {
        System.out.print("Array elements: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("[" + marks[i] + "] ");
        }
        System.out.println();
    }

    public static void linearSearch(int marks[], int key) {
        for(int i = 0; i< marks.length; i++){
            if(marks[i] == key){
                System.out.print("key is at :" + marks[i]);
            }
        }
        System.out.print("there is no key in array");
    }
   
    public static void getLargestValue(int marks[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<marks.length; i++){
            if(largest <= marks[i]){
                largest = marks[i];
            }
        }
        System.out.println("largest value in the array is : "+largest);
    }
       
    public static void getSmallestValue(int marks[]) {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i<marks.length; i++){
            if(smallest >= marks[i]){
                smallest = marks[i];
            }
        }
        System.out.println("smallest value in the array is : "+smallest);
    }
    
    public static int binarySearch(int array[], int key) {
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(array[mid] == key){
                return mid;
            } 
            if(array[mid] < key){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverse(int array[]) {
        int first = 0;
        int last = array.length - 1;
        while(first < last){
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first++;
            last--;
        }
    }

    public static void printPairs(int array[]) {
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                System.out.print("("+ array[i] +", " + array[j] + ")");
            }
            System.out.println();
        }
    }

    public static void printSubArray(int array[]) {
        int ts =0;
        int MaxSubArrayValue = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            int start = i;
            for(int j = i; j < array.length; j++){
                int end = j;
                int totalSumSubArray = 0;
                for(int k = start; k<=end; k++){
                    totalSumSubArray = totalSumSubArray + array[k];
                    if(MaxSubArrayValue < totalSumSubArray){
                        MaxSubArrayValue = totalSumSubArray;
                    }
                    System.out.print(array[k]+ " ");
                    // System.out.print(totalSumSubArray + " ");
                }
                ts++;
                System.out.println();
            }
        }
        System.out.print("total sub array "+ ts);
        System.out.print("total Max Sub Array Value "+ MaxSubArrayValue);
    }

    public static void prefixSubArray(int array[]) {
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[array.length];

        //calculate preficx array
        prefix[0]= array[0];
        for (int i = 1; i< prefix.length; i++){
            prefix[i] = prefix[i-1] + array[i];
        }

        for(int i = 0; i < array.length; i++){
            int start = i;
            for(int j = i; j < array.length; j++){
                int end = j;
                curr = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if(maxSum < curr){
                    maxSum = curr;
                }
            }
        }
        System.out.print("maximum sum : "+ maxSum);
    }

    public static void kadaneArray(int array[]) {
        int arrayValue = 0;
        for(int i = 0; i < array.length; i++){
            arrayValue = arrayValue + array[i];
        }
        if(arrayValue < 0){
        System.out.print("Max subarray sum is : " + arrayValue);
        }
        else{
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i = 0; i < array.length; i++){
            cs = cs + array[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.print("Max subarray sum is : " + ms);
        }
    }

    public static void trappingRainWater(int height[]) {
        int n = height.length;
        int width = 1;
        int trappedWater = 0;
        int LH[] = new int[n];
        int RH[] = new int[n];

        //for left Height
        LH[0] = height[0];
        for(int a = 1; a < n; a++){
            LH[a] = Math.max(height[a], LH[a-1]);
        }

        //for Right Height
        RH[n-1] = height[n-1];
        for(int b = n-2; b >= 0; b--){
            RH[b] = Math.max(height[b], RH[b+1]);
        }

        //now to calculate the Trapped water
        for (int c = 1; c < n-1; c++){
            trappedWater = trappedWater + (((Math.min(RH[c], LH[c])) - height[c]) * width);
        }
        for(int d =0; d<n; d++){
            System.out.print(LH[d] + " ");
        }
        System.out.println();
        for(int e =0; e<n; e++){
            System.out.print(RH[e] + " ");
        }
        System.out.println();
        System.out.print("Total water trapped : " + trappedWater);
    }

    public static void buyAndSellStocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < price.length; i++){
            if( buyPrice < price[i]){
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            }else{
                buyPrice = price[i]; 
            }
        }
        System.out.print("Maximum profit : " + maxProfit);
    }

    public static void insertionShort(int arr[]) {
        int n = arr.length;
        for(int i = 1 ; i < n; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && prev > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = arr[curr];
        }
    }

    public static void countingShort(int arr[]) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i = 0; i < largest; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0; i < n; i++){
            while(count[i] > 0){
                arr[j] = count[i];
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the size of the array (n): ");
        // int n = sc.nextInt();

        // int marks[] = new int[n];

        // for (int i = 1; i < n; i++) {
        //     marks[i] = i;
        // }
        int number[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr[] = {-1, -2, -3, -4, -5};
        int array[] = {4, 2, 0, 6, 3, 2, 5};
        int price[] = {7, 1, 5, 3, 6, 4};
        int height[] = {1,8,6,2,5,4,8,3,7};
        int test[] = {5,4,-1,7,8};
        int test2[] = {-2,1};
        // update(marks, 2);
        // print(marks);
        // linearSearch(marks, 4);
        // getLargestValue(marks);
        // getSmallestValue(marks);

        // int m = binarySearch(number, 8);
        // System.out.println(m);

        // reverse(number);
        // printPairs(number);
        // printSubArray(number);
        // print(number);
        // prefixSubArray(number);
        // kadaneArray(number);
        // kadaneArray(test);
        // kadaneArray(test2);
        // trappingRainWater(array);
        // buyAndSellStocks(price);
        // trappingRainWater(height);
        // prefixSubArray(test);
        printPairs(number);
    }
}
