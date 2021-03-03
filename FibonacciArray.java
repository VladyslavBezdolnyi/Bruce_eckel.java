package com.company;

public class FibonacciArray {
    public static void main(String[] args) {

        Fibonacci obj = new Fibonacci(10000);
        Fibonacci obj2 = new Fibonacci(2000000);

        obj.printArray();
        obj2.printArray();

    }
}

// Fibonacci sequence

class Fibonacci{
    private int[] fibList;
    private GetArray fib_director;

    Fibonacci(int max_value){


        if (max_value < 3){
            System.out.println("That doesn't make sense");
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

    int final_max_value;

    GetArray(int max_value){
        final_max_value = getMaxValue(max_value);

    }


    private int getMaxValue(int max_value){
        int i = 0;
        int start = 1;
        int end = 1;
        while (true){
            int vessel = end;
            end = end + start;
            if (end > max_value){
                return i + 3;
            }
            i++;
            start = vessel;

        }

    }

    int[] getList(){
        int[] fib_array = new int[final_max_value];
        fib_array[0] = 0;
        fib_array[1] = 1;
        fib_array[2] = 1;
        for(int i = 3; i < final_max_value; i++){
            fib_array[i] = fib_array[i - 1] + fib_array[i - 2];
        }

        return fib_array;
    }

}