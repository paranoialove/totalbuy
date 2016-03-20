package uuu.totalbuy.test;


public class TestOperators {

    public static void main(String[] args) {
        //Arithmetic Operators:  + - * / %
        byte a = 1, b = 2;
        byte r1 = (byte) (a + b);

        double r2 = '1' + '2'; //49 + 50

        double r3 = 1 / 2D;

        System.out.println("r1: " + r1); //3
        System.out.println("r2: " + r2); //99
        System.out.println("r3: " + r3); //0

        long age = 1000000 * 365 * 24L * 60 * 60;
        System.out.println(age);

        //Comparison Operators:  > >= < <= == !=
        System.out.println(5 > '2');//這裡是5 和字元'2'的字碼50比大小: false
        System.out.println(5 > 2.5); //這裡是5 和 2.5 比大小: true
        System.out.println(5 == 5.0); //這裡是5 和 2.5 比大小: true

        //Logical Operators:  & | ^ !   &&   || 
        System.out.println(a >= 1 & b >= 2); // a: 1, b:2

        String s = null;
        System.out.println(s != null && s.length() > 0); //false
        //System.out.println(s.length()>0 && s!=null); //false

        System.out.println(s == null || s.length() == 0); //true
        //System.out.println(s==null | s.length()==0); //runtime error
        System.out.println(a > 1 ^ b < 2);
        System.out.println(!true); //false

        //位元operators: ~(求補數), &, |, ^
        byte o = 0b0111, p = 0b0100; //00000111, 00000100
        System.out.println("~o= " + (~o));//11111000
        System.out.println("o&p= " + (o & p));//00000100
        System.out.println("o|p= " + (o | p));//00000111
        System.out.println("o^p= " + (o ^ p));//00000011
        //System.out.println(1.1^2.1);

        byte q = 15;
        System.out.println("q>>1= " + (q >> 1));
        System.out.println("q>>>1= " + (q >>> 1));
        System.out.println("q<<1= " + (q << 1));
        System.out.println("q>>2= " + (q >> 2));
        System.out.println("q>>>2= " + (q >>> 2));
        System.out.println("q<<2= " + (q << 2));

        System.out.println("-q>>1= " + (-q >> 1));//-8
        System.out.println("-q>>>1= " + (-q >>> 1));
        System.out.println("-q<<1= " + (-q << 1));//-15
        System.out.println("-q>>2= " + (-q >> 2));//-4
        System.out.println("-q>>>2= " + (-q >>> 2));
        System.out.println("-q<<2= " + (-q << 2));//-60

        //遞增/遞減 operators
        a = 1;
        //a++;// a=a+1
        System.out.println(a++);//print:1 , a: 2

        //++a;// a=a+1
        System.out.println(++a);//a: 3, print: 3

        boolean rtn = a++ == 3;//boolean rtn = (a++ == 3);
        System.out.println("rtn=" + rtn); //true

        a = 127;
        a++;//a=(byte)(a+1);
        System.out.println(a);

        short k = 32767;
        k++;// k = (short)(k+1);
        System.out.println(k); //-32768

        //k--;
        System.out.println(k--); //print:-32768, k: 32767
        System.out.println(--k); //k:32766, print: 32766

        //指派運算子
        byte n1 = 1, n2 = 2;

        //;  //n1 = (byte)(n1 +(100-n2/4))
        System.out.println("n1=" + (n1 += 100 - n2 / 4));//        n1 = (byte)(n1 +(100-n2/4))

        System.out.println(1 + (true + (0.5 + "Hello!")));

        //字串運算子
        s = "Hello";
        s += " World"; // s =  s+" World"
        System.out.println(s);

        //三元運算子
        int grade = 33;
        System.out.println((grade >= 60) ? "Pass" : "Fail");

        if (grade >= 60) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        k = 123_4;
        boolean test;
        float t = ((test = true) ? 1 : 2.0f);

        System.out.println(t);
        System.out.println((test = false) ? 1 : 2.0);

        String str = ((test = true) ? String.valueOf('k') : "M");
        System.out.println(str);
    }
}
