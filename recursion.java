import java.util.*;

public class recursion {
    public static void printDesc(int n) {
        if(n == 1){
            System.out.print(n); 
            return;
        } 
        System.out.print(n +" ");
        printDesc(n-1);
    }

    public static void printInsc(int n) {
        if(n == 1){
            System.out.print(n+" "); 
            return;
        } 
        printInsc(n-1);
        System.out.print(n +" ");
    }

    public static int factorial(int n) {
        if(n == 1){
            return 1;
        }
        return  n * factorial(n-1);
    }

    public static int sumN(int n) {
        if(n == 1){
            return 1;
        }
        return  n + sumN(n-1);
    }

    public static int fibonacci(int n) {
        if(n == 0 || n == 1 ){
            return n;
        }
        return  fibonacci(n-1) + fibonacci(n-2);
    }

    public static boolean isShorted(int arr[], int i) {
        if( i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isShorted(arr, i+1);
    }

    public static int firstOccurance(int arr[], int k, int i ) {
        if( i == arr.length-1){
            return -1;
        }
        if(arr[i] == k){
            return i;
        }
        return firstOccurance(arr, k, i+1);
    }

    public static int lastOccurance(int arr[], int k, int i ) {
        if( i == 0){
            return i;
        }
        if(arr[i] == k){
            return i;
        }
        return lastOccurance(arr, k, i-1);

    }

    public static int xPowerN(int x, int n) {
        if(n == 0){
            return 1;
        }
        int halfPow = xPowerN(x, n/2);
        int halfPowsq = halfPow * halfPow;
        if( n % 2 != 0){
            return x = x * halfPowsq;
        }
        return halfPowsq;
    }

    public static int tillingProblem(int n) {
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical choise
        int fnm1 = tillingProblem(n-1);
        //Horizontal choise
        int fnm2 = tillingProblem(n-2);
        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void remDuplicate(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr); 
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            remDuplicate(str, idx+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            remDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void printBinString(int n, int lastPlace, String str) {
        if( n == 0){
            System.out.println(str);
            return;
        }
        printBinString(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinString(n-1, 1, str+"1");
        }
    }

    public static int search(int[] arr, int target, int si, int ei){
        if( si > ei){
            return -1;
        }
        int m = si + (ei - si)/2;
        if(arr[m] == target){
            return m;
        }
        if(arr[m] > target){
            search(arr, target, si, m-1);
        }
        return search(arr, target, m+1, ei);
    }

    public static int sumOfDigit(int n){
        if(n == 0){
            return n;
        }
        return (n % 10) + sumOfDigit(n/10);
    }

    static int count(int n){
        return helper(n , 0);
    }
    private static int helper(int n, int c){
        if(n == 0){
            return c;
        } 
        int rem = n % 10;
        if(rem == 0){
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }

    public static boolean sorted(int[] arr, int index) {
        if(index == arr.length -1 ){
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }

    public static boolean find(int[] arr, int target, int index) {
        if(index == arr.length -1 ){
            return false;
        }
        return arr[index] == target || find(arr, target, index+1);
    }

    public static int findInRotatedArray(int[] arr, int target, int si, int ei) {
        if(si > ei){
            return -1;
        }
        int mid = si + (ei - si)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[si] <= arr[mid]){
            if(target >= arr[si] && target <= arr[mid]){
                return findInRotatedArray(arr, target, si, mid-1);
            }else{
                return findInRotatedArray(arr, target, mid+1, ei);
            }
        }
        if(target >= arr[mid] && target <= arr[ei]){
            return findInRotatedArray(arr, target, mid+1, ei);
        }
        return findInRotatedArray(arr, target, si, mid-1);
    }

    public static void pattern(int row, int col){
        if(row == 0) return;
        if( row > col){
            System.out.print("* ");
            pattern(row, col+1);
        }else{
            System.out.println();
            pattern(row-1, 0);
        }
    }

    public static void reverseArray(int[] arr, int row, int col){
        if(row == 0) return;
        if( row > col){
            if(arr[col] > arr[col+1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col+1] = temp;
            }
            reverseArray(arr, row, col+1);
        }else{
            reverseArray(arr, row - 1, 0);
        }
    }

    public static void selectionShort(int[] arr, int row, int col, int max){
        if(row == 0) return;
        if( row > col){
            if(arr[col] > arr[max]){
                selectionShort(arr, row, col+1, col);
            }else{
                selectionShort(arr, row, col+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[row - 1] ;
            arr[row - 1] = temp;
            selectionShort(arr, row - 1, 0, 0);
        }
    }

    public static String skipString( String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if( ch == 'a'){
            return skipString(up.substring(1));
        }else{
            return ch + skipString (up.substring(1));
        }
    }

    static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1));
        subSeq(p, up.substring(1));
    }

    static ArrayList<String> subSeqArray(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(p != ""){
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subSeqArray(p + ch, up.substring(1));
        ArrayList<String> last = subSeqArray(p, up.substring(1));

        last.addAll(first);
        return last;
    }

   static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

   static ArrayList<String> permutationsArray(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(p != ""){
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsArray(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static void phonePad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit-1)*3; i < digit *3; i++) {
            char ch = (char)('a' + i);
            phonePad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> phonePadList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(p != ""){
                list.add(p);
            }
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();
        for (int i = (digit-1)*3; i < digit *3; i++) {
            char ch = (char)('a' + i);
            list.addAll(phonePadList(p + ch, up.substring(1)));
        }
        return list;
    }

    //backtracking
    static int pathCount(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = pathCount(r-1, c);
        int right = pathCount(r, c-1);
        return left + right;
    }

    static void pathWay(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if( r > 1){
            pathWay(p + "D",r-1, c);
        }else{
            pathWay(p + "R", r, c-1);
        }
    }

    static void allPathWay(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if( r > 1){
            allPathWay(p + "D",r-1, c);
        }
        if(c > 1){
            allPathWay(p + "R", r, c-1);
        }
    }

    static ArrayList<String> allPathWayArray(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if( r > 1){
            list.addAll(allPathWayArray(p + "D",r-1, c));
        }
        if(c > 1){
            list.addAll(allPathWayArray(p + "R", r, c-1));
        }
        return list;
    }

    static ArrayList<String> diagonalPathWayArray(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if( r > 1 && c > 1){
            list.addAll(diagonalPathWayArray(p + "D",r-1, c-1));
        }
        if( r > 1){
            list.addAll(diagonalPathWayArray(p + "V",r-1, c));
        }
        if(c > 1){
            list.addAll(diagonalPathWayArray(p + "H", r, c-1));
        }
        return list;
    }

    static void allPathWayWithObstical(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if( r < maze.length - 1){
            allPathWayWithObstical(p + "V", maze,r+1, c);
        }
        if(c < maze[0].length - 1){
            allPathWayWithObstical(p + "H", maze, r, c+1);
        }
    }

    static void allPathWayWithAllDirection(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        if( r < maze.length - 1){
            allPathWayWithAllDirection(p + "R", maze,r + 1, c);
        }
        if(c < maze[0].length - 1){
            allPathWayWithAllDirection(p + "D", maze, r, c + 1);
        }
        if( c > 0){
            allPathWayWithAllDirection(p + "L", maze, r, c - 1);
        }
        if(r > 0){
            allPathWayWithAllDirection(p + "U", maze, r - 1, c);
        }
        maze[r][c] = true;
    }

    static void allPathWayPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if( r < maze.length - 1){
            allPathWayPrint(p + "R", maze,r + 1, c, path, step + 1);
        }
        if(c < maze[0].length - 1){
            allPathWayPrint(p + "D", maze, r, c + 1, path, step + 1);
        }
        if( c > 0){
            allPathWayPrint(p + "L", maze, r, c - 1, path, step + 1);
        }
        if(r > 0){
            allPathWayPrint(p + "U", maze, r - 1, c, path, step + 1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }

    static int queens(boolean[][] boards, int row){
        if(row == boards.length){
            display(boards);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < boards.length; col++) {
            if(isSafe(boards, row, col)){
                boards[row][col] = true;
                count += queens(boards, row+1);
                boards[row][col] = false;
            }
        }
        return count;
    }
    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element :row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    private static boolean isSafe(boolean[][] board, int row, int col){
        //check vertical
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }
        // check diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-1][col-1]){
                return false;
            }
        }
        // check diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-1][col+1]){
                return false;
            }
        }
        return true;
    }

    static void nQueen(boolean[][] board, int row, List<List<String>> result){
        if(row == board.length){
            result.add(getBoard(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isItSafe(board, row, col)){
                board[row][col] = true;
                nQueen(board, row+1, result);
                board[row][col] = false;
            }    
        }
    }
    private static List<String> getBoard(boolean[][] board){
        List<String> list = new ArrayList<>();
        for(boolean[] row : board){
            StringBuilder sb = new StringBuilder();
            for(boolean element: row){
                sb.append(element ? "Q" : ".");
            }
            list.add(sb.toString());
        }
        return list;
    }
    static boolean isItSafe(boolean[][] board, int row, int col){
        //vertical
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }
        //left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }
        //right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length - 1; i--, j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

    static void knight(boolean[][] board, int row, int col, int knight){
        if( knight == 0){
            displayKnight(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length){
            return;
        }
        if(col == board.length){
            knight(board, row+1, 0, knight);
            return;
        }
        if(isSafeForKnight(board, row, col)){
            board[row][col] = true;
            knight(board, row, col+1, knight-1);
            board[row][col] = false;
        }
        knight(board, row, col+1, knight);
    }
    private static void displayKnight(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element :row){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }  
    static boolean isSafeForKnight(boolean[][] board, int row, int col){
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }
        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }  
    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0  && row < board.length && col >= 0  && col < board.length){
            return true;
        }
        return false;
    }

    static boolean solveSoduko(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft == false){
                break;
            }
        }
        if(emptyLeft == true){
            return true;
        }
        //backtrack
        for (int number = 0; number <= 9; number++) {
            if(isItSafeForSudoku(board, row, col, number)){
                board[row][col] = number;
                if(solveSoduko(board)){
                     return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static boolean isItSafeForSudoku(int[][] board, int row, int col, int num){
        //check in the row
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }
        //check in the col
        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }
        //check in the box
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt; 
        int endstart = col - col % sqrt; 
        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = endstart; c < endstart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        // printDesc(10);
        // printInsc(10);
        // System.out.println(factorial(5));
        // System.out.println(sumN(5));
        // System.out.println(fibonacci(5000));
        // int arr[] = {1, 2, 3, 4, 5, 2};
        // System.out.println(isShorted(arr, 0));
        // System.out.println(firstOccurance(arr, 2, 0));
        // System.out.println(lastOccurance(arr, 2, arr.length-1));
        // System.out.println(xPowerN(2, 4));
        // System.out.println(tillingProblem(3));
        // String str = "appnacollege";
        // remDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPairing(3));
        // printBinString(3, 0, "");
        // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // System.out.println(search(arr, 8, 0, arr.length));
        // System.out.println(sumOfDigit(1342));
        // System.out.println(count(807090));
        // int arr[] = {1, 2, 3, 4, 3, 6, 7, 8, 9};
        // System.out.println(sorted(arr, 0));
        // int arr[] = {1, 2, 3, 4, 3, 6, 7, 8, 9};
        // System.out.println(find(arr, 10, 0));
        // int arr[] = {5, 6, 7, 8, 9, 1, 2, 3};
        // System.out.println(findInRotatedArray(arr, 8, 0, arr.length-1));
        // pattern(4, 0);
        // int arr[] = {5, 4, 3, 2, 1};
        // reverseArray(arr, arr.length-1, 0);
        // selectionShort(arr, arr.length, 0, 0);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(skipString("baccdh"));
        // subSeq("", "abc");
        // System.out.println(subSeqArray("", "abc"));
        // permutations("", "abc");
        // System.out.println(permutationsArray("", "abc"));
        // phonePad("", "12");
        // System.out.println(phonePadList("", "12"));
        // System.out.println(pathCount(3, 3));
        // pathWay("", 3, 3);
        // allPathWay("", 3, 3);
        // System.out.println(allPathWayArray("", 3, 3));
        // System.out.println(diagonalPathWayArray("", 3, 3));
        // boolean[][] board = {
        //     {true, true, true},
        //     {true, true, true},
        //     {true, true, true}
        // };
        // int[][] path = new int [board.length][board[0].length]; 
        // allPathWayWithObstical("", board, 0, 0);
        // allPathWayWithAllDirection("", board, 0, 0);
        // allPathWayPrint("", board, 0, 0, path, 1);
        int n = 4;
        boolean[][] board = new boolean[n][n];
        // System.out.println(queens(board, 0));
        // List<List<String>> result = new ArrayList<>();
        // nQueen(board, 0, result);
        // System.out.println(result);
        knight(board, 0, 0, 4);
    }

}