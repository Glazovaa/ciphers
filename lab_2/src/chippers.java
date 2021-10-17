import java.util.Arrays;

public class chippers {
    public static void main(String[] args) {
        caesar c = new caesar();
        lozung l = new lozung();
        polibian p = new polibian();
        trisemus t = new trisemus();
        omofon o = new omofon();
        vij v = new vij();
        String s = "glazovalexander";
        System.out.println(c.applyCaesar(s,5));
        System.out.println(l.applyLozung(s));
        System.out.println(p.applyPolibian(s));
        System.out.println(t.applytrisemus(s));
        System.out.println(o.applyomofon(s));
        System.out.println(v.applyvij(s));

    }
}
class caesar{
    public caesar(){

    }
    public String applyCaesar(String text, int shift)
    {
        char[] chars = text.toCharArray();
        for (int i=0; i < text.length(); i++)
        {
            char c = chars[i];
            if (c >= 32 && c <= 127)
            {
                int x = c - 32;
                x = (x + shift) % 96;
                if (x < 0)
                    x += 96;
                chars[i] = (char) (x + 32);
            }
        }
        return new String(chars);
    }
}
class lozung{
    public lozung(){

    }
    public String applyLozung(String text)
    {
        char[] chars = text.toCharArray();
        String alfa = "abcdefghijklmnopqrstuvwxyz";
        String beta = "deltabcfghijkmnopqrsuvwxyz";
        char[] alfach = alfa.toCharArray();
        char[] betach = beta.toCharArray();
        char[] edit = new char[text.length()];
        for(int i = 0; i<text.length(); i++){
            int k = 0;
            while (alfach[k] != chars[i]){
                k++;
            }
            edit[i] = betach[k];
        }
        return new String(edit);
    }
}
class polibian{
    public polibian(){

    }
    public String applyPolibian(String text)
    {
        char[] chars = text.toCharArray();
        char[][] alfa = new char[6][6];
        char[] edit = new char[text.length()];
        String alfast = "abcdefghijklmnopqrstuvwxyz__________";
        char[] alfach = alfast.toCharArray();
        int k = 0;
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                alfa[i][j] = alfach[k];
                k++;
            }
        }
        String result = "";
        for (int t = 0; t< chars.length; t++) {
            boolean b = false;
            int i = 0;
            while (b == false & i<6){
                int j = 0;
                while(b == false & j<6){
                    if (chars[t] == alfa[i][j]){
                        result += i;
                        result += j;
                        result += " ";
                        b = true;
                    }
                    j++;
                }
                i++;
            }
        }
        return result;
    }
}

class trisemus{
    public trisemus(){

    }
    public String applytrisemus(String text)
    {
        char[] chars = text.toCharArray();
        char[][] alfa = new char[6][6];
        char[] edit = new char[text.length()];
        String alfast = "deltabcfghijkmnopqrsuvwxyz__________";
        char[] alfach = alfast.toCharArray();
        int k = 0;
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                alfa[i][j] = alfach[k];
                k++;
            }
        }
        String result = "";
        for (int t = 0; t< chars.length; t++) {
            boolean b = false;
            int i = 0;
            while (b == false & i<6){
                int j = 0;
                while(b == false & j<6){
                    if (chars[t] == alfa[i][j]){
                        if (i==6){
                            result += alfa[1][j];
                        }else{
                            result += alfa[i+1][j];
                        }
                        b = true;
                    }
                    j++;
                }
                i++;
            }
        }
        return result;
    }
}

class omofon{
    public omofon(){

    }
    public String applyomofon(String text)
    {
        char[] chars = text.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'a':
                    result += "9 ";
                    break;
                case 'b':
                    result += "48 ";
                    break;
                case 'c':
                    result += "13 ";
                    break;
                case 'd':
                    result += "1 ";
                    break;
                case 'e':
                    result += "14 ";
                    break;
                case 'f':
                    result += "10 ";
                    break;
                case 'g':
                    result += "6 ";
                    break;
                case 'h':
                    result += "23 ";
                    break;
                case 'i':
                    result += "32 ";
                    break;
                case 'j':
                    result += "15 ";
                    break;
                case 'k':
                    result += "4 ";
                    break;
                case 'l':
                    result += "26 ";
                    break;
                case 'm':
                    result += "22 ";
                    break;
                case 'n':
                    result += "18 ";
                    break;
                case 'o':
                    result += "0 ";
                    break;
                case 'p':
                    result += "38 ";
                    break;
                case 'q':
                    result += "94 ";
                    break;
                case 'r':
                    result += "29 ";
                    break;
                case 's':
                    result += "11 ";
                    break;
                case 't':
                    result += "17 ";
                    break;
                case 'u':
                    result += "8 ";
                    break;
                case 'v':
                    result += "34 ";
                    break;
                case 'w':
                    result += "60 ";
                    break;
                case 'x':
                    result += "28 ";
                    break;
                case 'y':
                    result += "21 ";
                    break;
                case 'z':
                    result += "2 ";
                    break;
            }
        }

        return result;
    }
}

class vij{
    public vij(){

    }
    public String applyvij(String text)
    {
        char[] chars = text.toCharArray();
        String alfa = "abcdefghijklmnopqrstuvwxyz";
        char[] alfach = alfa.toCharArray();
        String d = "defghijklmnopqrstuvwxyzabc";
        String e = "efghijklmnopqrstuvwxyzabcd";
        String l = "lmnopqrstuvwxyzabcdefghijk";
        String t = "tuvwxyzabcdefghijklmnopqrs";
        String a = "abcdefghijklmnopqrstuvwxyz";
        char[] dch = d.toCharArray();
        char[] ech = e.toCharArray();
        char[] lch = l.toCharArray();
        char[] tch = t.toCharArray();
        char[] ach = a.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            int k = 0;
            while (alfach[k] != chars[i]){
                k++;
            }
            if (i % 5 == 0){
                result += dch[k];
            }else if (i % 5 == 1){
                result += ech[k];
            }else if (i % 5 == 2){
                result += lch[k];
            }else if (i % 5 == 3){
                result += tch[k];
            }else if (i % 5 == 4){
                result += ach[k];
            }

        }

        return result;
    }
}