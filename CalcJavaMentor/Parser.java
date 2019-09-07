public class Parser {
    private String str;
    private int indexChar;
    private int frstDigit;
    private int seconDigit;
    private char operation;
    private String  typeFrstDigit;
    private String  typeSeconDigit;
    private String  typeDigit;

    public Parser() {}

    public int getFrstDigit() {
        return frstDigit;
    }

    public int getSeconDigit() {
        return seconDigit;
    }

    public char getOperation() {
        return operation;
    }

    public int getIndexChar() {
        return indexChar;
    }

    public String getTypeFrstDigit() {
        return typeFrstDigit;
    }

    public String getTypeSeconDigit() {
        return typeSeconDigit;
    }

    public void parsStr(String str){
        this.str = str;
        indexChar = indexSymbol();
        frstDigit = digit(0,indexChar);
        typeFrstDigit = typeDigit;
        seconDigit = digit(indexChar+1,str.length());
        typeSeconDigit = typeDigit;
        operation = str.charAt(indexChar);
    }

    private int indexSymbol() {
                int countСhar = 0;
                int indexChar = 0;
                for (int i = 0; i < str.length();i++) {
                    switch (str.charAt(i)) {
                        case '+': indexChar = i;
                                countСhar++;
                            break;
                        case '-': indexChar = i;
                                countСhar++;
                            break;
                        case '*': indexChar = i;
                                countСhar++;
                            break;
                        case '/': indexChar = i;
                                countСhar++;
                            break;
                    }
                }
                if (countСhar!=1 && indexChar < 1 && indexChar > 2 ) {
                    return -1;
                } else return indexChar;
    }

    private int digit (int beginIndex, int endIndex) {
        int dig = 0;
            switch (str.substring(beginIndex, endIndex)) {
                case "0":
                    typeDigit = "arab";
                    dig = 0;
                    break;
                case "1":
                    typeDigit = "arab";
                    dig = 1;
                    break;
                case "2":
                    typeDigit = "arab";
                    dig = 2;
                    break;
                case "3":
                    typeDigit = "arab";
                    dig = 3;
                    break;
                case "4":
                    typeDigit = "arab";
                    dig = 4;
                    break;
                case "5":
                    typeDigit = "arab";
                    dig = 5;
                    break;
                case "6":
                    typeDigit = "arab";
                    dig = 6;
                    break;
                case "7":
                    typeDigit = "arab";
                    dig = 7;
                    break;
                case "8":
                    typeDigit = "arab";
                    dig = 8;
                    break;
                case "9":
                    typeDigit = "arab";
                    dig = 9;
                    break;
                case "10":
                    typeDigit = "arab";
                    dig = 10;
                    break;
                case "I":
                    typeDigit = "roman";
                    dig = 1;
                    break;
                case "II":
                    typeDigit = "roman";
                    dig = 2;
                    break;
                case "III":
                    typeDigit = "roman";
                    dig = 3;
                    break;
                case "IV":
                    typeDigit = "roman";
                    dig = 4;
                    break;
                case "V":
                    typeDigit = "roman";
                    dig = 5;
                    break;
                case "VI":
                    typeDigit = "roman";
                    dig = 6;
                    break;
                case "VII":
                    typeDigit = "roman";
                    dig = 7;
                    break;
                case "IIX":
                    typeDigit = "roman";
                    dig = 8;
                    break;
                case "IX":
                    typeDigit = "roman";
                    dig = 9;
                    break;
                case "X":
                    typeDigit = "roman";
                    dig = 10;
                    break;
                default:
                    dig = -1;
            }
        return dig;
    }
}