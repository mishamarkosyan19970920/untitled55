import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String ex = scn.nextLine();
        int Number;
        char action;
        String[] data;
        if
        (ex.contains(" - ")) {
            data = ex.split(" \\- ");
            action = '-';
        }  else if
        (ex.contains(" + ")) {
            data = ex.split(" \\+ ");
            action = '+';
        } else  if
        (ex.contains(" / ")) {
            data = ex.split(" \\/ ");
            action = '/';
        }    else if
        (ex.contains(" * ")) {
        data = ex.split(" \\* ");
        action = '*';
        }else{    // 8-24 строки проверяем знак
            throw new Exception("Некорректный знак действия");
        }  // ошибка при вводе других знаков
        if (action == '*' || action == '/') {
            if (data[1].contains("\"") ) throw new Exception("Строчку можно делить или умножать только на число");
        }
       // {if (data[1] > 10 ) throw new Exception("fff"); }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {
            writeInQuotes(data[0] + data[1]); //сложение строк

        } else if (action == '*') {
            int N = Integer.parseInt(data[1]);  {if (N > 10 ) throw new Exception("Число не должна быть больше 10"); }
            String result = "";
            for (int i = 0; i < N; i++) {// повторяем строку N раз
                result+=data[0];
            }
            writeInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){ // если в первом выражений нет того что отнимаем, то выводим первое выражение
                writeInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index); // отнимать с того индекса где наблюдается схожесть
                result+=data[0].substring(index+data[1].length());
                // прибавляем к результату длину текст (пример от "501" отнять "0" = "51")
                writeInQuotes(result);
            }
        }else{
            int N = Integer.parseInt(data[1]);
            int division = data[0].length()/N; {if (N > 10 ) throw new Exception("Число не должна быть больше 10"); }
            // длину первого выражения делим на второе выражение
            String result = data[0].substring(0,division);
            writeInQuotes(result);
        }

    }
    static void writeInQuotes(String generalexpression){
        System.out.println("\""+generalexpression+"\"");
    }
}