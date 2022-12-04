package day2;

import ARUtils.Logg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Day2
{
    static Logg log = new Logg(Logg.Level.INFO);
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/main/java/day2/input.txt"));
//            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/main/java/day2/easyInput.txt"));
            int sum = 0;
            while(sc.hasNext())
            {
                String line = sc.nextLine();
                if(line.split(" ").length!=2)
                {
                    //assumo sia arrivato alla fine
                    log.warn("perchè?");
                    break;
                }
//                String s1 = line.split(" ")[0];
//                String s2 = line.split(" ")[1];
                int n1 = getNum(line.split(" ")[0]);
                int n2 = getNum(line.split(" ")[1]);
                log.info(n1+" --- "+n2);

                switch(n2)
                {
                    case 1: //devo perdere
                    {
                        switch(n1)
                        {
                            case 1: sum+=(3);
                                break;
                            case 2: sum+=(1);
                                break;
                            case 3: sum+=(2);
                                break;
                        }
                    }break;
                    case 2: //devo pareggiare
                    {
                        sum+=(n1+3);
                    }
                    break;
                    case 3: //devo vincere
                    {
                        switch(n1)
                        {
                            case 1: sum+=(2+6);
                                break;
                            case 2: sum+=(3+6);
                                break;
                            case 3: sum+=(1+6);
                                break;
                        }
                    }
                    break;
                    default: log.info("what");
                        break;
                }

//                if(n1==n2)
//                {
//                    log.info("pareggio");
//                    sum+=(n2+3);
//                }
//                else
//                {
//                    switch(n2)
//                    {
//                        case 1:
//                        {
//                            if(n1==3)
//                            {
//                                log.info("vinto");
//                                sum+=(n2+6);
//                            }
//                            else
//                            {
//                                log.info("perso");
//                                sum+=(n2+0);
//                            }
//                        }break;
//                        case 2:
//                        {
//                            if(n1==1)
//                            {
//                                log.info("vinto");
//                                sum+=(n2+6);
//                            }
//                            else
//                            {
//                                log.info("perso");
//                                sum+=(n2+0);
//                            }
//                        }
//                        break;
//                        case 3:
//                        {
//                            if(n1==2)
//                            {
//                                log.info("vinto");
//                                sum+=(n2+6);
//                            }
//                            else
//                            {
//                                log.info("perso");
//                                sum+=(n2+0);
//                            }
//                        }
//                        break;
//                        default: log.info("what");
//                    }
                    log.info(sum);
                }
            log.info("sum: "+sum);
        }
        catch (FileNotFoundException e)
        {
            log.error("FNF");
        }

    }

    public static int getNum(String s)
    {
        switch(s.toUpperCase())
        {
            case "A":
            case "X":
                return 1;
            case "B":
            case "Y":
                return 2;
            case "C":
            case "Z":
                return 3;
        }
        log.warn("Eccoci");
        return -1;
    }
}
