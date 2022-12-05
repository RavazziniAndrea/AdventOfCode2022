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

    public static void main(String[] args)
    {
        log.info(DAY);
        long start = System.currentTimeMillis();
        String[][] mat;

        try
        {
            int num=-1;
            Scanner sc = new Scanner(new File(INPUTPATH));
            while(sc.hasNext())
            {
                String str = sc.nextLine();
                if(str.contains("1") && !str.contains("move"))
                {
                    num=str.split("[0-9]").length;
                    log.info("num: "+num);
                    break;
                }
            }
            assert num > 0;

            List<List<Character>> matr = new ArrayList<>();
            sc = new Scanner(new File(INPUTPATH));
            while(sc.hasNext())
            {
                String str = sc.nextLine();
                if(str.contains("["))
                {
                    StringBuilder s1 = new StringBuilder(str.replace("[", "")
                            .replace("]", "")
                            .replace("   ", "-")
                            .replace(" ", ""));
                    while(s1.length()<num) s1.append("-");

                    char[] chars = s1.toString().toCharArray();
                    List<Character> l = new ArrayList<>();
                    for(char c:chars)
                    {
                        l.add(c);
                    }
                    log.info(l.toString());
                    matr.add(l);
                }
                else if(str.contains("move"))
                {
                    String s = str.replace(" ","")
                            .replace("move", "")
                            .replace("from", ",")
                            .replace("to",",");
                    log.info(s.split(",")[0]);
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
}
