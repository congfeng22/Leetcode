public class ReverseBits190 {
    public int reverseBits(int n) {
        String s = "11111111111111111111111111111101";
        System.out.println(s);
        int rev = 0;
        for (int i=0;i<s.length();i++){
            rev += (s.charAt(s.length()-1-i)-48)*Math.pow(2,31-i);
        }
        return rev;
    }
    public static void main(String[] args){
        ReverseBits190 test = new ReverseBits190();
        System.out.println(test.reverseBits(1));
    }
}
