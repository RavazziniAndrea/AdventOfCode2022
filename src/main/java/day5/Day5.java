package day5;

import ARUtils.Logg;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day5
{
    static Logg log = new Logg(Day5.class, Logg.Level.INFO);

    private static final String DAY = Day5.class.getSimpleName().toLowerCase();
//    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/easyInput.txt";
    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/input.txt";

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
            boolean invertita=false;
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

                    if(!invertita)
                    {
                        matr=inverti(matr);
                        invertita=true;
                    }
                    log.info("ALTRO GIROOOOOOOOOOOOOOo");
                    matr = eseguiIstruzioni(s, matr, righe, colonne);
//                    log.info(matr);
                }
                //else empty row and number row, skip
            }
            log.info("\n\nFINITO");
            printaRev(matr);
            log.info("Duration: "+ (System.currentTimeMillis()-start)+"ms");
        }
        catch(IOException ex)
        {
            log.error("FNF: "+INPUTPATH);
        }
    }

    private static List<List<Character>> inverti(List<List<Character>> matr)
    {
        List<List<Character>> rev = new ArrayList<>();
        for(int i=matr.size()-1;i>=0;i--)
        {
            rev.add(matr.get(i));
        }
        return rev;
    }

    private static List<List<Character>> eseguiIstruzioni(String s, List<List<Character>> matr, int righe, int colonne)
    {
        String[] str = s.split(",");
        int move = Integer.parseInt(str[0]);
        int from = Integer.parseInt(str[1])-1;
        int to   = Integer.parseInt(str[2])-1;

//        assert move <= righe; //&& from <= colonne && to <= colonne;

        for(int i=0; i<move;i++)
        {
            int ultimaRigaFrom = -1;
            int ultimaRigaTo = -1;
            for(int x=matr.size()-1;x>=0;x--)
            {
                if(matr.get(x).get(from) != '-' && ultimaRigaFrom == -1)
                {
                    ultimaRigaFrom=x;
                }
                if(matr.get(x).get(to) != '-' && ultimaRigaTo == -1)
                {
                    ultimaRigaTo=x+1;
                }
                if(ultimaRigaFrom != -1 && ultimaRigaTo != -1) break;
            }

//            assert ultimaRigaFrom != -1 || ultimaRigaTo != -1;
//            printaRev(matr);

            if(ultimaRigaTo == matr.size())
            {
                matr.add(new ArrayList<>());
                for(int j=0;j<matr.get(0).size();j++)
                {
                    matr.get(matr.size()-1).add('-');
                }
            }

            //fa dei casini con quel -1 che va fuori bound
            char tmp = matr.get((ultimaRigaFrom==-1)?0:ultimaRigaFrom).get(from);
            assert tmp != '-';
            matr.get((ultimaRigaFrom==-1)?0:ultimaRigaFrom).set(from, '-');
            assert matr.get((ultimaRigaTo==-1)?0:ultimaRigaTo).get(to) == '-';
            matr.get((ultimaRigaTo==-1)?0:ultimaRigaTo).set(to, tmp);

            printaRev(matr);
        }
        return matr;
    }

    private static void printaRev(List<List<Character>> matr)
    {
//        for(List<Character> lc : matr)
        for(int i=matr.size()-1;i>=0;i--)
        {
            log.info(matr.get(i).toString());
        }
        log.info("###################");
    }
}


/*
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
            matr.get(nto-1).set(to, tmp);*/