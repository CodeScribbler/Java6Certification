package _04_27;


public enum Note {

    EINS(1.0), EINS_MINUS(1.3),
    ZWEI(2.0), ZWEI_MINUS(2.3),
    DREI(3.0), DREI_MINUS(3.5),
    VIER(4.0), VIER_MINUS(4.5),
    FUENF(5.0), FUENF_MINUS(5.5),
    SECHS(6.0);


    double note;

    Note(double n) {
        this.note = n;
    }

}
