// import java.util.*;

public class strings {
    public static void printLetter(String str) {
        for(int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
        }
    }

    public static boolean checkPalindrome(String str) {
        int n = str.length() - 1;
        for(int i = 0; i <= n/2; i++){
            if(str.charAt(i) != str.charAt(n-i)){
                return false;
            }
        }
        return true;
    }

    public static float sortestPath(String str) {
        int n = str.length();
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'N'){
                y++;
            }
            else if(str.charAt(i) == 'S'){
                y--;
            }
            else if(str.charAt(i) == 'E'){
                x++;
            }
            else if(str.charAt(i) == 'W'){
                x--;
            }
        }
        return (float)Math.sqrt((x * x) + (y * y));
    }

    public static void subString(String str, int si, int ei) {
        String subStr = "";
        for(int i = si; i < ei; i++){
            subStr += str.charAt(i);
        }
        System.out.println(subStr);
    }

    public static void largestString(String[] str) {
        String largest = str[0];
        for(int i = 1; i < str.length; i++){
            if(largest.compareTo(str[i]) < 0){
                largest = str[i];
            }
        }
        System.out.println(largest);
        
    }

    public static String firstUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(count > 1){
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }

    public static String reverseWords(String s) {
        String nums[] = s.split(" ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for(int i = n-1; i >= 0; i--){
            sb.append(nums[i]);
            if(i <= n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // String str1 = "abcd";
        // String str2 = new String("abcd");

        // if(str1.equals(str2)) System.out.println("strings are equal");

        // System.out.print("enter the value of string : ");
        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);
        // System.out.println(name.length());
        // System.out.println(name.charAt(0));

        // String str = "noon";
        // // printLetter(str);
        // System.out.println("string "+str+" is Palindrome : "+checkPalindrome(str));

        // String path = "WNEENESENNN";
        // System.out.println("sortest Path will be : "+ sortestPath(path));

        // subString("rohit kumar", 3, 6);
        //inbuild
        // str.subString(0, 3);

        // String fruits[] = {"apple", "mango", "banana"};
        // largestString(fruits);

        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a';ch <= 'z'; ch++){
        //     sb.append(ch);
        // }
        // System.out.print(sb);


        // String str = "hi, i am rohit";
        // System.out.println(firstUpperCase(str));

        // String str = "aaabbcccdd";
        // System.out.println(compress(str));
        String s ="the sky is blue";
        System.out.println(reverseWords(s));
    }
}