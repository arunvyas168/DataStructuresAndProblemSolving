package com.company;


/*

Problem:
    Asana is exploring a smart-workload feature designed to streamline task assignment between coworkers.
    Newly created tasks will be automatically assigned to the team member with the lightest workload.
    For each person the following information is known:

    name - their name, a string containing only uppercase and lowercase letters;
    status - their vacation indicator status, which is "0" if the person is on a vacation, or "1" otherwise;
    projects - the number of projects they are currently involved in;
    tasks - the number of tasks assigned to the report.

    If a person's vacation indicator value is set to "0",
    this means they are on vacation and cannot be assigned new tasks.
    Conversely, a vacation indicator value of "1" means they are open to receive task assignments.

    Asana sorts team members according to their availability.
    Person A has a higher availability than person B if they have fewer tasks to do than B,
    or if these numbers are equal but A has fewer assigned projects than B.
    Put another way, we can say that person A has a higher availability than person B if
    their (tasks, projects) pair is less than the same pair for B.

    Your task is to find the name of the person with the highest availability.
    It is guaranteed that there is exactly one such person.


Example:
    Consider information about two team members:
        John, with status = "1", projects = "2" and tasks = "6", represented as ["John", "1", "2", "6"];
        Martin, with status = "1", projects = "1" and tasks = "5", represented as ["Martin", "1", "1", "5"].

    For this case, the output should be smartAssigning(information) = "Martin".

    Here John and Martin's vacation indicators are both "1", so both of them are open to new assignments.
    Martin is only assigned 5 tasks while John is assigned 6, so Martin has the highest availability.

    For the following employees' information:
        John, with status = "1", projects = "2" and tasks = "6", represented as ["John", "1", "2", "6"];
        Martin, with status = "0", projects = "1" and tasks = "5", represented as ["Martin", "0", "1", "5"];

    the output should be smartAssigning(information) = "John".

    In this example Martin cannot be assigned any new tasks because his vacation indicator is "0".
    Therefore, "John" has the highest availability.

    For the following information:
        John, with status = "1", projects = "1" and tasks = "6", represented as ["John", "1", "1", "6"];
        Martin, with status = "1", projects = "2" and tasks = "6", represented as ["Martin", "1", "2", "6"];

    the output should be smartAssigning(information) = "John".

    Both John and Martin's vacation indicators are "1", and the number of tasks each of them is assigned is 6.
    However, John is involved in just 1 project, while Martin is involved in 2, so John has the highest availability.

Input/Output

    [time limit] 3000ms (java)

    [input] array.array.string information

    Array containing information about team members, where each of information[i] contains exactly 4 elements.

    Constraints:
    1 ≤ information.length ≤ 10,
    1 ≤ information[i][j].length ≤ 6.

    [output] string

    The name of the person with the highest availability.

*/


public class Main {

    public static void main(String[] args) {
        /*String[][] information ={
                {"John","1","2","6"},
                {"Martin","1","1","5"}
        };*/
        /*String[][] information ={
                {"John","1","2","6"},
                {"Martin","0","1","5"}
        };*/
        /*String[][] information ={
                {"John","1","1","6"},
                {"Martin","1","2","6"}
        };*/
        /*String[][] information ={
                {"John","1","10","10"},
        };*/
        String[][] information ={
                {"John","1","1","2"},
                {"Martin","0","0","0"},
                {"Luke","1","2","1"}
        };


        System.out.println("Next Task has to be assigned to: "+smartAssigning(information));
    }

    public static String smartAssigning(String[][] information) {

        String result = "";
        int minTask = Integer.MAX_VALUE;
        int minProject = Integer.MAX_VALUE;

        for (int i=0;i<information.length;i++){
            if(information[i][1] != "0"){
                if(Integer.valueOf(information[i][3])<minTask){
                    minTask = Integer.valueOf(information[i][3]);
                    minProject = Integer.valueOf(information[i][2]);
                    result = information[i][0];
                }else if(Integer.valueOf(information[i][3]) == minTask){
                    if(Integer.valueOf(information[i][2])<minProject){
                        minTask = Integer.valueOf(information[i][3]);
                        minProject = Integer.valueOf(information[i][2]);
                        result = information[i][0];
                    }
                }
            }
        }
        return result;
    }
}
