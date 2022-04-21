package frc.robot;

public class Path {
  private double x;
  private double y;
  List<List> path = new List;
  
  public get_pos_after(double dis, double deg) {
    double rad = Math.toRadians(deg);
    double pos_x = dis * Math.cos(rad) + this.x;
    double pos_y = dis * Math.sin(rad) + this.y;
    
    List<Double> position = new Stack<Double>();
    position.add(pos_x);
    position.add(pos_y);
    
    return position;
  }
  
  public set_pos(double new_x, double new_y) {
    this.x = new_x;
    this.y = new_y;
  }
  
  public add_route(double route_x, double route_y) {
    List<Double> new_route_pos = new Stack<Double>();
    new_route_pos.add(route_x);
    new_route_pos.add(route_y);
    this.path.add(new_route_pos);
  }

  public void travel_next() {
    // This is where the next position would be set.
    // The first item in this.path will be selected and then removed
    // Then the robot will chart the directory. It turns the
    // number of degrees it needs to turn in order to get to the next
    // target, and then it travels the distance (the radius)
  }
}