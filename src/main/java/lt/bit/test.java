package lt.bit;

public class test {
    public static void print (int number){
        if(number != 1) print(number - 1);
        System.out.println(number);
    }

    public static void main(String[] args) {
        print(5);
    }

    public static void print5 (int number){
        if(number != 1) print4(number - 1);
        System.out.println(number);
    }

    public static void print4 (int number){
        if(number != 1) print3(number - 1);
        System.out.println(number);
    }

    public static void print3 (int number){
        if(number != 1) print2(number - 1);
        System.out.println(number);
    }

    public static void print2 (int number){
        if(number != 1) print1(number - 1);
        System.out.println(number);
    }

    public static void print1 (int number){
        System.out.println(number);
    }

}
