import Administrare.LivrareMobila;
import Administrare.StocareaDatelor;
import Mobila.Dulap;
import Mobila.Scaun;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Application
{
    private JTextField textNume;
    private JPanel panel;
    private JButton btnAdd;
    private JTextField textPrenume;
    private JTextField textAdresa;
    private JTextField textTip;
    private JTextField textPret;
    private JLabel lblSuccess;
    private JButton btnAfisare;
    private JButton btnPT;
    private JLabel lblPT;
    private JButton btnClear;
    private JTextArea textArea;
    private JLabel lblFail;
    private JComboBox comboBoxMobila;
    private JLabel DimensiuniLabel;
    private JLabel latimeLabel;
    private JLabel lungimeLabel;
    private JTextField textFieldLungime;
    private JTextField textFieldLatime;
    private JTextField textFieldInaltime;
    int nr=0;
    ArrayList<LivrareMobila> arr=new ArrayList<LivrareMobila>();
    public Application ()
    {
        StocareaDatelor stocareaDatelor = StocareaDatelor.getInstance();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = textNume.getText();
                String prenume = textPrenume.getText();
                String adresa = textAdresa.getText();
                    nr++;

                        if(comboBoxMobila.getSelectedItem().equals("Dulap")) {
                            Dulap dulap = new Dulap();

                            try {

                                int lungime = Integer.parseInt(textFieldLungime.getText());
                                int latime = Integer.parseInt(textFieldLatime.getText());
                                int inaltime = Integer.parseInt(textFieldInaltime.getText());
                                dulap.setLatime(latime);
                                dulap.setLungime(lungime);
                                dulap.setInaltime(inaltime);
                                dulap.setPret(lungime * latime * inaltime / 30);

                                arr.add(new LivrareMobila(nume, prenume, adresa, nr, dulap));

                                stocareaDatelor.creareBazaTabel();
                                stocareaDatelor.inBazaDeDate(arr, dulap, nume, prenume, adresa, nr);
                                stocareaDatelor.display();


                                //arr = stocareaDatelor.inArray(arr, dulap, nume, prenume, adresa, nr);
                                //stocareaDatelor.inFisier(arr);

                            }catch(Exception exception) {
                                JOptionPane.showMessageDialog(null, "Introdu datele corect");
                            }
                        }

                if(comboBoxMobila.getSelectedItem().equals("Scaun")) {
                    Scaun scaun = new Scaun();

                    try {

                        int lungime = Integer.parseInt(textFieldLungime.getText());
                        int latime = Integer.parseInt(textFieldLatime.getText());
                        int inaltime = Integer.parseInt(textFieldInaltime.getText());
                        scaun.setLatime(latime);
                        scaun.setLungime(lungime);
                        scaun.setInaltime(inaltime);
                        scaun.setPret(lungime * latime * inaltime / 30);

                        arr.add(new LivrareMobila(nume, prenume, adresa, nr, scaun));

                        stocareaDatelor.creareBazaTabel();
                        stocareaDatelor.inBazaDeDate(arr, scaun, nume, prenume, adresa, nr);
                        stocareaDatelor.display();


                        //arr = stocareaDatelor.inArray(arr, dulap, nume, prenume, adresa, nr);
                        //stocareaDatelor.inFisier(arr);

                    }catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Introdu datele corect");
                    }
                }



                System.out.println(arr);
            }
        });

        btnAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuffer sb = new StringBuffer();
                textArea.setText("Lista e goala!");
                for (LivrareMobila lm : arr)
                {
                    sb.append(lm.toString());

                }
                textArea.setText(sb + "\n\n");
                lblSuccess.setText("");
            }
        });

        btnPT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total=0;
                if (total==0)
                    lblPT.setText("Nu exista date!");
                for (LivrareMobila lm:arr)
                {
                    total+=lm.getMobila().getPret();
                }
                lblPT.setText(String.valueOf(total));
                lblSuccess.setText("");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNume.setText("");
                textPrenume.setText("");
                textAdresa.setText("");
                textFieldInaltime.setText("");
                textFieldLatime.setText("");
                textFieldLungime.setText("");
                lblSuccess.setText("");
                lblPT.setText("");
                lblFail.setText("");
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Proiect II");
        frame.setContentPane(new Application().panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
