package src.com.GS;

import java.util.*;

public class LargestTree {

    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int child : immediateParent.keySet()){
            int parent  = immediateParent.get(child);
            if(map.containsKey(child)){
                map.get(child).add(parent);
            }else{
                map.put(child, new ArrayList<>());
            }
            if(map.containsKey(parent)){
                map.get(parent).add(child);
            }else{
                map.put(parent, new ArrayList<>());
            }
        }

        Set<Integer> visited = new HashSet<>();
        int maxTreeLen = 0;
        int minTreeRoot = Integer.MAX_VALUE;

        for(int parent : immediateParent.values()){
            if(!visited.contains(parent)){
                List<Integer> visitedNodes = new ArrayList<>();
                visit(map, visited, visitedNodes, parent);
                if(visitedNodes.size() >= maxTreeLen) {
                    maxTreeLen = visitedNodes.size();
                    int rootTree = findMinTreeRoot(visitedNodes, immediateParent);
                    if(minTreeRoot > rootTree) {
                        minTreeRoot = rootTree;
                    }
                }
            }
        }
        return minTreeRoot;
    }

    private static int findMinTreeRoot(List<Integer> visitedNodes, Map<Integer, Integer> immediateParent) {
        for(int child : visitedNodes) {
            if(!immediateParent.containsKey(child)){
                return child;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void visit(Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> visitedNodes, int parent) {
        visited.add(parent);
        visitedNodes.add(parent);
        for(int i=0;i<map.get(parent).size();i++){
            int adj = map.get(parent).get(i);
            if(!visited.contains(adj)){
                visit(map, visited, visitedNodes, adj);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(4,5);
        map.put(6,7);
        map.put(2,3);
        map.put(1,2);
        map.put(3,4);

        int ans = largestTree(map);
        System.out.println(ans);
    }
}
