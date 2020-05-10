public class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        if (s1.equals("")) return s2.equals(s3);
        if (s2.equals("")) return s1.equals(s3);
        // dp[i] = whether first i+j+1 chars of s3 is an interweaving of first i+1 chars of s1 and first j chars of s2
        boolean dp[]= new boolean[s1.length()];
        int j = 1;
        // base cases
        dp[0] = s1.charAt(0)==s3.charAt(0);
        for (int r=1;r<s1.length();r++){
            dp[r] = dp[r-1] && s1.charAt(r)==s3.charAt(r);
        }
        boolean left = true;
        while (j<s2.length()+1){
            left = left && s2.charAt(j-1)==s3.charAt(j-1);
            dp[0] = (left && s1.charAt(0)==s3.charAt(j)) || (dp[0] && s2.charAt(j-1) == s3.charAt(j));
            for (int i=1;i<dp.length;i++){
                dp[i] = (dp[i-1] && s1.charAt(i)==s3.charAt(i+j)) || (dp[i] && s2.charAt(j-1) == s3.charAt(i+j));
            }
            j++;
        }
        return dp[s1.length()-1];
    }
}