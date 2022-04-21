package frc.robot;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Path {
  private double x;
  private double y;
  private LinkedList<Vector2> path = new LinkedList<Vector2>();
  private PIDController fwdPID;
  private PIDController turnPID;
  private TalonFX leftMotor;
  private TalonFX rightMotor;
  private double straight_rad = 1.5707963267948966;

  public Path(double x, double y, PIDController fwd_pid, PIDController turn_pid, TalonFX left_motor, TalonFX right_motor) {
    this.fwdPID = fwd_pid;
    this.turnPID = turn_pid;
    this.leftMotor = left_motor;
    this.rightMotor = right_motor;
  }
  
  public Vector2 get_pos_after(double dis, double rad) {
    double pos_x = dis * Math.cos(rad) + this.x;
    double pos_y = dis * Math.sin(rad) + this.y;

    return new Vector2(pos_x, pos_y);
  }
  
  private void set_pos(double new_x, double new_y) {
    this.x = new_x;
    this.y = new_y;
  }
  
  public void add_route(double route_x, double route_y) {
    this.path.add(new Vector2(route_x, route_y));
  }

  public void travel_next() {
    // This is where the next position would be set.
    // The first item in this.path will be selected and then removed
    // Then the robot will chart the directory. It turns the
    // number of degrees it needs to turn in order to get to the next
    // target, and then it travels the distance (the radius)
    Vector2 travel_to = this.path[0];
    double travel_x = travel_to.getX();
    double travel_y = travel_to.getY();
    double distance = Math.sqrt((travel_xx-this.x)^2 + (travel_y-this.y)^2)
    double angle = this.straight_rad - atan2(this.y, distance); //returns radians

    if (angle > 0.5 || angle < -0.5) {
      // This makes the robot only turn if it
      // is significantly off target
      this.turnPID.setTarget(angle);
    }
    this.fwdPID.setTarget(distance);

    path.remove(0);
  }
}