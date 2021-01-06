public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        return helper(n).toString();
    }
    public StringBuilder helper(int n){
        StringBuilder ret;
        if (n<27){
            ret = new StringBuilder();
            ret.append((char) (n+64));
            return ret;
        }
        if (n%26==0){
            ret = helper(n/26-1);
            ret.append("Z");
        } else{
            ret = helper(n/26);
            ret.append((char)(n%26+64));
        }
        return ret;
    }
    public static void main(String[] args){
        ExcelSheetColumnTitle168 test = new ExcelSheetColumnTitle168();
        System.out.println(test.convertToTitle(701));
    }
}
