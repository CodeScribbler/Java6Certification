package _04_10;

import java.util.Scanner;
import static _04_10.Stack.checkInput;

public class Aufgabe {

    private static int input;

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            Stack stackObject = new Stack(75);

            do {

                System.out.println("\n ----- STACK IS AVAILIBLE ----- \n");
                System.out.println("STACK PUSH:  1");
                System.out.println("STACK TRACE: 2");
                System.out.println("STACK PEEK:  3");
                System.out.println(" STACK POP:  4");
                System.out.println("      EXIT:  0\n");

                System.out.println("\n Input:");
                input = scan.nextInt();

                if (checkInput(input)) {

                    switch (input) {
                        case 1:
                            System.out.println("\n Stack value:");
                            stackObject.push(scan.nextInt());
                            break;
                        case 2:
                            stackObject.getStackValues();
                            break;
                        case 3:
                            stackObject.peek();
                            break;
                        case 4:
                            stackObject.pop();
                    }
                }

            } while (input != 0);

        }
        catch(MyStackException e) {
            e.getMyStackMessage();
        }
    }
}

class Stack{

    private int[] storage;
    private int current;

    Stack(int size){
        storage = new int[size];
        current = -1;
    }

    private boolean isFull(){
        return current == storage.length -1;
    }

    private boolean isEmpty(){
        return current == -1;
    }

    protected void peek() {
        if(this.isEmpty()) {
            System.out.println("WARNING: Stack is empty!");
        }
        else System.out.println("\n STACK: " + storage[current] + "\n");
    }

    protected void pop() {
        if(this.isEmpty()) {
            System.out.println("WARNING: Stack is empty!");
        }
        else {
            System.out.println("\n" + storage[current] + "\n");
            storage[current] = 0;
            current--;
        }
    }

    protected void push(int val) throws MyStackException {
        if(this.isFull()) throw new MyStackException();
        else {
            for (int i = 0; i <= current; i++) {
                if(storage[i] == 0) {
                    storage[i] = val;
                    current++;
                }
            }
        }
    }

    protected void getStackValues() {
        for (int value : this.storage) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    protected static boolean checkInput(int val) {
        if(val >= 0 & val <= 4)  return true;
        else return false;
    }
}

class MyStackException extends Exception {

    void getMyStackMessage() {
        System.out.println("ERROR: WRONG USER INPUT!");
    }
}