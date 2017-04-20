package _03_23;

class Memo {

    private String text;
    private User user;

    String getText(String pw) {
        if (this.user.getPasswort().equals(pw))
            return this.text;
        else
            return "\n You are not authorized!\n";
    }

    User getUser() {
        return this.user;
    }

    Memo(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
