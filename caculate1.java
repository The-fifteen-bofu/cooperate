import java.util.Random;

public class caculate1 {

public static String[] format(int max){
    Random random=new Random();
    String exp[]=new String[2];//定义生成的题目
    int a= (int) (random.nextInt(max));//分子
    int b= (int) (random.nextInt(max));//分母
    int c= (int) (random.nextInt(max));//另一个分子
    int d= (int) (random.nextInt(max));//另一个分母
    int symbol;//运算符
    symbol= (int) (random.nextInt(4));
        if(b!=0&&d!=0) {//分母均不为0时生成带有分数的计算题，同时计算结果
        if(symbol==0) {
            int fenzi=a*d+b*c;
            int fenmu=b*d;
            exp[0]= translate(a,b)+'+'+ translate(c,d)+'=';
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);

        }
        if(symbol==1&&a*d-b*c>=0) {
            int fenzi=a*d-b*c;
            int fenmu=b*d;
            exp[0]= translate(a,b)+'-'+ translate(c,d)+'=';
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);

        }
        if(symbol==1&&a*d-b*c<0) {
            int fenzi=b*c-a*d;
            int fenmu=b*d;
            exp[0]= translate(a,b)+'-'+ translate(c,d)+'=';
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);

        }
        if(symbol==2) {
            int fenzi=a*c;
            int fenmu=b*d;
            exp[0]= translate(a,b)+'×'+ translate(c,d)+'=';
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);

        }
        if(symbol==3&&c!=0) {
            int fenzi=a*d;
            int fenmu=b*c;
            exp[0]= translate(a,b)+'÷'+ translate(c,d)+'=';
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);

        }

    }
        else {//分母至少一个为0时生成只含有整式的运算式，同时计算结果
        b=1; d=1;
        if(symbol==0) {
            int fenzi=a*d+b*c;
            int fenmu=b*d;
            exp[0]=a+"+"+c+"=";
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);//计算结果

        }
        if(symbol==1&&a*d-b*c>=0) {
            int fenzi=a*d-b*c;
            int fenmu=b*d;
            exp[0]=a+"-"+c+"=";
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);//计算结果


        }
        if(symbol==1&&a*d-b*c<0) {
            int fenzi=b*c-a*d;
            int fenmu=b*d;
            exp[0]=c+"-"+a+"=";
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);//计算结果


        }
        if(symbol==2) {
            int fenzi=a*c;
            int fenmu=b*d;
            exp[0]=c+"×"+a+"=";
            System.out.println(exp[0]);
            exp[1]= caculate(fenzi, fenmu);//计算结果


        }
        if(symbol==3&&c!=0) {
            int fenzi = a * d;
            int fenmu = b * c;
            exp[0] = a + "÷" + c + "=";
            System.out.println(exp[0]);
            exp[1] = caculate(fenzi, fenmu);//计算结果
        }
            if(symbol==3&&c==0) {
            format(max);
        }
}return exp;}





    public static String caculate(int a, int b) {// 结果的分数约分，用于计算结果
        int y = 1;
        for (int i=a;i>=1;i--) {
            if(a%i==0&&b%i==0) {
                y=i;
                break;
            }
        }
        int z=a/y;// 分子
        int m=b/y;// 分母
        if (z == 0) {
            return "0";
        }
        if(m==1) return z+"";
        else  return translate(z,m);

    }
    public static String translate(int a, int b) {//判断假分数，并化假分数为带分数
        if(a>=b) {
            int c;
            c=a/b;
            int d;
            d=a%b;
            {if(d==0) {return c+"";}
                return c+"'"+d+"/"+b;}
        }return a+"/"+b;
    }

}
