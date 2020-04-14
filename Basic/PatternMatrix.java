//? A Java Program which prints the Pattern of Matrix.
// * Written By Codezila.org at 02-04-2020 01:28AM (IST)
/*
 *Ex. 
Input => Enter Any No. : 7
Output => 
        1  2  3  4  5  6  7
        24 25 26 27 28 29 8
        23 40 41 42 43 30 9
        22 39 48 49 44 31 10
        21 38 47 46 45 32 11
        20 37 36 35 34 33 12
        19 18 17 16 15 14 13 
*/


import java.util.Scanner;

class PatternMatrix{
    public static void main(String ...args){

        //_____Scanner Class is used to take user input_____
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Any No. : ");
        int input = sc.nextInt();

        //_____Main Logic is here_____

        //_____Loop for the Column_____
        for(int i=0 ; i < input ; i++ ){

            //_____Loop for the Row____
            for(int j=0 ; j < input ; j++){

                 if(i-1 == j && i <= input/2){

                    //* Incrementing Values (24, 40, 48)
                    System.out.print((input-i)*4*i+" ");

                }else if(j>= i-1 && j < input-i && i <= input/2){

                    //* Incrementing Row Values (1-7, 25-28)
                    System.out.print((((input-i)*4*i)+j-i+1)+" ");

                    if(i==0){
                        //? Only For Spacing in first row
                        System.out.print(" ");
                    }

                }else if( j< input/2 && i < input-j){

                    //* Decrementing left column values (23-19, 39-37)
                    System.out.print((input-j-1)*4*(j+1)+(j-i+1)+" ");

                }else if( j> input/2 && i <= j){

                    //* Incrementing right column values (29-33, 43-45)
                    System.out.print(((input-input%(j+1))*4*(input%(j+1))+j-(input%j-2)+(i-(input%(j+1))))+" ");

                }else if( j >= input-i && i >= input/2){

                    //* Decrementing Row Values (36-34, 18-14)
                    System.out.print((((input-i)*4*i)-j-i-1)+2*(input%i)+" ");

                }

            }
            //______For Changing Line______
            System.out.println();
        }
        //____Scanner Closed_____
        sc.close();
        
        System.out.println("\n\tCode By codezila.org :)\n\tJoin Us On : <github.com/codezila-org>\n\tFor More Mail Us : <contact@codezila.org>");

    }
}
