package com.company;

public class InnerClassDoc {
    public static void main(String[] args){

        //create and test local inner class
        Outer a = new Outer();
        Destination b = a.destination("localInner1");
        System.out.println(b.readLabel());
        //create and test local inner class

        //test Inner if(b) class
        Outer2 p = new Outer2();
        p.getInnerClass(true);
        //test Inner if(b) class

        //test anonymous class
        Outer3 d = new Outer3();
        Contents c = d.contents();
        System.out.println(c.value() + " - anonymous class value");
        //test anonymous class

    }
}


interface Destination{
    String readLabel();
}
interface Contents{
    int value();
}



// 1. local inner class

class Outer{
    public Destination destination (String s){
        class LocalInner implements Destination {
            private final String label;
            private LocalInner (String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new LocalInner(s);
    }
}

// 2. class definition inside a methode

class Outer2{
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip(){ return id; }

            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println("Object created, s - " + s);
        }
    }
    void getInnerClass(boolean b){
        internalTracking(b);
    }
}


// 3. anonymous classes

class Outer3{
    public Contents contents(){
        return new Contents(){
            private int i = 11;
            public int value(){
              return i;
            }
        };
    }
}