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
    int nr=0;
    ArrayList<LivrareMobila> arr=new ArrayList<LivrareMobila>();
    public Application ()
    {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = textNume.getText();
                String prenume = textPrenume.getText();
                String tip = textTip.getText();
                String adresa = textAdresa.getText();
                String s = textPret.getText();
                int pret=0;
                try
                {
                    pret = Integer.parseInt(s);
                }
                catch (Exception ex)
                {
                    lblFail.setText("Date gresite!");
                }
                finally
                {
                    if (pret==0)
                        lblSuccess.setText("Incearca din nou!");
                }
                if (pret!=0)
                {
                    nr++;
                    try
                    {
                        arr.add(new LivrareMobila(nume,prenume,nr,tip,adresa,pret));
                    }
                    catch (Exception ex)
                    {
                        lblFail.setText("Date gresite!");
                    }
                    finally
                    {
                        lblSuccess.setText("Client adaugat cu succes!");
                        lblFail.setText("");
                    }
                }
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
                    total+=lm.getPretMobila();
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
                textTip.setText("");
                textAdresa.setText("");
                textPret.setText("");
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
