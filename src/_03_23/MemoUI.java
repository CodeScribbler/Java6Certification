package _03_23;

import utility.Terminal;
import java.io.Console;
import java.io.IOException;

public class MemoUI{
    private static Memo[] memos = new Memo[100];
    private static User[] user = new User[100];
    public static Console cons = System.console();
    public static void main(String[] args) throws IOException, InterruptedException {
        int c = 0;
        do{
            System.out.println("-------MENU-------");
            System.out.println("1: Create User");
            System.out.println("2: Create Memo");
            System.out.println("3: Read Memo");
            System.out.println("0: Exit");
            c = Terminal.askInt("Your Choice: ");

            switch(c){
                case 1:
                    if(createUser()) System.out.println("Success.");
                    else System.out.println("Not possible to create user.");
                    break;
                case 2:
                    if(createMemo()) System.out.println("Success.");
                    else System.out.println("Not possible to create memo.");
                    break;
                case 3:
                    readMemo();
                    break;
                case 0:
            }
        }while(c!=0);
    }

/*Durchsucht das User-Array nach einem freien Platz und fügt dann an dieser Stelle einen neuen User ein.
  Um ein Passwort einzulesen, benutzt bitte nicht Terminal.askString(), sondern new String(cons.readPassword("Enter password: "))
  Gibt true zurück, wenn das Erstellen funktioniert hat und false, wenn nicht.*/

    private static boolean createUser(){
        try {
            for (int i = 0; i < user.length; i++) {
                if (user[i] == null) {
                    String name = Terminal.askString(" Enter name: ");
                    String pw = Terminal.askString(" Enter password: "); // new String(cons.readPassword(" Enter password: "));
                    user[i] = new User(name, pw);
                    return true;
                }
            }
        }
        catch (Exception e) { Terminal.println(e.getMessage()); }
        return false;
    }

/*Durchsucht das User-Array nach einem User, der den übergebenen Namen trägt und gibt diesen zurück.
  Wird keiner gefunden, wird null zurückgegeben.*/

    private static User findUser(String name){
        for (User iterator : user) {
            if (iterator == null) continue;
            if (iterator.getName().equals(name)) return iterator;
        }
        return null;
    }

/*Durchsucht das Memo-Array nach einem freien Platz und fügt dann an dieser Stelle ein neues Memo ein.
  Benötigt die Methode findUser um den zu einem Namen gehörigen User zu finden und dem Memo-Konstruktor zu übergeben.
  findUser kann null zurückgeben. In diesem Fall wird eine Exception ausgelöst, die behandelt werden muss.*/

    private static boolean createMemo(){
        try {
            for (int i = 0; i < memos.length; i++) {
                if (memos[i] == null) {
                    User user;

                    user = findUser(Terminal.askString("\n Enter name: "));
                    if (user == null)
                    {
                        Terminal.println(" The user could not be found!");
                        return false;
                    }
                    String memoText;
                    do {
                        memoText = Terminal.askString(" Enter words: ");
                        if(memoText.isEmpty()) Terminal.print(" Incorrect input!\n");
                    }while(memoText.isEmpty());

                    Memo memo = new Memo(memoText, user);
                    memos[i] = memo;
                    return true;
                }
            }
        }
        catch (Exception e) { Terminal.println(e.getMessage()); }
        return false;
    }

/*Gibt zunächst alle bereits erstellten Memos mit einer Nummer und dem User-Namen aus.
  Der Benutzer kann sich dann über die Nummer ein Memo aussuchen.
  Dieses wird ausgegeben, falls der Benutzer das richtige Passwort eingibt.
  Um ein Passwort einzulesen, benutzt bitte nicht Terminal.askString(), sondern new String(cons.readPassword("Enter password: "))
  Möglicherweise trifft der Benutzer eine ungültige Wahl.
  In diesem Fall wird eine Exception ausgelöst, die behandelt werden muss.*/

    private static void readMemo() {
        try
        {
            byte counter = 0;
            for (Memo iterator: memos) {
                if (iterator != null) {
                    counter++;
                    System.out.println(" No: " + counter + " - From: " + iterator.getUser().getName());
                }
            }
            if (counter > 0) {
                byte memoNr = Terminal.askByte("\n Enter number: ");

                if (memoNr > 0 && memoNr < counter+1) {
                    String pw = Terminal.askString(" Enter password: "); // new String(cons.readPassword(" Enter Password: "));
                    Terminal.println(memos[memoNr-1].getText(pw));
                }
                else Terminal.println("Incorrect input!");

            }
            else { Terminal.println("There are no memos!"); }
        }
        catch (Exception e) { Terminal.println(e.getMessage()); }
    }

}
