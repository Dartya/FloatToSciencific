public class Main{

    public static void main(String[] args) {
            double x = 0.0;
            double y = 2.534546;
            double z = 125438.587;
            double t = 0.00046468;
            String mainRes;
            Doubles d1 = new Doubles(x);

            mainRes = d1.toScience(z);
            d1.blabla(x);
            d1.blabla(y);
            System.out.println(mainRes);
            System.out.println(t);
    }
}

class Doubles implements DtS{
    double x;
    String xres = new String();
    Doubles(Double d){
        x = d;
    }

    void blabla(Double x){
        xres = toScience(x);
        System.out.println(xres);
    }
}

interface DtS{

    default String toScience(Double x) {
        String exp = new String("E+");
        String expneg = new String ("E");
        String x_str;
        String x_formatted;
        String result;
        int i = 0;       //стандартный итератор

        if (x != 0.00) {
            if ((x < 1.00) || (x >= 10.00)) {
                if (x < 1.00) {
                    while (x < 1.00) {
                        x = x * 10.00;
                        i--;
                        exp = expneg;
                    }
                } else if (x >= 10.00) {
                    while (x >= 10.00) {
                        x = x / 10.00;
                        i++;
                    }
                }
            }
        }
        x_str = Double.toString(x);
        char[] chars = x_str.toCharArray();
        if (x == 0.0)
            x_formatted = "0.00";
        else
            x_formatted = new String(chars, 0, 4);

        result = new String(x_formatted+exp+i);
        //System.out.println(result);
        return result;
    }
}
