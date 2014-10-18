/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */

class Solution {
public:

    int maxPoints(vector<Point> &points) {
        int res = 0;
        // This set contains all points
        std::set<std::pair<int, int> > pointSet;
        // This map contains the number of points on given coordinates
        std::map<std::pair<int, int>, int> pointCount;
        // Compute the number of points that have same coordinates
        for(int i = 0; i < points.size(); ++i){
            std::pair<int, int> p = std::make_pair(points[i].x, points[i].y);
            if(pointSet.find(p) == pointSet.end()){
                pointSet.insert(p);
                pointCount.insert(std::make_pair(p, 1));
                res = max(res, 1);
            }
            else{
                std::map<std::pair<int, int>, int>::iterator it = pointCount.find(p);
                it->second = it->second + 1;
                res = max(res, it->second);
            }
        }
        
        // Store the number of possible lines
        // In a 2D plane, each line has two keys: slope + drift
        // For lines w/ infinite slope, their slope is DBL_MAX and their drift is x coordinate
        std::map<std::pair<double, double>, int> lineCount;
        std::map<std::pair<double, double>, std::set<std::pair<int, int> > > linePointSet;
        for(std::set<std::pair<int, int> >::iterator from = pointSet.begin(); from != pointSet.end(); ++from){
            std::set<std::pair<int, int> >::iterator to = from;
            for(++to; to != pointSet.end(); ++to){
                int x1 = from->first;
                int x2 = to->first;
                int y1 = from->second;
                int y2 = to->second;
                double slope = 0;
                double drift = 0;
                // Vertical line
                if(x1 == x2){
                    slope = 1e17;
                    drift = (double)(x1);
                }
                else{
                    slope = (double)(y2 - y1)/(double)(x2 - x1);
                    drift = (double)(x2 * y1 - x1 * y2)/(double)(x2 - x1);
                }
                std::pair<double, double> comp = std::make_pair(slope, drift);
                std::pair<int, int> nodeFrom = std::make_pair(x1, y1);
                std::pair<int, int> nodeTo = std::make_pair(x2, y2);
                if(lineCount.find(comp) == lineCount.end()){
                    int ct = pointCount.find(nodeFrom)->second + pointCount.find(nodeTo)->second;
                    lineCount.insert(std::make_pair(comp, ct));
                    std::set<std::pair<int, int> > ptSet;
                    ptSet.insert(nodeFrom);
                    ptSet.insert(nodeTo);
                    linePointSet.insert(std::make_pair(comp, ptSet));
                    res = max(ct, res);
                }
                else{
                    std::set<std::pair<int, int> >& ptSet = linePointSet.find(comp)->second;
                    if(ptSet.find(nodeTo) == ptSet.end()){
                        ptSet.insert(nodeTo);
                        std::map<std::pair<double, double>, int>::iterator it = lineCount.find(comp);
                        int ct = pointCount.find(nodeTo)->second;
                        it->second = it->second + ct;
                        res = max(it->second, res);
                    }
                }
            }
        }
        return res;
    }
};
