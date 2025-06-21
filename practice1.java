public class practice1 {
    public int findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] num = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        int output = 0;
        while(i < n || j < m){
            if(nums1[i] > nums2[j]){
                num[k++] = nums2[j++];
            }else if(nums1[i] < nums2[j]){
                num[k++] = nums1[i++];
            }else{
                num[k++] = nums1[i++];
            }
        }
        while(i < n){
            num[k++] = nums1[i++];
        }
        while(j < m){
            num[k++] = nums2[j++];
        }
        if(k%2 == 0){
            output =  k/2;
        }else{
            output = (num[k/2] + num[(k+1)/2])/2;
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        practice1 obj = new practice1();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }  
}
