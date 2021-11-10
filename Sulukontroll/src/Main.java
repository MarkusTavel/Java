import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String[] valemid = teeme_massiivi();
        for (int i = 0; i < valemid.length; i++){
            kontrolli_sulge(valemid[i]);
        }
    }

    public static void kontrolli_sulge(String sõne){
        Stack <Character> pinu = new Stack<Character>();
        char[] esimene_valem = new char[(sõne.length())];
        for (int i = 0; i < sõne.length(); i++) {
            esimene_valem[i] = sõne.charAt(i);
        }
        for (int i = 0; i < sõne.length(); i++){
            if(esimene_valem[i] == '(' || esimene_valem[i] == '['){
                pinu.push((Character) esimene_valem[i]);
            }
            if(esimene_valem[i] == ')'){
                pinu.pop();
            }
            if(esimene_valem[i] == ']'){
                pinu.pop();
            }
        }
        //System.out.println(pinu);
        if(pinu.empty()){
            System.out.println("Valem " + sõne + " on korrektne");
        } else {
            System.out.println("Valemis " + sõne + " olevad sulud pole korrektsed");
        }
    }

    public static String[] teeme_massiivi(){
        Path koht = Paths.get("src/valemid.txt");        // fail kust loeme sõnu
        ArrayList<String> sulukontroll = new ArrayList<String>(); // uus list
        try {
            Scanner scanner = new Scanner(new File("src/valemid.txt"));
            while (scanner.hasNextLine()) {
                sulukontroll.add(scanner.nextLine());              // loeme rea kaupa sõnad listi
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String [] valemid = new String[sulukontroll.size()]; // teeme listi suurusega massiivi
        for (int i = 0; i < sulukontroll.size(); i++){ // paneme sõnad massiivi
            valemid[i] = sulukontroll.get(i);
            //System.out.println(arvatavad_sõnad[i]);
        }
        return valemid;
    }

}
