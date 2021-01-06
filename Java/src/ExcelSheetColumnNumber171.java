public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        int ret = 0;
        for (int i=0;i<s.length();i++){
            ret+=(s.charAt(i)-64)*Math.pow(26,s.length()-1-i);
        }
        return ret;
    }
}
