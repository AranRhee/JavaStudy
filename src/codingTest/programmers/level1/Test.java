package codingTest.programmers.level1;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args){
        String name = "aran";
        //String.valueOf(name.charAt(2));
        System.out.println(name.indexOf("r"));
//        String name2 = "aran2345";
//        System.out.println(name2.contains(name));
//        String name3 = name.replace("n", "n?"); // "aran?"
//        System.out.println(name3);
//        String[] test = {"123","456"};
        LocalDate date = LocalDate.of(2023,01,01);
        System.out.println(date.minusMonths(4).withDayOfMonth(28));


    }
}
