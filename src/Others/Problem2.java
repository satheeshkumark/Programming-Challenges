package Others;

/*
 * @author satheeshkumark
 * 
 * Problem : Given list of points find the nearest point from the origin
 * 
 * Algorithm : In-place sorting using comparator
 * 
 * Runtime : O(n)
 * Space complexity : O(1) 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> pointList = new ArrayList<Point>();
		pointList.add(new Point(0,0));
		for(int i=0, j = 5; i<=5 && j>=0; i++, j--){
				Point p = new Point(i,j);
				pointList.add(p);
		}
		Point nearestPoint = findNearestPoint(pointList);
		System.out.println("(" + nearestPoint.getX() + "," + nearestPoint.getY() + ")");
	}
	
	private static Point findNearestPoint(List<Point> pointList){
		Point nearestPoint = null;
		Collections.sort(pointList, new PointSortByDistance());
		for(Point p:pointList){
			nearestPoint =  p;
			break;
			//System.out.println("(" + p.getX() + "," + p.getY() + ")");
		}
		return nearestPoint;
	}
}
