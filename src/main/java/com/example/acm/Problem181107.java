package com.example.acm;

/**
 * Grab
 * 说随机给两个整数，x和y，输出x个a，y个b，要求不能出现连续3个a或者3个b
 */
public class Problem181107 {
    public String solution(int a,int b){
        StringBuffer sb = new StringBuffer();
        int a_ = a;
        int b_ = b;
        if(a_<=2){
            if(b_<=2) {
                for (int i = 0; i < a_; i++) {
                    sb.append("a");
                }
                for (int i = 0; i < b_; i++) {
                    sb.append("b");
                }
                return sb.toString();
            }else{
                A_less_B(a_,b_,sb);
                return sb.toString();
            }

        }else{
            if(a_>=b_){
                A_Greateer_B(a_,b_,sb);
                return sb.toString();
            }
            if(b_>a_){
                A_less_B(a_,b_,sb);
                return sb.toString();
            }
        }

        return sb.toString();
    }

    private void A_Greateer_B(int a_,int b_,StringBuffer sb){
        int a_div_2 = a_/2;
        int a_remain = a_%2;
        int[] array_a;
        if(a_remain>0) {
            array_a = new int[a_div_2 + 1];
        }else{
            array_a = new int[a_div_2];
        }
        int b_div_a = b_/a_div_2;
        int b_div_a_remain = b_%a_div_2;
        if(b_div_a>2){
            b_div_a = 2;
            b_div_a_remain = 1;
        }
        int long_length = 0;
        if(a_remain>0){
            long_length = array_a.length-1;
        }else{
            long_length = array_a.length;
        }
        for(int i=0;i<long_length;i++){
            sb.append("aa");
            for(int j=0;j<b_div_a;j++){
                sb.append("b");
            }
        }
        if(a_remain>0){
            sb.append("a");
        }
        if(b_div_a_remain>0){
            sb.append("b");
        }
    }
    private void A_less_B(int a_,int b_,StringBuffer sb){
        int b_div_2 = b_/2;
        int b_remain = b_%2;
        int[] array_b = new int[b_div_2+1];
        int a_div_b = a_/b_div_2;
        int a_div_b_remain = a_%b_div_2;
        for(int i=0;i<array_b.length-1;i++){
            sb.append("bb");
            for(int j=0;j<a_div_b;j++){
                sb.append("a");
            }
        }
        if(b_remain>0){
            sb.append("b");
        }
        if(a_div_b_remain>0){
            sb.append("a");
        }
    }

    public static void main(String[] args){
        //testcase
        Problem181107 test = new Problem181107();
//        System.out.println(test.checkEqual("aaa","a",a3));
//        System.out.println(test.checkEqual("aba","a",2));
//        System.out.println(test.checkEqual("bb","aaa",0));
//        System.out.println(test.checkNotLess("aaabb","aaa",1));
//        System.out.println(test.checkNotLess("aaaabb","aaa",1));
        String str = null;
        int a,b;
        a=0;b=0;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=1;b=2;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=2;b=2;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=3;b=2;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=4;b=2;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=5;b=2;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=5;b=3;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=5;b=4;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=5;b=5;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=2;b=3;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=3;b=3;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=3;b=4;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=4;b=4;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
        a=4;b=5;
        System.out.println(test.returnIsRight(test.solution(a,b),a,b));
    }

    public boolean returnIsRight(String str,int a,int b){
        System.out.print("a:"+a+" b:"+b+" result:"+str+" ");
        if(str==null||"".equals(str)){
            return true;
        }
        if(!checkEqual(str,"a",a)){
            return false;
        }
        if(!checkEqual(str,"b",b)){
            return false;
        }
        if(checkNotLess(str,"aaa",1)){
            return false;
        }
        if(checkNotLess(str,"bbb",1)){
            return false;
        }
        return true;
    }

    private int checkNum(String str,String c,int i){
        int index = str.indexOf(c);
        int count = 0;
        while(index>-1){
            count++;
            index = str.indexOf(c,index+1);
        }
        return count;
    }

    public boolean checkEqual(String str,String c,int i){
        int count = checkNum(str,c,i);
        return i==count;
    }

    public boolean checkNotLess(String str,String c,int i){
        int count = checkNum(str,c,i);
        return i<=count;
    }
}
