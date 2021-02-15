package com.company;



public class Main {

    public static void main(String[] args) {

        Fibonacci num_goes_brr = new Fibonacci(1444);
        num_goes_brr.printArray();


        
    }
}


class Fibonacci{
    private int[] fibList;
    private GetArray fib_director;

    Fibonacci(int max_value){


        if (max_value < 3){
            System.out.println("That doesn't make sence");
        }
        else if (max_value > Integer.MAX_VALUE){
            System.out.println("Out of bounds");
        }
        else {
            fib_director = new GetArray(max_value);
            fibList = fib_director.getList();
        }



    }
    void printArray(){
        for(int i: fibList){
            System.out.println(i);
        }
    }


}
class GetArray{
    final static int START_FIBONACCI = 1;


    private int[] fib_array;
    private int start = 1;
    private int end = 1;
    private int vessel = 0;
    private int i = 0;

    int final_max_value;

    GetArray(int max_value){
        final_max_value = getMaxValue(max_value);

    }


    private int getMaxValue(int max_value){
        i = 0;
        while (true){
            vessel = end;
            end = end + start;
            if (end > max_value){
                restructFibonacci();
                return i + 3;
            }
            i++;
            start = vessel;

        }

    }
    private void restructFibonacci(){
        this.start = START_FIBONACCI;
        this.end = START_FIBONACCI;

    }
    int[] getList(){
        fib_array = new int[final_max_value];
        fib_array[0] = 0;
        fib_array[1] = START_FIBONACCI;
        fib_array[2] = START_FIBONACCI;
        for(int i = 3; i < final_max_value; i++){
            fib_array[i] = fib_array[i - 1] + fib_array[i - 2];
        }

        return fib_array;
    }

}

