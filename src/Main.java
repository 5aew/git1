class Main {
    enum RNum{
        I("I",1),II("II",2),III("III",3),IV("IV",4),V("V",5),
        VI("VI",6),VII("VII",7),VIII("VIII",8),IX("IX",9),X("X",10),
        XI("XI",11),XII("XII",12),XIII("XIII",13),XIV("XIV",14),XV("XV",15),
        XVI("XVI",16),XVII("XVII",17),XVIII("XVIII",18),XIX("XIX",19),XX("XX",20),
        XXI("XXI",21),XXII("XXII",22),XXIII("XXIII",23),XXIV("XXIV",24),XXV("XXV",25),
        XXVI("XXVI",26),XXVII("XXVII",27),XXVIII("XXVIII",28),XXIX("XXIX",29),XXX("XXX",30),
        XXXI("XXXI",31),XXXII("XXXII",32),XXXIII("XXXIII",33),XXXIV("XXXIV",34),XXXV("XXXV",35),
        XXXVI("XXXVI",36),XXXVII("XXXVII",37),XXXVIII("XXXVIII",38),XXXIX("XXXIX",39),XL("XL",40),
        XLI("XLI",41),XLII("XLII",42),XLIII("XLIII",43),XLIV("XLIV",44),XLV("XLV",45),
        XLVI("XLVI",46),XLVII("XLVII",47),XLVIII("XLVIII",48),XLIX("XLIX",49),L("L",50),
        LI("LI",51),LII("LII",52),LIII("LIII",53),LIV("LIV",54),LV("LV",55),
        LVI("LVI",56),LVII("LVII",57),LVIII("LVIII",58),LIX("LIX",59),LX("LX",60),
        LXI("LXI",61),LXII("LXII",62),LXIII("LXIII",63),LXIV("LXIV",64),LXV("LXV",65),
        LXVI("LXVI",66),LXVII("LXVII",67),LXVIII("LXVIII",68),LXIX("LXIX",69),LXX("LXX",70),
        LXXI("LXXI",71),LXXII("LXXII",72),LXXIII("LXXIII",73),LXXIV("LXXIV",74),LXXV("LXXV",75),
        LXXVI("LXXVI",76),LXXVII("LXXVII",77),LXXVIII("LXXVIII",78),LXXIX("LXXIX",79),LXXX("LXXX",80),
        LXXXI("LXXXI",81),LXXXII("LXXXII",82),LXXXIII("LXXXIII",83),LXXXIV("LXXXIV",84),LXXXV("LXXXV",85),
        LXXXVI("LXXXVI",86),LXXXVII("LXXXVII",87),LXXXVIII("LXXXVIII",88),LXXXIX("LXXXIX",89),XC("XC",90),
        XCI("XCI",91),XCII("XCII",92),XCIII("XCIII",93),XCIV("XCIV",94),XCV("XCV",95),
        XCVI("XCVI",96),XCVII("XCVII",97),XCVIII("XCVIII",98),XCIX("XCIX",99),C("C",100);
        private int value;
        private String key;
        RNum(String key, int value) {
            this.value = value;
            this.key = key;
        }
    }
    public static void main(String[] args) {
        System.out.println(calc("III * 10"));
    }
    //Решение должно содержать данный метод
    public static String calc(String inputString) {
        String[] values = inputString.split(" ");
        if(values.length <= 1 || values.length > 3) return "Исключение";
        int[] check = checkValue(values);

        if((check[0] == 1 && check[1] == 1) && (check[2] == 0 && check[3] == 0)) return intCalc(values);
        else if((check[0] == 0 && check[1] == 0) && (check[2] == 1 && check[3] == 1)) return romCalc(values);
        else return "Исключение";
    }
    public static String romCalc(String[] values)
    {
        RNum val1 = RNum.valueOf(values[0]);
        RNum val2 = RNum.valueOf(values[2]);
        int i = 0;
        switch (values[1]) {
            case "+": i = val1.value + val2.value;
                break;
            case "-": i = val1.value - val2.value;
                if(i <= 0) return "Исключение";
                break;
            case "*": i = val1.value * val2.value;
                break;
            case "/": i = val1.value / val2.value;
                break;

            default: return "Исключение";
        }
        RNum[] val3 = RNum.values();
        String res = "";
        for (int elem = 0; elem < val3.length; elem++) {
            if (val3[elem].value == i ) {
                res = val3[elem].key;
                break;
            }
        }
        return res;
    }
    public static String intCalc(String[] values){
        switch (values[1]) {
            case "+": return String.valueOf(Integer.parseInt(values[0]) + Integer.parseInt(values[2]));
            case "-": return String.valueOf(Integer.parseInt(values[0]) - Integer.parseInt(values[2]));
            case "*": return String.valueOf(Integer.parseInt(values[0]) * Integer.parseInt(values[2]));
            case "/": return String.valueOf(Integer.parseInt(values[0]) / Integer.parseInt(values[2]));
            default:  return "Исключение";
        }
    }
    public static int[] checkValue(String[] values)
    {
        int[] flag = new int[4];
        String[] integ = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        for (int i = 0; i < integ.length; i++){
            if(integ[i].equals(values[0])){
                flag[0] = 1;
                break;
            }
        }
        for (int i = 0; i < integ.length; i++){
            if(integ[i].equals(values[2])){
                flag[1] = 1;
                break;
            }
        }
        String[] integRom = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for (int i = 0; i < integ.length; i++){
            if(integRom[i].equals(values[0])){
                flag[2] = 1;
                break;
            }
        }
        for (int i = 0; i < integ.length; i++){
            if(integRom[i].equals(values[2])){
                flag[3] = 1;
                break;
            }
        }
        return flag;
    }
}