import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main{
    
    public static int iConverDateToDay(int year, int month, int day) throws ParseException {
        //使用日历的转换
        //先获取当前系统时间
        Calendar calendar = Calendar.getInstance();
        //转换为日期类
        String s = year+"-"+month+"-"+day;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        //转换为当前日期的日历
        calendar.setTime(date);
        //输出是一年的几天
        int a = calendar.get(Calendar.DAY_OF_YEAR);
        return a;
    }
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int ret = iConverDateToDay(year,month,day);
            System.out.println(ret);
        }
    }
    
}
