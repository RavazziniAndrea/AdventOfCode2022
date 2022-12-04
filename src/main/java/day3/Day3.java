package day3;

import ARUtils.Logg;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day3
{
    static Logg log = new Logg(Day3.class, Logg.Level.INFO);
    public static void main(String[] args)
    {
//        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/day3/easyInput.txt")))
        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/day3/input.txt")))
        {
            int sum = 0;
            while(sc.hasNext())
            {
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
//                log.info(str);

                for(char c : str1.toCharArray())
                {
                    if(str2.contains(""+c) && str3.contains(""+c))
                    {
                        int cint = (int)c;
                        if(cint>=65 && cint<=90)
                        {
                            log.info(c+" cint -64+26: "+(cint-64+26));
                            sum+=(cint-64+26);
                        }
                        else if(cint>=97 && cint<=122)
                        {
                            log.info(c+" cint -96: "+(cint-96));
                            sum+=(cint-96);
                        }
                        else
                        {
                            log.warn("WTF");
                        }
//                        log.info("sum adesso: "+sum);
                        break;
                    }
                }

                //prima parte
//                for(char c : str.substring(0,str.length()/2).toCharArray())
//                {
//                    if(str.substring(str.length()/2).contains(""+c))
//                    {
//                        int cint = (int)c;
//                        if(cint>=65 && cint<=90)
//                        {
//                            log.info(c+" cint -64+26: "+(cint-64+26));
//                            sum+=(cint-64+26);
//                        }
//                        else if(cint>=97 && cint<=122)
//                        {
//                            log.info(c+" cint -96: "+(cint-96));
//                            sum+=(cint-96);
//                        }
//                        else
//                        {
//                            log.warn("WTF");
//                        }
////                        log.info("sum adesso: "+sum);
//                        break;
//                    }
//                }
            }
            log.info("sum: "+sum);
        }
        catch(IOException ex)
        {
            log.error("FNF");
        }
    }
}
