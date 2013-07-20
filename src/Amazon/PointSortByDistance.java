package Amazon;

import java.util.Comparator;

public class PointSortByDistance implements Comparator<Point>{
	public int compare(Point p1, Point p2){
		int distance1 = p1.getX() * p1.getX() + p1.getY() * p1.getY();
		int distance2 = p2.getX() * p2.getX() + p2.getY() * p2.getY();
		if(distance1 < distance2)
			return -1;
		else if(distance1 == distance2)
			return 0;
		else
			return 1;
	}
}
