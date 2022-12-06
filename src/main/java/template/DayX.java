package template;

import ARUtils.Logg;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DayX
{
    static Logg log = new Logg(DayX.class, Logg.Level.INFO);

    private static final String DAY = DayX.class.getSimpleName().toLowerCase();
    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/easyInput.txt";
//    private static final String INPUTPATH = System.getProperty("user.dir") + "/src/main/java/"+DAY+"/input.txt";

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        try (Scanner sc = new Scanner(new File(INPUTPATH)))
        {
            int sum=0;
            while(sc.hasNext())
            {
                String str = sc.nextLine();

            }
            log.info("Sum: "+sum);
            log.info("Duration: "+ (System.currentTimeMillis()-start)+"ms");
        }
        catch(IOException ex)
        {
            log.error("FNF");
        }
    }
}
