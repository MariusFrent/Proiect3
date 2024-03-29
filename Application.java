import Administrare.LivrareMobila;
import Administrare.Logging;
import Administrare.StocareaDatelor;
import Mobila.Dulap;
import Mobila.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

                if(comboBoxMobila.getSelectedItem() == "Dulap") {
                    Dulap dulap = new Dulap();

                    try {

                        int lungime = Integer.parseInt(textFieldLungime.getText());
                        int latime = Integer.parseInt(textFieldLatime.getText());
                        int inaltime = Integer.parseInt(textFieldInaltime.getText());
                        dulap.setLatime(latime);
                        dulap.setLungime(lungime);
                        dulap.setInaltime(inaltime);
                        dulap.setPret((lungime * latime * inaltime) / 3 * 100);
                        nr++;

                        arr.add(new LivrareMobila(nume, prenume, adresa, nr, dulap));

//                        stocareaDatelor.creareBazaTabel();
//                        stocareaDatelor.inBazaDeDate(arr, dulap, nume, prenume, adresa, nr);
//                        stocareaDatelor.display();

                        stocareaDatelor.inFisier(arr);

                    }catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Date gresite!");
                        return;
                    }

                    JOptionPane.showMessageDialog(null,"Client adaugat cu succes!");

                }

                if(comboBoxMobila.getSelectedItem() == "Birou") {
                    Birou birou = new Birou();

                    try {

                        int lungime = Integer.parseInt(textFieldLungime.getText());
                        int latime = Integer.parseInt(textFieldLatime.getText());
                        int inaltime = Integer.parseInt(textFieldInaltime.getText());
                        birou.setLatime(latime);
                        birou.setLungime(lungime);
                        birou.setInaltime(inaltime);
                        birou.setPret((lungime * latime * inaltime) / 3 * 100);
                        nr++;
                        arr.add(new LivrareMobila(nume, prenume, adresa, nr, birou));

//                        stocareaDatelor.creareBazaTabel();
//                        stocareaDatelor.inBazaDeDate(arr, birou, nume, prenume, adresa, nr);
//                        stocareaDatelor.display();

                        stocareaDatelor.inFisier(arr);

                    }catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Date gresite!");
                        return;
                    }

                    JOptionPane.showMessageDialog(null,"Client adaugat cu succes!");

                }

                if(comboBoxMobila.getSelectedItem() == "Pat") {
                    Pat pat = new Pat();

                    try {

                        int lungime = Integer.parseInt(textFieldLungime.getText());
                        int latime = Integer.parseInt(textFieldLatime.getText());
                        int inaltime = Integer.parseInt(textFieldInaltime.getText());
                        pat.setLatime(latime);
                        pat.setLungime(lungime);
                        pat.setInaltime(inaltime);
                        pat.setPret((lungime * latime * inaltime) / 3 * 100);
                        nr++;
                        arr.add(new LivrareMobila(nume, prenume, adresa, nr, pat));

//                        stocareaDatelor.creareBazaTabel();
//                        stocareaDatelor.inBazaDeDate(arr, pat, nume, prenume, adresa, nr);
//                        stocareaDatelor.display();

                        stocareaDatelor.inFisier(arr);

                    }catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Date gresite!");
                        return;
                    }

                    JOptionPane.showMessageDialog(null,"Client adaugat cu succes!");

                }

                if(comboBoxMobila.getSelectedItem() == "Masa") {
                    Masa masa = new Masa();

                    try {

                        int lungime = Integer.parseInt(textFieldLungime.getText());
                        int latime = Integer.parseInt(textFieldLatime.getText());
                        int inaltime = Integer.parseInt(textFieldInaltime.getText());
                        masa.setLatime(latime);
                        masa.setLungime(lungime);
                        masa.setInaltime(inaltime);
                        masa.setPret((lungime * latime * inaltime) / 3 * 100);
                        nr++;
                        arr.add(new LivrareMobila(nume, prenume, adresa, nr, masa));

//                        stocareaDatelor.creareBazaTabel();
//                        stocareaDatelor.inBazaDeDate(arr, masa, nume, prenume, adresa, nr);
//                        stocareaDatelor.display();


                        stocareaDatelor.inFisier(arr);

                    }catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Date gresite!");
                        return;
                    }

                    JOptionPane.showMessageDialog(null,"Client adaugat cu succes!");

                }
            }
        });

        btnAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuffer sb = new StringBuffer();

                for (LivrareMobila lm : arr) {
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

                for (LivrareMobila lm:arr) {
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
        JFrame frame = new JFrame("Proiect III");
        frame.setContentPane(new Application().panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
