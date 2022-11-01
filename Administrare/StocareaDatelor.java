package Administrare;

import Mobila.Dulap;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StocareaDatelor {
    private static volatile StocareaDatelor stocareaDatelor;

    private StocareaDatelor(){}

    public static StocareaDatelor getInstance(){
        StocareaDatelor result = stocareaDatelor;
        if(result == null){
            synchronized (StocareaDatelor.class){
                result = stocareaDatelor;
                if(result == null)
                    stocareaDatelor = result = new StocareaDatelor();
            }
        }
        return result;
    }

    public void inFisier(ArrayList<LivrareMobila> list){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for(LivrareMobila livrareMobila : list) {
                myWriter.write(livrareMobila.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<LivrareMobila> inArray(ArrayList<LivrareMobila> list, Dulap dulap, String nume, String prenume,
                                            String adresa, int numar){
        list.add(new LivrareMobila(nume, prenume, adresa, numar, dulap));
        return list;
    }

    public void creareBazaTabel(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my",
                    "root", "password");
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION "
                    + "(id INTEGER auto_increment, "
                    + "first VARCHAR(255), "
                    + "last VARCHAR(255), "
                    + "adresa VARCHAR(255), "
                    + "PRIMARY KEY ( id ))";
            statement.executeQuery(sql);
            System.out.println("table created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void inBazaDeDate(ArrayList<LivrareMobila> list, Dulap dulap, String nume, String prenume,
                             String adresa, int numar){
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my",
                    "root", "password");
            Statement statement = connection.createStatement();
            String sql = "insert into REGISTRATION(first,last,adresa) values(" + nume + "," + prenume + "," + adresa +")";
            int i = statement.executeUpdate(sql);
            System.out.println(i + "record inserted");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void display(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my",
                    "root", "password");
            Statement statement = connection.createStatement();
            String sql = "select * from REGISTRATION";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                JOptionPane.showMessageDialog(null, resultSet.getInt(1)
                        + " " +resultSet.getArray(2) +" "+ resultSet.getArray(3) + " " +
                        resultSet.getArray(4));
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
