package uuu.totalbuy.test;

//Java程式範例: TestLocalVar

public class TestLocalVar {

    public static void main(String[] args) {
        int i, j = 0;
        if (j == 0) {
            i = 1;            
        //} else  if (j != 0) {
        }else{
            i = 2;            
        }
        System.out.println(i); //編譯失敗
    }
}
