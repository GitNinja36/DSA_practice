public class short_01 {
    // Bubble Short
    public static void bubbleShort(int array[]) {
        for(int turn = 0; turn < array.length-1; turn++){
            for(int j=0; j < array.length-turn-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.print("Bubble Short : ");
        System.out.print("[ ");
        for(int i = 0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
        System.out.print("]");
        System.out.println();
    }

    // Selection Short
    public static void selectionShort(int array[]) {
        for(int i = 0; i < array.length-1; i++){
            int minPos = i;
            for(int j = i+1; j < array.length; j++){
                if(array[minPos] > array[j]){
                    minPos = j;
                }
            }
            int temp  = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }
        System.out.print("Selection Short : ");
            System.out.print("[ ");
        for(int i = 0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
            System.out.print("]");
        System.out.println();
    }

    // Insertion Short
    public static void insertionShort(int array[]) {
        for(int i =1; i< array.length; i++){
            int curr = array[i];
            int prev = i-1;
            while (prev >= 0 && array[prev] > curr) {
                array[prev+1] = array[prev];
                prev--;
            }
            array[prev+1] = curr;
        }
        System.out.print("Insertion Short : ");
            System.out.print("[ ");
        for(int i = 0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
            System.out.print("]");
        System.out.println();
    }

    // Counting Short
    public static void countingShort(int array[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            largest = Math.max(largest, array[i]);
        }
        int count[] = new int[largest+1];
        for(int i = 0; i<array.length; i++){
            count[array[i]]++;
        }
        int j =0;
        for(int i = 0; i<count.length; i++){
            while (count[i] > 0) {
                array[j] = i;
                j++;
                count[i]--;
            }
        }
        System.out.print("Counting Short : ");
            System.out.print("[ ");
        for(int i = 0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
            System.out.print("]");
        System.out.println();
    }


    public static void main(String[] args) {
        int array[] = {5, 4, 3, 2, 1}; 
        bubbleShort(array);
        selectionShort(array);
        // insertionShort(array);
        // countingShort(array);
    }
}
