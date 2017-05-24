package view;

import model.Account;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GuiForm extends JFrame {

    /**
     * Create the frame.
     */

    protected List<Account> accountList = new ArrayList<Account>();

    public GuiForm(String name, List<Account> accountList) {
        super("Kunde: " + name);
        this.accountList.addAll(accountList);

        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\berliner_bank_icon.JPG\\").getImage());
        //setResizable(false);
        setBounds(10, 10, 1100, 620);

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

        getContentPane().add(new bankPanel(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    class bankPanel extends JPanel {

        public bankPanel() {
            JTextArea inputTextArea = new JTextArea();
            List<Account.Transaction> transactionList = new ArrayList<Account.Transaction>();
            Border border = new BevelBorder(BevelBorder.RAISED, Color.gray, Color.gray);

            this.setLayout(new BorderLayout());
            this.setBorder(border);

            for (Account index : accountList)
                transactionList.addAll(index.getSortedTransList("ASC"));

            for (Account.Transaction index : transactionList) {
                inputTextArea.append(index.toString());
                inputTextArea.append("\n");
            }
            inputTextArea.append("\n Gesamt: " + accountList.get(0).getAccountBalance() + " Euro");

            DefaultPieDataset data = new DefaultPieDataset();

            for (Account.Transaction index: transactionList) {
                data.setValue(index.toString().substring(0, 20), index.getAmount());
            }

            JFreeChart chart = ChartFactory.createPieChart("Verteilung", data, true, true, false);
            chart.getPlot().setBackgroundPaint(Color.white);

            //ChartPanel chartPanel = new ChartPanel(chart, 320, 220, 150, 150, 300, 350, false, false, false, false, false, true);
            ChartPanel chartPanel = new ChartPanel(chart);

            JScrollPane scrollPanelLeft = new JScrollPane(inputTextArea);

            JSplitPane innerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, scrollPanelLeft, chartPanel);
            innerSplitPane.setOneTouchExpandable(true);
            innerSplitPane.setDividerSize(10);
            innerSplitPane.setDividerLocation(500);
            innerSplitPane.setResizeWeight(0.5);
            //innerSplitPane.setDividerLocation(getWidth()/2);


            JLabel lblIban1 = new JLabel("IBAN: DE02100100100823464265");
            JLabel lblIban2 = new JLabel("IBAN: DE02200100100823464265");
            JLabel lblIban3 = new JLabel("IBAN: DE02300100100823464265");

            JLabel lblBalance1 = new JLabel("Kontostand:");
            JLabel lblBalance2 = new JLabel("Kontostand:");
            JLabel lblBalance3 = new JLabel("Kontostand:");

            JTextField txtFieldBalance1 = new JTextField(15);
            JTextField txtFieldBalance2 = new JTextField(15);
            JTextField txtFieldBalance3 = new JTextField(15);

            JLabel lblEuro11 = new JLabel("Euro");
            JLabel lblEuro12 = new JLabel("Euro");
            JLabel lblEuro13 = new JLabel("Euro");

            JLabel lblDeposit1 = new JLabel("Einzahlung:");
            JLabel lblDeposit2 = new JLabel("Einzahlung:");
            JLabel lblDeposit3 = new JLabel("Einzahlung:");

            JTextField txtFieldDeposit1 = new JTextField(15);
            JTextField txtFieldDeposit2 = new JTextField(15);
            JTextField txtFieldDeposit3 = new JTextField(15);

            JLabel lblEuro21 = new JLabel("Euro");
            JLabel lblEuro22 = new JLabel("Euro");
            JLabel lblEuro23 = new JLabel("Euro");

            JLabel lblDisbursment1 = new JLabel("Auszahlung:");
            JLabel lblDisbursment2 = new JLabel("Auszahlung:");
            JLabel lblDisbursment3 = new JLabel("Auszahlung:");

            JTextField txtFieldDisbursement1 = new JTextField(15);
            JTextField txtFieldDisbursement2 = new JTextField(15);
            JTextField txtFieldDisbursement3 = new JTextField(15);

            JLabel lblEuro31 = new JLabel("Euro");
            JLabel lblEuro32 = new JLabel("Euro");
            JLabel lblEuro33 = new JLabel("Euro");


            JPanel panelLeft = new JPanel();
            //panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
            panelLeft.setBorder(border);
            panelLeft.setBackground(Color.WHITE);
            panelLeft.add(lblIban1);
//            panelLeft.add(lblBalance1);
//            panelLeft.add(txtFieldBalance1);
//            panelLeft.add(lblEuro11);
//            panelLeft.add(lblDeposit1);
//            panelLeft.add(txtFieldDeposit1);
//            panelLeft.add(lblEuro12);
//            panelLeft.add(lblDisbursment1);
//            panelLeft.add(txtFieldDisbursement1);
//            panelLeft.add(lblEuro13);

            JPanel panelCenter = new JPanel();
            //panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
            panelCenter.setBorder(border);
            panelCenter.setBackground(Color.WHITE);
            panelCenter.add(lblIban2);
//            panelCenter.add(lblBalance2);
//            panelCenter.add(txtFieldBalance2);
//            panelCenter.add(lblEuro21);
//            panelCenter.add(lblDeposit2);
//            panelCenter.add(txtFieldDeposit2);
//            panelCenter.add(lblEuro22);
//            panelCenter.add(lblDisbursment2);
//            panelCenter.add(txtFieldDisbursement2);
//            panelCenter.add(lblEuro23);

            JPanel panelRight = new JPanel();
            //panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
            panelRight.setBorder(border);
            panelRight.setBackground(Color.WHITE);
            panelRight.add(lblIban3);
//            panelRight.add(lblBalance3);
//            panelRight.add(txtFieldBalance3);
//            panelRight.add(lblEuro31);
//            panelRight.add(lblDeposit3);
//            panelRight.add(txtFieldDeposit3);
//            panelRight.add(lblEuro32);
//            panelRight.add(lblDisbursment3);
//            panelRight.add(txtFieldDisbursement3);
//            panelRight.add(lblEuro33);


            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));
            containerPanel.add(panelLeft);
            containerPanel.add(panelCenter);
            containerPanel.add(panelRight);


            JSplitPane outerSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, innerSplitPane, containerPanel);
            outerSplitPane.setOneTouchExpandable(true);
            outerSplitPane.setDividerSize(8);
            outerSplitPane.setDividerLocation(330);
            outerSplitPane.setResizeWeight(0);

            this.add(outerSplitPane, BorderLayout.CENTER);
        }
    }


    public static void main(String[] args) {
        try {
            //  com.sun.java.swing.plaf.motif.MotifLookAndFeel
            //  com.sun.java.swing.plaf.windows.WindowsLookAndFeel
            //  com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
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