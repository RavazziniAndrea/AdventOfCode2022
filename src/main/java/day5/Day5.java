package day5;

import ARUtils.Logg;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day5
{
    static Logg log = new Logg(Day5.class, Logg.Level.INFO);

    private static final String DAY = Day5.class.getSimpleName().toLowerCase();
    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/easyInput.txt";
//    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/input.txt";

//    private static List<List<Character>> matr;
//    public static String[][] mat;

    public static void main(String[] args)
    {
        log.info(DAY);
        long start = System.currentTimeMillis();

        try
        {
            int righe=-1;
            int colonne=-1;
            Scanner sc = new Scanner(new File(INPUTPATH));
            while(sc.hasNext())
            {
                String str = sc.nextLine();
                colonne++;
                if(str.contains("1") && !str.contains("move"))
                {
                    righe=str.split("[0-9]").length;
                    log.info("num: "+righe);
                    break;
                }
            }
            assert righe > 0 && colonne > 0;

//            char[][] matr = new char[colonne][righe];
            List<List<Character>> matr = new ArrayList<>();

            sc = new Scanner(new File(INPUTPATH));
            int count=0;
            while(sc.hasNext())
            {
                String str = sc.nextLine();
                if(str.contains("["))
                {
                    StringBuilder s1 = new StringBuilder(str.replace("[", "")
                            .replace("]", "")
                            .replace("   ", "-")
                            .replace(" ", ""));
                    while(s1.length()<righe) s1.append("-");

                    char[] chars = s1.toString().toCharArray();
                    List<Character> lc = new ArrayList<>();
                    for(int i=0;i<chars.length;i++)
                    {
//                        matr[count][i]=chars[i];
                        lc.add(chars[i]);
                    }
                    matr.add(lc);
                    count++;
                    log.info(matr.toString());
                }
                else if(str.contains("move"))
                {
                    String s = str.replace(" ","")
                            .replace("move", "")
                            .replace("from", ",")
                            .replace("to",",");
                    log.info(s.split(",")[0]);

                    matr = eseguiIstruzioni(s, matr, righe, colonne);
                    log.info(matr);
                }
                //else empty row and number row, skip
            }
            log.info(matr.toString());
            log.info("Duration: "+ (System.currentTimeMillis()-start)+"ms");
        }
        catch(IOException ex)
        {
            log.error("FNF: "+INPUTPATH);
        }
    }

    private static List<List<Character>> eseguiIstruzioni(String s, List<List<Character>> matr, int righe, int colonne)
    {
        String[] str = s.split(",");
        int move = Integer.parseInt(str[0]);
        int from = Integer.parseInt(str[1])-1;
        int to   = Integer.parseInt(str[2])-1;

        assert move <= righe; //&& from <= colonne && to <= colonne;

        for(int i=0; i<move;i++)
        {
            int nfrom = -1;
            int nto = -1;
            for(int x = 0;x<righe;x++)
            {
                if(matr.get(x).get(from) != '-')
                {
                    nfrom=x;
                    break;
                }
            }
            for(int x = 0;x<righe;x++) //Da qui esce nto==-1; perchè fa un giro in più dal move?
            {
                if(matr.get(x).get(to) != '-')
                {
                    nto=x;
                    break;
                }
            }
//            assert nfrom>=0 && nto>=0;
            if(nto==0)
            {
                List<List<Character>> nuoval = new ArrayList<>();
                nuoval.add(new ArrayList<>());
                for(int j=0;j<colonne;j++)
                {
                    nuoval.get(0).add('-');
                }
                nuoval.addAll(matr);
                matr=nuoval;
                nto++;
                nfrom++;
            }

            char tmp = matr.get(nfrom).get(from);
            matr.get(nfrom).set(from, '-');
            matr.get(nto-1).set(to, tmp);


//            char tmp = matr[nfrom][from];
//            matr[nfrom][from] = '-';
//            matr[nto-1][to] = tmp;
//            log.info("");
        }
        return matr;
    }
}
