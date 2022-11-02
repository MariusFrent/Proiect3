package Administrare;
import java.io.FileWriter;
import java.io.IOException;
public class Logging
{
    private static Logging instance;
    private FileWriter myWriter;

    Logging () {
        try {
            FileWriter myWriter = new FileWriter("Logs");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Logging getInstance ()
    {
        if (null==instance)
        {
            instance = new Logging();
        }
        return instance;
    }

    public void WriteToFile() throws IOException{

        try {

            myWriter.write("Client adaugat cu succes");
            myWriter.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
