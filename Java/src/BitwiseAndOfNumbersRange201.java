public class BitwiseAndOfNumbersRange201 {
    public int rangeBitwiseAnd(int m, int n) {
        String a = String.format("%32s", Integer.toBinaryString(m)).replaceAll(" ", "0");
        String b = String.format("%32s", Integer.toBinaryString(n)).replaceAll(" ", "0");
        StringBuilder ret = new StringBuilder();
        int idx = 0;
        while (idx<32 && a.charAt(idx)==b.charAt(idx)){
            ret.append(a.charAt(idx));
            idx++;
        }
        int zeroes = 32-ret.length();
        int num = Integer.parseInt(ret.toString(),2);
        num *= Math.pow(2,zeroes);
        return num;
    }
    public static void main(String[] args){
        BitwiseAndOfNumbersRange201 test = new BitwiseAndOfNumbersRange201();
        System.out.println(test.rangeBitwiseAnd(0,1));
    }
}
