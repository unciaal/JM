public class Test {
   public Test (){};

   public void testStart() {
      normalCheck();
      checkEmptyLine();
      checkDigitFalse();
      expressionTested();
   }
   //Проверка правльных ответов
   private void normalCheck(){
      String expression1 = "2+2";
      String expression2 = "2-2";
      String expression3 = "V*II";
      String expression4 = "III+IIX";
      Calculator calc1 =new Calculator();
      Calculator calc2 =new Calculator();
      Calculator calc3 =new Calculator();
      Calculator calc4 =new Calculator();
      if (calc1.formatResult(expression1).equals("4") && calc2.formatResult(expression2).equals("0")
              && calc3.formatResult(expression3).equals("X") && calc4.formatResult(expression4).equals("XI")){
         System.out.println("Тест норма пройден");
      } else {System.out.println("Тест норма не пройден");};
   }
   //Проверка неверных символов
   private void checkDigitFalse(){
      Inspector checkDigit = new Inspector("Vx&OP");
      if(!checkDigit.isTestPassed()) {
         System.out.println("Проверка неверных символов пройдена");
      } else {
         System.out.println("Проверка неверных символов не пройдена");
      }
   }
   //Проверка не верного выражения
   private void expressionTested(){
      Inspector checkEx = new Inspector("V+5");
      if(!checkEx.isTestPassed()) {
         System.out.println("Проверка не верного выражения пройдена");
      } else {
         System.out.println("Проверка не верного выражения не пройдена");
      }
   }
   //Проверка пустого ввода
   private void checkEmptyLine(){
      Inspector checkEmpLine = new Inspector("");
      if(!checkEmpLine.isTestPassed()) {
         System.out.println("Проверка пустого ввода пройдена");
      } else {
         System.out.println("Проверка пустого ввода не пройдена");
      }
   }
}
