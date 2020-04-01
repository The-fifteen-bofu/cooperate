
import java.io.*;
import java.util.Scanner;

public class A {
    public static void main(String args[]){
        String[] symbol=new String[]{"+","-","*","/"};
        int tot,max;
        System.out.println("请输入您要生成的题目数  输入格式：-n 题目数");
        Scanner sc= new Scanner(System.in);
        String st = sc.nextLine();
        String[] num=st.split(" ");;
        System.out.println("请继续输入您要生成的题目数值范围  输入格式：-r 数值");
        Scanner sc1= new Scanner(System.in);
        String st1 = sc1.nextLine();
        String[] num1=st1.split(" ");
        tot=Integer.valueOf(num[1]);
        max=Integer.valueOf(num1[1]);
        for(int  i=0;i<tot;i++){
            String[] a= caculate1.format(max);

            FileWriter fw = null;
            try {

                File f=new File("Exercises.txt");//题目写入
                fw = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(a[0]!=null) {
                PrintWriter pw = new PrintWriter(fw);
                pw.println(a[0]);
                pw.flush();
                try {
                    fw.flush();
                    pw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}FileWriter fn = null;
            try {

                File f=new File("Answers.txt");//答案写入
                fn = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(a[0]!=null) {
                PrintWriter pn = new PrintWriter(fn);
                pn.println(a[0]+a[1]);
                pn.flush();
                try {
                    fn.flush();
                    pn.close();
                    fn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}


}}}
