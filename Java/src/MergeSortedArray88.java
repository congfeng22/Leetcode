import java.util.Arrays;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) return;
        if (m==0){
            for (int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i=0;i<m;i++){
            nums1[nums1.length-i-1]=nums1[m-i-1];
        }
        int p=n; int q=0; int i=0;
        boolean leftover = false;
        while (i<nums1.length){
            if (nums1[p]<nums2[q]) {
                nums1[i]=nums1[p];
                i++;
                if (p==nums1.length-1) {
                    leftover = true;
                    break;
                }
                p++;
            }
            else {
                nums1[i]=nums2[q];
                i++;
                if (q == nums2.length-1) break;
                q++;
            }
        }
        // If some nums2 left
        if (leftover){
            for (int j=q;j<nums2.length;j++){
                nums1[i] = nums2[j];
                i++;
            }
        } else {
            // If some nums1 left
            for (int j=p;j<nums1.length;j++){
                nums1[i] = nums1[j];
                i++;
            }
        }
    }
    public static void main(String[] args){
        MergeSortedArray88 test = new MergeSortedArray88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        test.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
