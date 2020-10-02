import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class sõnade_meetodid {
    public static String[] teeme_massiivi(){
        Path koht = Paths.get("src/sõnad.txt");        // fail kust loeme sõnu
        ArrayList<String> sõnad = new ArrayList<String>(); // uus list
        try {
            Scanner scanner = new Scanner(new File("src/sõnad.txt"));
            while (scanner.hasNextLine()) {
                sõnad.add(scanner.nextLine());              // loeme rea kaupa sõnad listi
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String [] arvatavad_sõnad = new String[sõnad.size()]; // teeme listi suurusega massiivi

        for (int i = 0; i < sõnad.size(); i++){ // paneme sõnad massiivi
            arvatavad_sõnad[i] = sõnad.get(i);
            //System.out.println(arvatavad_sõnad[i]);
        }
        return arvatavad_sõnad;
    }

    public static String muuda(String sõna){
        String asendus = "";
        for (int i = 0; i < sõna.length(); i++){
            asendus = asendus + "*";
        }
        sõna = sõna.replaceAll(sõna,asendus);
        return sõna;
    }
}
