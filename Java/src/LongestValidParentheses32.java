public class LongestValidParentheses32 {
    int[] arr;
    public int longestending(String s, int end){
        if (end==0) return 0;
        if (s.charAt(end) == '(') return 0;
        if (s.charAt(end-1) == '(') return (end-2) >= 0 ? (arr[end-2] + 2) : 2;
        else if (end-arr[end-1]-1>=0 && s.charAt(end-arr[end-1]-1) == '(') return 2+arr[end-1]+(end-arr[end-1]-2 >=0 ? arr[end-arr[end-1]-2]:0);
        return 0;
    }
    public int longestValidParentheses(String s) {
        int max = 0;
        arr = new int[s.length()];
        for (int end=0;end<s.length();end++){
            arr[end] = longestending(s,end);
            if (max<arr[end]) max = arr[end];
        }
        return max;
    }
    public static void main(String[] args){
        LongestValidParentheses32 test = new LongestValidParentheses32();
        String t = ")()())";
        System.out.println(test.longestValidParentheses(t));
    }
}