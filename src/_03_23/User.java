package _03_23;

class User {

    private String name;
    private String passwort;

    String getName() {
        return this.name;
    }

    String getPasswort() {
        return this.passwort;
    }


    User(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }


}
