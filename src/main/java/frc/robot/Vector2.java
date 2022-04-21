package frc.robot;

public class Vector2 {
  private double x;
  private double y;
  
  public Vector2(double set_x, double set_y) {
    this.x = set_x;
    this.y = set_y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double[] getCoords() {
    double[] ret = {this.x, this.y};
    return ret;
  }

  public void setX(double input) {
    this.x = input;
  }

  public void setY(double input) {
    this.y = input;
  }
}

