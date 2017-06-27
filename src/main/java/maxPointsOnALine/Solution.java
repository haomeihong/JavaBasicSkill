package maxPointsOnALine;

/**
 * Created by wangxiaomin03 on 17/4/26.
 */
public class Solution {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if(points==null){
            return 0;
        }
        if(points.length<=2){
            return points.length;
        }
        int num=0;
        for(int i=0;i<points.length-2;i++){
            int same=0;
            int temp=1;
            Point p1=points[i];
            for(int j=i+1;j<points.length-1;j++){
                Point p2=points[j];
                if((p1.x-p2.x)==0&&(p1.y-p2.y)==0){
                    same++;
                }else{
                    temp++;
                    for(int h=j+1;h<points.length;h++){
                        Point p3=points[h];
                        int v=(p3.x-p1.x)*(p2.y-p1.y)-(p3.y-p1.y)*(p2.x-p1.x);
                        if(v==0){
                            temp++;
                        }
                    }
                }
                num=(temp+same)>num?(temp+same):num;
                temp=1;
            }
        }
        return num;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        Point[] points=new Point[100];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                points[i*10+j]=new Point(i,j);
            }
        }
        int c=solution.maxPoints(points);
        System.out.println(c);

    }
}
