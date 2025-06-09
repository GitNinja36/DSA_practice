import java.util.*;

public class Matrices {
    public static int[][] makeArray(int len) {
        int matrices[][] = new int[len][len];
        int n = matrices.length;
        int m = matrices[0].length;
        System.out.print("Enter the value : ");
        Scanner sc = new Scanner(System.in);
        // input 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrices[i][j] = sc.nextInt();
            }
        }
        return matrices;
    }

    public static void printArray(int Matrix[][]) {
        int n = Matrix.length;
        int m = Matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean Search(int Matrix[][], int key) {
        int n = Matrix.length;
        int m = Matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (key == Matrix[i][j]) {
                    System.out.println("found the element at : (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void spiralMatrix(int Matrix[][]) {
        int startRow = 0;
        int stratCol = 0;
        int endRow = Matrix.length - 1;
        int endCol = Matrix[0].length - 1;

        while(startRow <= endRow && stratCol <= endCol){
            //top
            for(int i = stratCol; i <= endCol; i++){
                System.out.print(Matrix[startRow][i]+ " ");
            }
            //Right
            for(int i = startRow+1; i <= endRow; i++){
                System.out.print(Matrix[i][endCol]+ " ");
            }
            //bottom
            for(int i = endCol-1; i >= stratCol; i--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(Matrix[endRow][i]+ " ");
            }
            //left
            for(int i = endRow - 1; i >= startRow + 1; i--){
                if(stratCol == endCol){
                    break;
                }
                System.out.print(Matrix[i][stratCol]+ " ");
            }
            //updation of row and col
            startRow++;
            stratCol++;
            endCol--;
            endRow--;
        }
    }

    public static int diagonalSum(int Matrix[][]) {
        int sum = 0;
        int n = Matrix.length - 1;

        //O[n^@2]
        // for(int i = 0; i < Matrix.length; i++){
        //     for(int j = 0; j < Matrix[0].length; j++){
        //         if( i == j){
        //             sum +=  Matrix[i][j];
        //         }
        //         else if( i + j == n){
        //             sum += Matrix[i][j];
        //         }
        //     }
        // }

        //O[n]
        for(int i = 0; i < Matrix.length; i++){
            //primary diagonal
            sum += Matrix[i][i];
            //secondary diagonal
            if( i != n-i){
                sum += Matrix[i][n-i];
            }
        }
        return sum;
    }

    public static void stairCaseSearch(int Matrix[][], int key) {
        int row = 0;
        int col = Matrix[0].length - 1;
        while(row < Matrix.length && col >= 0){
            if(Matrix[row][col] == key){
                System.out.println("key "+ key+" has been found at : (" + row +", " + col + ")");
                break;
            }
            else if(Matrix[row][col] > key){
                col--;
            }
            else if(Matrix[row][col] < key){
                row++;
            }
        }
        // System.out.println("key "+key+" dosen't found in the array");
    }


    public static void main(String[] args) {
        // System.out.print("Enter the array length : ");
        // Scanner sc = new Scanner(System.in);
        // int len = sc.nextInt();
        // int array[][] = makeArray(len);
        // printArray(array);
        // Search(array, 4);

        int matrix[][] ={
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16},
                        };
        int matrix1[][] ={
                            {10, 20, 30, 40},
                            {15, 25, 35, 45},
                            {27, 29, 37, 48},
                            {32, 33, 39, 50},
                        };
        // spiralMatrix(matrix);
        // System.out.println(diagonalSum(matrix));
        // stairCaseSearch(matrix1, 33);
        System.out.print(Search(matrix1, 49));
    }
}