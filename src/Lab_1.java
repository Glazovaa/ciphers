import java.util.*;

public class Lab_1 {
    private static String[] ITEM_STOCKS = {"Ь", "Э", "Й", "Ъ"};

    /**
     * Исполняемый класс
     *
     * @param args аргументы
     */
    public static void main(String[] args) {
        System.out.println("Введите сообщение:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(SimpleSinglePermutation(scanner.nextLine()));
    }

    /**
     * Шифр простой одинарной перестановки
     *
     * @param msg сообщения для зашифровки
     * @return зашифрованное сообщение
     */
    public static String SimpleSinglePermutation(String msg) {
        List<String> code = new ArrayList(); // Массив закодированного сообщения
        String stringCode = ""; // Строка закодированного сообщения
        String[] msgArray = msg.split(""); // Сообщение для кодирования
        Collections.addAll(code, msgArray);
        System.out.println("Введите последовательность");
        Scanner input = new Scanner(System.in);
        // Проверка на корректность 50/50
        String[] keyCode = input.nextLine().split("");

        for (int i = 0; i < msgArray.length; i++)
        {
            code.set(Integer.parseInt(keyCode[i]), msgArray[i]);
        }

        for (String s : code)
        {
            stringCode += s + "\t";
        }
        return stringCode;
    }

    /**
     * Шифр блочной одинарной перестановки.
     *
     * @param msg сообщения для зашифровки
     * @return зашифрованное сообщение
     */
    public static String BlockSinglePermutation(String msg) {
        List<String> code = new ArrayList(); // Массив закодированного сообщения
        String stringCode = ""; // Строка закодированного сообщения
        String[] msgArray; // Сообщение для кодирования
        int blockSize = 0;
        int i = 0;
        int j = 0;

        System.out.println("Введите последовательность: ");
        Scanner input = new Scanner(System.in);
        String[] keyCode = input.nextLine().split("");
        while (msg.length() % keyCode.length != 0)
        {
            msg += ITEM_STOCKS[i];
            i++;
        }
        msgArray = msg.split("");
        Collections.addAll(code, msgArray);
        for (i = 0; i < msgArray.length; i++)
        {
            code.set(Integer.parseInt(keyCode[j]) + blockSize, msgArray[i]);
            j++;
            if (j == keyCode.length)
            {
                j = 0;
                blockSize += keyCode.length;
            }
        }
        for (String s : code)
        {
            stringCode += s + "\t";
        }

        return stringCode;
    }

    /**
     * Шифр табличной маршрутной перестановки.
     *
     * @param msg сообщения для зашифровки
     * @return зашифрованное сообщение
     */
    public static String TableRoutePermutation(String msg) {
        int heightColumn = 4;
        String[][] msgTable = new String[4][6];
        int symbolCount = 0;
        String code = "";

        while (msg.length() % heightColumn != 0)
        {
            msg += "_";
        }
        String[] msgArray = msg.split("");

        for (int i = 0; i < msgTable.length; i++)
        {
            for (int j = 0; j < msgTable[i].length; j++)
            {
                msgTable[i][j] = msgArray[symbolCount];
                symbolCount++;
            }
        }

        for (int j = 0; j < 6; j++)
        {
            for (int i = 0; i < 4; i++)
            {
                code += msgTable[i][j];
            }
        }

        // Вывод
        for (String[] anArr : msgTable)
        {
            for (String anAnArr : anArr)
            {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }
        return code;
    }

    /**
     * Шифр вертикальной перестановки
     *
     * @param msg сообщения для зашифровки
     */
    public static void VerticalPermutation(String msg) {
        String key = "Coconut";//1425376
        char[] message = msg.toCharArray();
        int i = key.length();
        int j = message.length;
        int s = i + j;
        int m = 0;
        while ((s - i) > 0)
        {
            m++;
            s = s - i;
        }
        int f = 0;
        System.out.println(m);
        char[][] strings = new char[m][i];
        for (int x = 0; x < m; x++)
        {
            for (int y = 0; y < i; y++)
            {
                if (f <= j)
                {
                    strings[x][y] = message[f];
                }
                else
                {
                    strings[x][y] = ' ';
                }
                f++;
            }
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][0]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][3]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][1]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][4]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][2]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][6]);
        }
        for (int y = 0; y < m; y++)
        {
            System.out.print(strings[y][5]);
        }
    }

    /**
     * Магический квадрат
     *
     * @param msg сообщения для зашифровки
     */
    public static void MagicSquare(String msg) {
        char[] message = msg.toCharArray();
        if (message.length <= 16)
        {
            int[][] key = new int[][]{{15, 2, 1, 12}, {8, 5, 6, 11}, {4, 9, 10, 7}, {3, 14, 13, 0}};
            char[][] shifr = new char[4][4];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    char ch;
                    if (key[i][j] <= 14)
                    {
                        ch = message[key[i][j]];
                    } else
                    {
                        ch = ' ';
                    }
                    shifr[i][j] = ch;
                }
            }
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    System.out.print(shifr[i][j]);
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Error length message");
        }
    }
}
