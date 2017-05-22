package view;

import model.Account;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;



public class GuiForm extends JFrame {

    /**
     * Create the frame.
     */

    protected List<Account> accountList = new ArrayList<Account>();

    public GuiForm(String name, List<Account> accountList) {
        super("Kunde: " + name);
        this.accountList.addAll(accountList);
        getContentPane().setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\berliner_bank_icon.JPG\\").getImage());
        setResizable(false);
        setSize(980, 520);

        JMenuBar jmb = new JMenuBar();
        JMenu customerMenu = new JMenu("Kunden");
        customerMenu.setEnabled(true);
        JMenu infoMenu = new JMenu("Info");
        infoMenu.setEnabled(true);

        JMenuItem itemKunden = new JMenuItem("Suchen...");
        JMenuItem itemInfo = new JMenuItem("Info");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        customerMenu.add(itemKunden);
        customerMenu.add(new JSeparator());
        customerMenu.add(exitItem);
        infoMenu.add(itemInfo);
        jmb.add(customerMenu);
        jmb.add(infoMenu);
        setJMenuBar(jmb);

        mainPanel.add(new topPanel());
        mainPanel.add(new bottomPanel());

        getContentPane().add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    class topPanel extends JPanel {

        public topPanel() {
            setLayout(new BorderLayout());
            List<Account.Transaction> transactionList = new ArrayList<Account.Transaction>();
            JTextArea inputTextArea = new JTextArea();
            for (Account index : accountList)
               transactionList.addAll(index.getSortedTransList("ASC"));
            for (Account.Transaction index : transactionList) {
                inputTextArea.append(index.toString());
                inputTextArea.append("\n");
            }
            inputTextArea.append("\n Gesamt: " + accountList.get(0).getAccountBalance() + " Euro");

            // create a dataset...
//            DefaultPieDataset data = new DefaultPieDataset();
//            data.setValue("Category 1", 43.2);
//            data.setValue("Category 2", 27.9);
//            data.setValue("Category 3", 79.5);
//// create a chart...
//            JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", data, true, true, false);
//
//// create and display a frame...
//            ChartFrame pieChart = new ChartFrame("First", chart);
//            frame.pack();
//            frame.setVisible(true);



            JScrollPane scrollPanelLeft = new JScrollPane(inputTextArea);
            JPanel panelDiagramm = new JPanel();
            JLabel headline = new JLabel("Verteilung");

            headline.setFont(new Font("Arial Bold", Font.BOLD, 20));
            panelDiagramm.add(headline);

            JSplitPane splitPaneTop = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, scrollPanelLeft, panelDiagramm);
            splitPaneTop.setOneTouchExpandable(true);
            splitPaneTop.setDividerSize(10);
            splitPaneTop.setDividerLocation(475);
            splitPaneTop.setResizeWeight(0.5);
            //splitPaneTop.setDividerLocation(getWidth()/2);
            this.add(splitPaneTop, BorderLayout.CENTER);
        }
    }


    class bottomPanel extends JPanel {

        public bottomPanel() {
            this.setLayout(new BorderLayout());

            JLabel lblIban1 = new JLabel("IBAN: DE02100100100823464265");
            JLabel lblIban2 = new JLabel("IBAN: DE02200100100823464265");
            JLabel lblIban3 = new JLabel("IBAN: DE02300100100823464265");

            JLabel lblBalance1 = new JLabel("Kontostand:");
            JLabel lblBalance2 = new JLabel("Kontostand:");
            JLabel lblBalance3 = new JLabel("Kontostand:");

            JTextField txtFieldBalance1 = new JTextField(5);
            JTextField txtFieldBalance2 = new JTextField(5);
            JTextField txtFieldBalance3 = new JTextField(5);

            JLabel lblEuro11 = new JLabel("Euro");
            JLabel lblEuro21 = new JLabel("Euro");
            JLabel lblEuro31 = new JLabel("Euro");


            JLabel lblDeposit = new JLabel("Einzahlung:");
            JTextField txtFieldDeposit = new JTextField(15);
            JLabel lblEuro2 = new JLabel("Euro");

            JLabel lblDisbursment = new JLabel("Auszahlung:");
            JTextField txtFieldDisbursement = new JTextField(15);
            JLabel lblEuro3 = new JLabel("Euro");

            JPanel panelLeft = new JPanel();
            panelLeft.add(lblIban1);
            panelLeft.add(lblBalance1);
            panelLeft.add(txtFieldBalance1);
            panelLeft.add(lblEuro11);
            panelLeft.add(lblDeposit);
            panelLeft.add(txtFieldDeposit);
            panelLeft.add(lblEuro2);
            panelLeft.add(lblDisbursment);
            panelLeft.add(txtFieldDisbursement);
            panelLeft.add(lblEuro3);

            JPanel panelCenter = new JPanel();

            panelCenter.add(lblIban2);
            panelCenter.add(lblBalance2);
            panelCenter.add(txtFieldBalance2);
            panelLeft.add(lblEuro21, 1);

            JPanel panelRight = new JPanel();

            panelRight.add(lblIban3);
            panelRight.add(lblBalance3,1);
            panelRight.add(txtFieldBalance3,1);
            panelLeft.add(lblEuro31, 1);


            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new GridLayout(0, 3));
            containerPanel.add(panelLeft);
            containerPanel.add(panelCenter);
            containerPanel.add(panelRight);


            JPanel dummy = new JPanel();

            JSplitPane splitPaneBottom = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, new JPanel(), containerPanel);
            splitPaneBottom.setOneTouchExpandable(true);
            splitPaneBottom.setDividerSize(8);
            splitPaneBottom.setDividerLocation(0);
            splitPaneBottom.setResizeWeight(0);

            this.add(splitPaneBottom, BorderLayout.CENTER);

        }
    }


    public static void main(String[] args) {
        try {
            //  com.sun.java.swing.plaf.motif.MotifLookAndFeel
            //  com.sun.java.swing.plaf.windows.WindowsLookAndFeel
            //  com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new GuiForm("Mr. X", );
//            }
//        });

    }

}