package day6;

import ARUtils.Logg;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day6
{
    static Logg log = new Logg(Day6.class, Logg.Level.INFO);

    private static final String DAY = Day6.class.getSimpleName().toLowerCase();
//    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/easyInput.txt";
    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/input.txt";

    static final int FIRST_PART = 4;
    static  final int SECOND_PART = 14;
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        try (Scanner sc = new Scanner(new File(INPUTPATH)))
        {
            while(sc.hasNext())
            {
                List<Character> chars = new LinkedList<>();
                for(char c : sc.next().toCharArray())
                {
                    chars.add(c);
                }
                int count=0;
                boolean trovato=false;
                for(int i=0;i<chars.size()-SECOND_PART;i++)
                {
                    List<Character> subs = new LinkedList<>(chars.subList(i, i + SECOND_PART));
//                    log.info(subs);
                    while(subs.size()>0)
                    {
                        char elem = subs.get(0);
                        subs.remove(0);
                        if(subs.contains(elem))
                        {
//                            log.info("No, altro giro");
                            break;
                        }
                    }
                    if(subs.size()==0)
                    {
                        log.info("Found: "+(count+SECOND_PART));
                        break;
                    }
                    count++;
                }

            }
            log.info("Duration: "+ (System.currentTimeMillis()-start)+"ms");
        }
        catch(IOException ex)
        {
            log.error("FNF");
        }
    }
}
