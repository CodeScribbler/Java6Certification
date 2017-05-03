package _05_02;

import java.util.Arrays;
import java.util.Collections;

public class Vererbung {
    public static int m(int x, int y){
        return x +y;
    }
    public static void main(String[] args) {
        CB<CA> x = new CB<CA>();
        m(3, 4);
        test("Abc");

        Collections a;
    }

    public static void test(String s ){

    }
    public static void test (Object o){

    }
}

class CA {}

class CB<T extends CA>{
    public void m(T t){

    }
}

class CC<T> extends CA{//erlaubt

}

class CD<T extends CA> extends CB<T>{

}

class CE extends CB<CA>{
    public void m(CA a){//Overriding

    }
    public void m(Object o){//Overriding?

    }

}




//class IImplementer_2 implements I<CA, CD>, I<CA, CB>{//nicht zulässig
//
//	@Override
//	public void m1(CA t) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void m2(CB t) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void m1(CA t) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void m2(CD t) {
//		// TODO Auto-generated method stub
//
//	}
//
//}