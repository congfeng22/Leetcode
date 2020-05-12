public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        int l=0; int r=s.length()-1;
        while (l<r){
            if (s.charAt(l)<48 || (s.charAt(l)>57 && s.charAt(l)<65) || (s.charAt(l)>90 && s.charAt(l)<97) || s.charAt(l)>122){
                l++;
                continue;
            }
            if (s.charAt(r)<48 || (s.charAt(r)>57 && s.charAt(r)<65) || (s.charAt(r)>90 && s.charAt(r)<97) || s.charAt(r)>122){
                r--;
                continue;
            }
            if (s.charAt(l)>47 && s.charAt(l)<58 && s.charAt(l)==s.charAt(r)){
                l++;
                r--;
                continue;
            }
            int t; int w;
            if (s.charAt(l)>96 && s.charAt(l)<123){
                t = s.charAt(l);
            }
            else{
                t = s.charAt(l) + 32;
            }
            if (s.charAt(r)>96 && s.charAt(r)<123){
                w = s.charAt(r);
            }
            else{
                w = s.charAt(r) + 32;
            }
            if (t==w){
                l++;
                r--;
                continue;
            }
            return false;
        }
        return true;
    }
}
