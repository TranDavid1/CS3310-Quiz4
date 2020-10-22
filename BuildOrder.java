import java.util.*;

public class BuildOrder
{
    public static class Node
    {

        boolean placed = false;
        Set<String> parents;
        Set<String> children;

        public Node()
        {
            parents = new HashSet<String>();
            children = new HashSet<String>();
        } // end Node
    }; // end Node

    public static String[] findOrder(String[] projects, String[][] dependencies)
    {
        HashMap<String, Node> table = new HashMap<String,Node>();

        // Create adjacency list
        for (String currentProject : projects)
        {
            Node currentNode = new Node();
            table.put(currentProject, currentNode);
        }

        for (String[] currentDep : dependencies)
        {
            String first = currentDep[0];
            String second = currentDep[1];
            Node currentNode = table.get(second);
            currentNode.parents.add(first);
            currentNode = table.get(first);
            currentNode.children.add(second);
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<String> available = new LinkedList<String>();
        for (String currentProject : projects)
        {
            Node currentNode = table.get(currentProject);
            if (currentNode.parents.size() == 0)
                available.add(currentProject);
        }

        String[] solution = new String[projects.length];
        int pos = 0;

        // Process until the queue is empty
        while (available.size() > 0)
        {
            String currentProject = available.poll();
            solution[pos] = currentProject;
            pos++;
            Node currentNode = table.get(currentProject);
            for (String currentChild : currentNode.children)
            {
                Node childNode = table.get(currentChild);
                childNode.parents.remove(currentProject);
                if (childNode.parents.size() == 0)
                    available.add(currentChild);
            }
        }

        if (pos < projects.length)
            throw new ArithmeticException("No solution");

        return solution;
    } // end findOrder

    public static void print(String[] arr)
    {
        for (int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    } // end print

    public static void main(String[] args)
    {
        String[] promptProjects = new String[] {
                "a", "b", "c", "d", "e", "f"
        };
        String[][] promptDependencies = new String[][] {
                {"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}
        };
        String[] projects = new String[] {
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D"
        };

        String[][] dependencies = new String[][] {
                {"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"},{"k","a"},{"b","j"},{"j","g"},{"k","i"},{"b","a"},{"i","h"},{"d","m"},{"h","r"},{"g","p"},{"z","x"},{"x","b"},{"g","s"},{"s","k"},{"B","e"},{"b","A"},{"r","q"},{"q","t"},{"B","w"},{"C","f"},{"t","l"},{"h","n"},{"f","w"},{"a","B"},{"q","B"}
        };

        long startTime, endTime;

        System.out.println("Testing with inputs from prompt: ");
        startTime = System.nanoTime();
        String[] promptSolution = findOrder(promptProjects, promptDependencies);
        endTime = System.nanoTime();
        print(promptSolution);
        System.out.println("Elapsed time: " + (endTime - startTime) + " ns\n");

        System.out.println("Testing with larger input:");
        startTime = System.nanoTime();
        String[] solution = findOrder(projects, dependencies);
        endTime = System.nanoTime();
        print(solution);
        System.out.println("Elapsed time: " + (endTime - startTime) + " ns");
    } // end main
}