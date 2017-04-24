package _04_24;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ImmoScout {

    private static ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        int val01;
        do {

            System.out.print("\n       Add apartment: 0");
            System.out.print("\n    Delete apartment: 1");
            System.out.print("\nDelete all apartment: 1");
            System.out.print("\n      Sort apartment: 3");
            System.out.print("\n  Backup apartments : 4\n");
            System.out.print("\n                Exit: 5");

            val01 = readInt("\n\n Input:");

            if(val01 >= 0 && val01 <= 4) {
                switch (val01) {
                    case 0:
                        apartmentList.add(createApartment());
                        break;
                    case 1:
                        deleteApartment();
                        break;
                    case 2:
                        apartmentList.clear();
                        System.out.println(apartmentList.size());
                        System.out.println("The apartmentarray is empty!");
                        break;
                    case 3:
                        showSortMenu();
                        break;
                    case 4:
                        showSerialMenu();
                        break;
                }
            }

        } while (val01 != 5);
        System.out.println("\nCheerio!");
    }

    private static void showSortMenu() {
        Scanner input = new Scanner(System.in);
        int val;
        do {

            System.out.print("\n Sort by district: 0");
            System.out.print("\n     Sort by rent: 1");
            System.out.print("\n    Sort by rooms: 2");
            System.out.print("\n             Exit: 5\n");

            System.out.print("Input: ");

            val = input.nextInt();

            if(val >= 0 && val <= 2) {
                switch (val) {
                    case 0:
                        Collections.sort(apartmentList, new Comparator<Apartment>() {              // Sort by district
                            @Override
                            public int compare(Apartment first, Apartment second) {
                                return first.getDistrict().compareTo(second.getDistrict());
                            }
                        });
                        for (Apartment iterator : apartmentList) {
                            System.out.println(iterator);
                        }
                        break;
                    case 1:
                        Collections.sort(apartmentList, new Comparator<Apartment>() {              // Sort by rent
                            @Override
                            public int compare(Apartment first, Apartment second) {
                                return (int)(first.getRent() - second.getRent());
                            }
                        });
                        for (Apartment iterator : apartmentList) {
                            System.out.println(iterator);
                        }
                        break;
                    case 2:
                        Collections.sort(apartmentList, new Comparator<Apartment>() {              // Sort by rooms
                            @Override
                            public int compare(Apartment first, Apartment second) {
                                return (first.getRooms() - second.getRooms());
                            }
                        });
                        for (Apartment iterator : apartmentList) {
                            System.out.println(iterator);
                        }
                        break;
                }
            }
        } while (val != 5);
    }

    private static void showSerialMenu() {
        Scanner input = new Scanner(System.in);
        int val;
        do {

            System.out.print("\n  Serialize: 0");
            System.out.print("\n Deserilize: 1");
            System.out.print("\n       Exit: 5\n");

            System.out.println("Input: ");
            val = input.nextInt();

            if(val >= 0 && val <= 1) {
                switch (val) {
                    case 0:
                        serializeApartment();
                        break;
                    case 1:
                        deserializeApartment();
                        break;
                }
            }


        } while (val != 5);
    }

    private static Apartment createApartment() {
        double rent;
        int rooms;
        int size;
        String district;

            rent = readDouble("Input rent: ");

            rooms =  readInt("Input rooms: ");

            size = readInt("input size: ");

            district = readString("Input district: ");

        System.out.println("Apartment successfully added!");

        return new Apartment(rent, rooms, size, district);
    }

    private static void deleteApartment() {
        Scanner input = new Scanner(System.in);
        if (apartmentList.size() != 0) {
            int counter = 0;
            for (Apartment iterator : apartmentList) {
                System.out.println(counter++ + ")." + iterator);
            }
            System.out.println("Choose apartment to delete: ");
            int val02 = input.nextInt();
            apartmentList.remove(val02);
            System.out.println("Apartment successfully deleted");
        }
        else System.out.println("No apartments exist!");
    }

    public static void serializeApartment() {
        ObjectOutputStream objOutStream = null;
        try {
            Collections.sort(apartmentList, new Comparator<Apartment>() {              // Sort by rent
                @Override
                public int compare(Apartment first, Apartment second) {
                    return (int)(first.getRent() - second.getRent());
                }
            });

            objOutStream = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + "Apartment backup.txt")));
            for (Apartment iterator : apartmentList) {
                objOutStream.writeObject(iterator);
            }
            objOutStream.flush();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NotSerializableException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objOutStream != null) objOutStream.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void deserializeApartment() {
        File f = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Apartment backup.txt");
        if (f.exists()) {

            ObjectInputStream objOutStream = null;
            try {
                objOutStream = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Apartment backup.txt")));

                Apartment obj = ((Apartment) objOutStream.readObject());
                System.out.println(obj);

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            finally{
                try {
                    if(objOutStream != null)objOutStream.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        else System.out.println(" No backup files are exist!\n");
    }

    public static String readString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);

        return input.nextLine();
    }

    public static double readDouble(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        try {
            return Double.parseDouble(input.nextLine());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0.0F;
    }

    public static int readInt(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        try {
            return Integer.parseInt(input.nextLine());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

}