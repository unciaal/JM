import java.io.IOException;

public class Inspector {
    private String str;
    private boolean testPassed = false;
    Parser checkPars = new Parser();
    public Inspector (String str){
        this.str = str;
    }

    public boolean isTestPassed() {
        return testPassed;
    }

    public void   fullСheck(){
        if (checkString() && checkNumberChar() && checkStructure() && checkTypeDigit() &&
                checkFrstDigit() && checkSeconDigit() && checkDivisionByZero()) {
            System.out.print("Проверка пройдена.");
            testPassed = true;
        } else {
            testPassed = false;
        }
    }

    private boolean checkString () {
        try {
            String symbols = "0123456789+-/*IVX";
            for (int i = 0;i < str.length(); i++) {
                boolean chk = false;
                for (int j = 0;j < symbols.length(); j++)
                    if ((str.charAt(i) == symbols.charAt(j))) {
                        chk = true;
                        break;
                    }
                if (!chk) {
                    throw new IOException("В выражении присутствует не допустимый символ");
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkNumberChar() {
        try {
            if (str.length() < 8 && str.length() > 2) {
                return true;
            } else {
                throw new NumberFormatException("Неверное количество символов в выражении");
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkStructure() {
        try {
            checkPars.parsStr(str);
            if (checkPars.getIndexChar() != -1 ) {
                return true;
            } else {
                throw new NumberFormatException("Неверная структура выражения");
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkFrstDigit() {
        try {
            checkPars.parsStr(str);
            if (checkPars.getFrstDigit() != -1 ) {
                return true;
            } else {
                throw new NumberFormatException("Неверное число");
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkSeconDigit() {
        try {
            checkPars.parsStr(str);
            if (checkPars.getSeconDigit() != -1 ) {
                return true;
            } else {
                throw new NumberFormatException("Неверное число");
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkDivisionByZero() {
        try {
            checkPars.parsStr(str);
            if (checkPars.getOperation() == '/' && checkPars.getSeconDigit() == 0 ) {
                throw new NullPointerException("На ноль делить нельзя");
            } else {
                return true;
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkTypeDigit() {
        try {
            checkPars.parsStr(str);
            if (checkPars.getTypeFrstDigit() == checkPars.getTypeSeconDigit() ) {
                return true;
            } else {
                throw new NumberFormatException("Смешивать типы цифр нельзя");
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
