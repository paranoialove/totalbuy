package uuu.totalbuy.test;
public class TestWrapperClass {
    public static void main(String[] args) {
        int i = 1;
        Integer i1 = new Integer(i); //boxing
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        byte b = 2;
        Byte b1 = new Byte(b);//boxing
        
        int j = i1.intValue() + b1.byteValue(); //unboxing, unboxing
        Integer j1 = new Integer(j); //boxing
        
        
        boolean isOpened = true;
        Boolean b3 = new Boolean(isOpened);//boxing
        
        //----------------------------------------------jdk 5.0 
        
        int x = 1;
        Integer x1 = x;//autoboxing
        System.out.println(x1.getClass().getName());
        
        byte y = 2;
        Byte y1 = y;//autoboxing
        
        int z = x1 + y1; //auto-unboxing, auto-unboxing
        
        
        Integer o1 = 1;  //new Integer(1);
        Integer o2 = o1;
        
        System.out.println(o1==o2);//true
        
        o2 = o1+1;//  new Integer(o1.intValue()+1);
        System.out.println(o1==o2); //false
        System.out.println(o2);//2
        System.out.println(o1);//1
        
        
    }
}
