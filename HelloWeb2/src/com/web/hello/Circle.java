package com.web.hello;

public class Circle {
	private double r;

    public Circle() {

//TODO Auto-generated constructor stub


}

    public Circle(double r) {

    this.r=r;

    }

public double getR() {

return r;

}

public void setR(double r) {

this.r = r;

}

public double getArea() {

return (Math.PI)*r*r;

}

public  String  getMessage() {

return "半径为"+r+"的圆面积为"+getArea();

}
}
