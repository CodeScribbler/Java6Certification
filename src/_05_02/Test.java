package _05_02;

public class Test {
    public static void main(String[] args) {

        //Ansatz 1:
        Flasche bierFlasche = new Flasche();
        bierFlasche.befuellen(new WeissWein("Bordaux"));//Typ-Unsicherheit

        Bier bierGlass = (Bier) bierFlasche.leeren();//ClassCastException

        //Ansatz 2

        BierFlasche bf = new BierFlasche();
        bf.befuellen(new Bier("Augustina"));
        Bier glass = bf.leeren();

        //Ansatz 3

        FlascheG<Bier> flasche = new FlascheG<Bier>();
        flasche.befuellen(new Bier("Augustina"));
        //flasche.befuellen(new WeissWein("Bordaux"));
        Bier b = flasche.leeren();

//		FlascheG<Getraenk> g = new FlascheG<Wein>();
//		FlascheG<Wein> w = new FlascheG<WeissWein>();

        FlascheG<Getraenk> g = new FlascheG<Getraenk>();
        FlascheG<Wein> w = new FlascheG<Wein>();

        //Raw Type
        FlascheG test = new FlascheG();
        //	test.befuellen(new Integer(123));//Integer hat keine IS-A Beziehung zu Getraenk


        //Typ-Bounding: String hat keine IS-A Beziehung zu Getraenk
//		FlascheG<String> strF = new FlascheG<String>();
//		strF.befuellen("Abc");



    }

}
