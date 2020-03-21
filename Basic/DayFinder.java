// ? A Java Program to get Day of given Date by user without using library.
// * Written By Codezila.org at 22-03-2020 02:28AM (IST)

import java.util.Scanner;
class DayFinder{
    // Scanner is used to take input from user.
    Scanner sc = new Scanner(System.in);
    int date, month, year;
    String day = null;
    static String[] days = new String[7];

    // These indices are set according to 01/01/1583(Saturday).
    static{
        days[2] = "Monday";
        days[3] = "Tuesday";
        days[4] = "Wednesday";
        days[5] = "Thursday";
        days[6] = "Friday";
        days[0] = "Saturday";
        days[1] = "Sunday";
    }

    // Class Constructor.
    DayFinder(){
        String input = getInput();
        getData(input);
        day = getDay(date, month, year);
        System.out.println("Day on given date("+date+"/"+month+"/"+year+") is : "+day);
    }

    // Main Logic is written here.
    String getDay(int date, int month, int year){
        // Don't change Old Year.
        int oldYear=1583; 
        int leapYear=0;
        // *Getting No. of Leap Years Between Old Year and Given Year.
        for(int i=oldYear ; i<year ; i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                leapYear++;
            }
        }

        // Getting Total No. of days from given date to 01/01/1583.
        int noOfDays = ((year-oldYear-leapYear)*365)+(leapYear*366)+date-1;
        // Getting No. of days of current year.
        for(int i=1; i<month; i++){
            // For days in April, June, Sep, Nov.
            if(i==4 || i==6 || i==9 || i==11){
                noOfDays += 30;
            }else if(i==2){
            // For days in Feb
                noOfDays += year%4==0 && year%400!=0 ? 29 : 28;
            }else{
            // For days in Remaining Months.
                noOfDays += 31;
            }
        }
        //System.out.println(" leap : "+leapYear);
        //System.out.println(" Days : "+noOfDays);
        // *Getting No. of weeks from given Date to 01/01/1583.
        int week = noOfDays/7;
        //System.out.println(" Week : "+week);
        // !Getting Index no to get Day from days[] array.
        int dayIndex = noOfDays-(week*7);
        //System.out.println(" Day Index : "+dayIndex);
        return days[dayIndex];
    }

    //  Getting String Input from user.
    String getInput(){
        System.out.println("Enter Date Month and Year to get Day (DD/MM/YYYY) : ");
        return sc.next();
    }

    // Extracting Date, Month & Year from input String.
    void getData(String input){
        try{
            // Split method is used to split string by "/".
            String[] temp = input.split("/", 3);
            // Casting of string into int.
            date = Integer.parseInt(temp[0]);
            month = Integer.parseInt(temp[1]);
            year = Integer.parseInt(temp[2]);

            // ! Input Date Validation_______30 & 31 should not in feb & 29, 30 & 31 should not if not a Leap year__________31st should not in April, June, Sep, Nov_______________
            if(date>31 || month>12 || year<1583 || (month==2 && ((year%4==0 && year%100!=0 || year%400==0) && date>29) || date>28) || (date>30 && (month==4 || month==6 || month==9 || month==11))){
                throw new Exception("Invalid Date");
            }
        }catch(Exception e){
            System.out.println("Wrong Input :( Please Check Date You Entered \nTry Again!!!");
            getData(getInput());
        }
    }

    public static void main(String[] args){
        DayFinder cz = new DayFinder();
        System.out.println("\n\tCode By codezila.org :)\n\tJoin Us On : <github.com/codezila-org>\n\tFor More Mail Us : <contact@codezila.org>");
    } 
}