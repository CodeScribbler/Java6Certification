package _05_02;

/*
 *
 * class K<T>{....}
 *
 * T kann bel gültiger Bezeichner Sein (Convention: Großbuchtabe)
 * T darf sowohl im Klassenkopf als auch im Rumpf überall verwendet werden wo ein DT vorkommen darf
 * T ist ein formaler Typ-Parameter
 *
 * K<String> v = new K<String>();
 *
 * ---> T wurde mit String ersetzt
 * ---> String ist Argument
 *
 */
public class GenericsSyntax {

}

class X<E> {

}

class D<T> extends X<T> {

}

class Y<T> {
    T a;

    T m(T t1, T t2) {
        return t2;
    }
}

interface I<T1, T2> {
    public void m(T1 x, T2 y);
}

class C<A, B> implements I<String, Integer> {

    @Override
    public void m(String x, Integer y) {
        // TODO Auto-generated method stub

    }

}

class M<A, B> implements I<A, B> {
    public void m(A x, B y) {

    }
}