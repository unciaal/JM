import java.util.Scanner;

public class Main {
    private static Boolean stopСommand = false;

    public static void main(String[] args) {
        readLine();
    }

    public static String readLine(){
        String strLine = null;
        Calculator calc = new Calculator();
        while(!stopСommand){
            Scanner in = new Scanner(System.in);
            strLine = in.next();
            if (strLine.equals("test")) {
                Test test = new Test();
                test.testStart();
            } else if (strLine.equals("stop")) {
                stopСommand = true;
            } else{
                Inspector checkExp = new Inspector(strLine);
                checkExp.fullСheck();
                if (checkExp.isTestPassed()) {
                    String result = calc.formatResult(strLine);
                    System.out.println(" Ответ: " + result);
                } else stopСommand = true;
            }
        }
        return strLine;
    }
}
