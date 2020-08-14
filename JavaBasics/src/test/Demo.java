import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 * @author XinB
 * @create 2020-05-03-18:44
 */
public class Demo {


    public static void main(String[] args) {
        System.out.println(1f == 0.9999999f);
        System.out.println(1f == 0.99999999f);
    }


    /**
     *
     */
    @Test
    public void test1() throws IOException {

        //
        LocalDate today = LocalDate.now();
        System.out.println(today);
        //
        LocalDate myBirthday = LocalDate.of(1991, 9, 7);
        System.out.println(myBirthday);
        //
        LocalDate.of(2020, Month.MAY, 25);

        //
        LocalDate programmersDay = LocalDate.of(2020, 1, 1).plusDays(255);
        System.out.println(programmersDayguide);

    }
}
