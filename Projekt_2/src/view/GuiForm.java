package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiForm extends JFrame {

    /**
     * Create the frame.
     */

    public GuiForm(String name) {
        super("Kunde: " + name);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\berliner_bank_icon.JPG\\").getImage());
        setSize(950, 600);

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

        Container frameContentPane = this.getContentPane();
        frameContentPane.add(new BankPanel());

        setLocationRelativeTo(null);
        setVisible(true);
    }


    class BankPanel extends JPanel {

        public BankPanel() {

            this.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setLayout(new BorderLayout(0, 0));


            //  Create top splitpanel

            JTextArea inputTextArea = new JTextArea();

            JScrollPane scrollPanelLeft = new JScrollPane(inputTextArea);
            JPanel panelDiagramm = new JPanel();

            JLabel headline = new JLabel("Verteilung");
            headline.setFont(new Font("Arial Bold", Font.BOLD, 20));
            panelDiagramm.add(headline);

            Dimension minimumSize = new Dimension(50, 50);
            scrollPanelLeft.setMinimumSize(minimumSize);
            panelDiagramm.setMinimumSize(minimumSize);

            JSplitPane splitPaneTop = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, scrollPanelLeft, panelDiagramm);
            splitPaneTop.setOneTouchExpandable(true);
            splitPaneTop.setDividerSize(10);
            splitPaneTop.setDividerLocation(475);
            splitPaneTop.setResizeWeight(0.5);
            //splitPaneTop.setDividerLocation(getWidth()/2);
            this.add(splitPaneTop, BorderLayout.CENTER);


            //  Create bottom splitpanel

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

            JPanel panelLeft = new JPanel(new GridLayout(4, 3));
            panelLeft.add(lblIban1, 0);
            panelLeft.add(lblBalance1, 1);
            panelLeft.add(txtFieldBalance1, 1);
            panelLeft.add(lblEuro11, 1);
//            panelLeft.add(lblDeposit,2);
//            panelLeft.add(txtFieldDeposit,2);
//            panelLeft.add(lblEuro2,2);
//            panelLeft.add(lblDisbursment,3);
//            panelLeft.add(txtFieldDisbursement,3);
//            panelLeft.add(lblEuro3,3);

            JPanel panelCenter = new JPanel(new GridLayout(4,3));
            //panelCenter.setMinimumSize(new Dimension(200, 200));
            //panelCenter.setSize(300, 200);
            panelCenter.add(lblIban2, 0);
            panelCenter.add(lblBalance2,1);
            panelCenter.add(txtFieldBalance2,1);
            panelLeft.add(lblEuro21, 1);

            JPanel panelRight = new JPanel(new GridLayout(4, 3));
            //panelRight.setMinimumSize(new Dimension(200, 200));
            //panelRight.setSize(300, 200);
            panelRight.add(lblIban3, 0);
            panelRight.add(lblBalance3,1);
            panelRight.add(txtFieldBalance3,1);
            panelLeft.add(lblEuro31, 1);


            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
            bottomPanel.add(panelLeft);
            bottomPanel.add(panelCenter);
            bottomPanel.add(panelRight);



            JSplitPane splitPaneBottom = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
            splitPaneBottom.add(bottomPanel);
            splitPaneBottom.setOneTouchExpandable(true);
            splitPaneBottom.setDividerSize(10);
            //splitPaneBottom.setDividerLocation(475);


            this.add(splitPaneBottom, BorderLayout.PAGE_END);

        }
    }

//    public static void main(String[] args) {
//        try {
//            //  com.sun.java.swing.plaf.motif.MotifLookAndFeel
//            //  com.sun.java.swing.plaf.windows.WindowsLookAndFeel
//            //  com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new GuiForm("Mr. X");
//            }
//        });
//
//    }

}