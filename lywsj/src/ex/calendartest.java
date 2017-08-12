package SwingTest;

import java.text.DateFormatSymbols;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class CalendarTest {
     public static void main(String[] args){        
         GregorianCalendar now = new GregorianCalendar();
         int month = now.get(Calendar.MONTH);
         int today = now.get(Calendar.DAY_OF_MONTH);
         int intent = 0;
         now.set(Calendar.DAY_OF_MONTH,1);
         int week = now.get(Calendar.DAY_OF_WEEK);
         int firstDayOfWeek = now.getFirstDayOfWeek();
         while(firstDayOfWeek != week){
             ++intent;
             now.add(Calendar.DAY_OF_MONTH, -1);
             week = now.get(Calendar.DAY_OF_WEEK);
         }
         String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
         do{
             System.out.printf("%4s",weekdayNames[week]);
             now.add(Calendar.DAY_OF_MONTH, 1);
             week = now.get(Calendar.DAY_OF_WEEK);
         }while(week != firstDayOfWeek);
         System.out.println();
         for(int i = 0;i < intent;++i){
             System.out.print("    ");
         }
         now.set(Calendar.DAY_OF_MONTH, 1);
         week = now.get(Calendar.DAY_OF_WEEK);
         int day = now.get(Calendar.DAY_OF_MONTH);
         do{
             System.out.printf("%3s",day);
             if(today == day){
                 System.out.print("*");
             }else{
                 System.out.print(" ");
             }
             now.add(Calendar.DAY_OF_MONTH, 1);
             week = now.get(Calendar.DAY_OF_WEEK);
             day = now.get(Calendar.DAY_OF_MONTH);
             if(week == firstDayOfWeek){
                 System.out.println();
             }
         }while(month == now.get(Calendar.MONTH));
         if(week != firstDayOfWeek){
             System.out.println();
         }
     }
 }

