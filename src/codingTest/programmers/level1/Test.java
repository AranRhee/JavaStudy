package aran;

public class Test {
    public static void main(String[] args){
        String name = "aran";
        String name2 = "aran2345";
        System.out.println(name2.contains(name));
        String name3 = name.replace("n", "n?"); // "aran?"
        System.out.println(name3);
        String[] test = {"123","456"};
    }
}
