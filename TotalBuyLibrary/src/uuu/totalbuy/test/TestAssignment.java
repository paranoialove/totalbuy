package uuu.totalbuy.test;

public class TestAssignment {
    int i=1;
    public static void main(String[] args) {
        char a = '1'; //代表字元1 (字碼為49)
        System.out.println(a);       
        boolean married = (a>3);
        System.out.println(married);
        
                              //char (0~65535)->
        //byte(-128~127) -> short(-32768~32767) -> int -> long -> float -> double
        byte b = 1;
        
        int i;
        i = b;
        System.out.println(i);
        i = a;//字元指派給int, 就可以取得該字元的unicode字碼(10進位)
        System.out.println(i); 
        
        
        int k = 100;
        char char2 = (char)k;//int指派給字元(必須先轉型), 就可以取得該unicode字碼的字元
        System.out.println(char2);
        
        byte age = 25, three=3;
        age = (byte)(age + three);
        System.out.println("age = " + age);
        
        float pi = 3.14f;
        float pi2 = (float)3.14;
    }
}
