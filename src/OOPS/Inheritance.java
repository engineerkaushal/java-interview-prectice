package OOPS;

import java.math.BigDecimal;

class Shape{
    String color;
}
// single level inheritance
class Triangle extends Shape {
    public void area() {
        System.out.println("Display area");
    }
}

// Hirarical inheritance because Trianle and S1 class extend Shape class
class S1 extends Shape {

}
// multi level inheritance
class EquTriangle extends Triangle {

}

public class Inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "Red";
        t1.area();

        String s = "1.23E7";
        StringBuffer sb = new StringBuffer(s);
        BigDecimal b = new BigDecimal(s);
         s= String.valueOf(new BigDecimal(s).setScale(2, BigDecimal.ROUND_UP));
        System.out.println(sb);
    }
}
