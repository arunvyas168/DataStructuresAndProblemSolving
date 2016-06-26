package com.company;


/*
    You have some tasks in your Asana account.
    For each ith of them you know its deadline-i - the last day by which it should be completed.
    As you can see in your calendar, today is the day number day.
    Asana labels each task in accordance with its due date:

    If the task is due today or it's already overdue, it is labeled as Today;
    If the task should be completed within a week (but not today),
    i.e. its deadline is somewhere between day + 1 and day + 7 both inclusive, it is labeled as Upcoming;
    All other tasks are labeled as Later;

    Your goal is to find the number of tasks with each label.

    Example

    For deadline = [1, 2, 3, 4, 5] and day = 2, the output should be
    tasksTypes(deadline, day) = [2, 3, 0];
    For deadline = [1, 2, 4, 2, 10, 3, 1, 4, 5, 4, 9, 8] and day = 1, the output should be
    tasksTypes(deadline, day) = [2, 8, 2].

    Input/Output

    [time limit] 3000ms (java)

    [input] array.integer deadline

    Constraints:
    1 ≤ deadline.length ≤ 15,
    1 ≤ deadline[i] ≤ 15.

    [input] integer day

    Constraints:
    1 ≤ day ≤ 10.

    [output] array.integer

    Array of three elements - the number of tasks labeled as Today, Upcoming and Later, respectively.

*/


public class Main {

    public static void main(String[] args) {
        //int[] deadline = {1, 2, 3, 4, 5};
        //int day = 2;
        int[] deadline = {1, 2, 4, 2, 10, 3, 1, 4, 5, 4, 9, 8};
        int day = 1;
        int[] result = tasksTypes(deadline,day);
        for(int i : result){
            System.out.print(i+" ");
        }

    }
    public static int[] tasksTypes(int[] deadline, int day) {
        int[] output = new int[3];
        int today = 0;
        int upcoming = 0;
        int later = 0;
        for(int i=0;i<deadline.length;i++){
            if(deadline[i]<=day){
                today++;
            }else if((deadline[i]>day)&&(deadline[i]<=day+7)){
                upcoming++;
            }else {
                later++;
            }
        }
        output[0] = today;
        output[1] = upcoming;
        output[2] = later;
        return output;
    }
}
