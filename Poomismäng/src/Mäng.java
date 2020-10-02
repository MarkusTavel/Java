import java.util.Random;
import java.util.Scanner;

public class Mäng {
    public static char küsi_täht(){
        Scanner sisend = new Scanner(System.in);
        System.out.println("Sisesta täht");
        String valik = sisend.nextLine();
        valik = valik.toUpperCase();
        char valitud_täht = valik.charAt(0);
        return valitud_täht;
    }

    public static void mäng(){
        String [] sõnad = sõnade_meetodid.teeme_massiivi();
        boolean küsimus = false;
        boolean lopp = true;
        int valik = new Random().nextInt(sõnad.length);
        String peidetud_sõna = sõnad[valik];
        String abi = peidetud_sõna;
        String abi_sõna = abi;
        peidetud_sõna = sõnade_meetodid.muuda(peidetud_sõna);
        char valitud_täht;
        System.out.println(peidetud_sõna);
        int lubatud_pakkumisi = 6;
        while (true){
            valitud_täht = küsi_täht();
            abi_sõna = peidetud_sõna;
            if(kontroll_funktsioonid.kas_on_juba_see_täht_olemas(peidetud_sõna,valitud_täht) == true ){
                System.out.println("Selline täht on juba olemas.");
                continue;
            }
            peidetud_sõna = kontroll_funktsioonid.kontrolli_sõna(abi,peidetud_sõna,valitud_täht);
            if (abi_sõna.equals(peidetud_sõna) == true){
                lubatud_pakkumisi--;
                if(lubatud_pakkumisi > 0){
                    System.out.println("Sellist tähte pole. Lubatud pakkumisi on veel "+lubatud_pakkumisi);
                    lopp = false;
                }
            }
            if (lubatud_pakkumisi == 0){
                lubatud_pakkumisi = 6;
                System.out.println("Mäng läbi :( ");
                System.out.println("Õige sõna oli "+ abi);
                break;
            }

            if(kontroll_funktsioonid.kontrolli_lahendust(abi,peidetud_sõna) == true){
                System.out.println(peidetud_sõna + " on õige sõna! Olete võitnud mängu!");
                break;
            }
            System.out.println("Sõna on "+ peidetud_sõna);
            if(lopp == true){
                System.out.println("Lubatud pakkumisi on veel "+lubatud_pakkumisi);
            }
            lopp = true;
        }
    }

    public static boolean küsi_uus_mäng(){
        System.out.println("Kas soovite uuesti mängida?");
        System.out.println("1. Jah");
        System.out.println("2. Ei");
        int valik;
        Scanner sisend = new Scanner(System.in);
        while (true){
            valik = sisend.nextInt();
            if(valik == 1) return true;
            if(valik == 2) return false;
            System.out.println("Sellist valikut pole.");
        }
    }
}
