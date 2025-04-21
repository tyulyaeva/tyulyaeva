package inna_tyulyaeva;

public class Main {
    private static double aDouble = 1.1, bDouble = 2.2, infinityFloat, infinityDouble;
    private static int aInt = 1, bInt = 2, cInt = 3, dInt = 4;

    public static void main (String[] args)
    {
        System.out.println("0) Применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int: \n(1+2)/3*4="+(aInt+bInt)/cInt*dInt);
        System.out.println("\n1) Применить несколько арифметических операций ( + , -, * , /) над int и double в одном выражении: \n1+(2.2/1.1)*3="+(aInt+(bDouble/aDouble)*cInt));

        System.out.println("\n2) Применить несколько логических операций ( < , >, >=, <= ):\n1<2.2="+(aInt<bDouble));
        System.out.println("1>2.2="+(aInt>bDouble));
        System.out.println("1>=1="+(aInt>=aInt));
        System.out.println("1.1<=2.2="+(aDouble>=bDouble));

        System.out.println("\n3) Диапазоны значений для типов float и double:");
        System.out.println("- float: 32 бита, диапазон — от 2"+ Float.MIN_VALUE+ " до "+Float.MAX_VALUE);
        System.out.println("- double: 64 бита, диапазон — от "+ Double.MIN_VALUE+ " до "+Double.MAX_VALUE);
        System.out.println("Переполнение при арифметической операции с типом данных float/double происходит, когда присваивают значение, выходящее за пределы объявленного типа данных переменной. " +
                "\nЕсли значение слишком велико или слишком мало.");


        System.out.println("\n4) Получить переполнение при арифметической операции:" );
        infinityFloat = Float.MAX_VALUE * 2;
        infinityDouble = Double.MAX_VALUE * 2;
        System.out.println("Переполнение Float: " + infinityFloat);
        System.out.println("Переполнение Double: " + infinityDouble);
    }
}
