import java.util.Scanner;

public class Calculator {
    private String expStr;
    private String typeDigit;

    Calculator(){};

    public String formatResult(String exp){
        this.expStr = exp;
        String resultUnits = "";
        String resultDecades = "";
        String result = "";
        Integer res = Math.round(calculating()) ;
        int moduleRes = Math.abs(res);
        int units = moduleRes % 10;
        int decades = (moduleRes - units) % 100 /10;
        if(typeDigit.equals("arab")) {
            result = res.toString();
        } else {
            switch (units) {
                case 1: resultUnits = "I";
                    break;
                case 2: resultUnits = "II";
                    break;
                case 3: resultUnits = "III";
                    break;
                case 4: resultUnits = "IV";
                    break;
                case 5: resultUnits = "V";
                    break;
                case 6: resultUnits = "VI";
                    break;
                case 7: resultUnits = "VII";
                    break;
                case 8: resultUnits = "IIX";
                    break;
                case 9: resultUnits = "IX";
                    break;
                case 0: resultUnits = "";
                    break;
            }
            switch (decades) {
                case 1: resultDecades = "X";
                    break;
                case 2: resultDecades = "XX";
                    break;
                case 3: resultDecades = "XXX";
                    break;
                case 4: resultDecades = "XL";
                    break;
                case 5: resultDecades = "L";
                    break;
                case 6: resultDecades = "LX";
                    break;
                case 7: resultDecades = "LXX";
                    break;
                case 8: resultDecades = "LXXX";
                    break;
                case 9: resultDecades= "XC";
                    break;
                case 10: resultDecades= "C";
                    break;
            }
            result = resultDecades + resultUnits;
        }
        return result;
    }

    private int calculating(){
        Parser pars = new Parser();
        int frstDigit;
        int secondDigit;
        int res = 0;
        char operation;
        pars.parsStr(expStr);
        frstDigit = pars.getFrstDigit();
        secondDigit = pars.getSeconDigit();
        operation = pars.getOperation();
        if (pars.getTypeFrstDigit().equals("arab") && pars.getTypeSeconDigit().equals("arab")) {
            typeDigit = "arab";
        } else typeDigit = "roman";

        switch (operation) {
            case '+': res = frstDigit + secondDigit;
                break;
            case '-': res = frstDigit - secondDigit;
                break;
            case '*': res = frstDigit * secondDigit;
                break;
            case '/': res = frstDigit / secondDigit;
                break;
        }
        return res;
    }




}