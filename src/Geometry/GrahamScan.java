package Geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class GrahamScan {
	public static enum Direction {
		LeftTurn,
		RightTurn,
		Collinear
	}
	
	public static Direction getDirection(Point a, Point b, Point c) {
		int crossProduct = b.minus(a).getCrossProduct(c.minus(a));
		if(crossProduct == 0) {
			return Direction.Collinear;
		} else if(crossProduct < 0) {
			return Direction.RightTurn;
		} else {
			return Direction.LeftTurn;
		}
	}
	
	public static double getAngle(Point a, Point b) {
		return Math.atan2(a.y - b.y, a.x - b.x);
	}
	
	public static List<Point> grahamScan(Point[] arr) {
		int firstIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].y < arr[firstIndex].y) {
				firstIndex = i;
			} else if(arr[i].y == arr[firstIndex].y && arr[i].x < arr[firstIndex].x) {
				firstIndex = i;
			}
		}
		Point first = arr[firstIndex];

		List<Point> stack = Arrays.stream(arr).collect(Collectors.toList());
		stack.sort((a, b) -> Double.compare(getAngle(a,first), getAngle(b,first)));
		
		List<Point> other = new ArrayList<>();
		
		while(stack.size() > 2) {
			Point p1 = stack.get(0);
			Point p2 = stack.get(1);
			Point p3 = stack.get(2);
			Direction d = getDirection(p1, p2, p3);
			if(d == Direction.LeftTurn) {
				other.add(stack.remove(0));
			} else if(d == Direction.RightTurn) {
				stack.remove(1);
				stack.add(0, other.remove(other.size()-1));
			} else {
				stack.remove(1);
			}
		}
		
		other.addAll(stack);
		
		return other;
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[5];
		points[0] = new Point(5,-6);
		points[1] = new Point(1,4);
		points[2] = new Point(3,3);
		points[3] = new Point(6,-2);
		points[4] = new Point(1,1);
		System.out.println(grahamScan(points));
	}
}
