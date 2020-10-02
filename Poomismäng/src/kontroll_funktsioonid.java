public class kontroll_funktsioonid {
    public static String kontrolli_sõna(String sõna, String peidetud_sõna, char täht){
        char[] x = peidetud_sõna.toCharArray();
        for (int i = 0; i < sõna.length(); i++){
            if (sõna.charAt(i) == täht){
                x[i] = täht;
                peidetud_sõna = String.valueOf(x);
            }
        }
        return peidetud_sõna;
    }

    public static boolean kas_on_juba_see_täht_olemas(String sõna, char täht){
        int kogus = 0;
        char[] x = sõna.toCharArray();
        for (int i = 0; i < sõna.length(); i++){
            if (sõna.charAt(i) == täht){
                x[i] = täht;
                sõna = String.valueOf(x);
                kogus++;
            }
        }
        if(kogus == 0) return false;
        else return true;
    }

    public static boolean kontrolli_lahendust(String abi, String peidetud_sõna){
        if (abi.equals(peidetud_sõna)) return true;
        else return false;
    }
}
