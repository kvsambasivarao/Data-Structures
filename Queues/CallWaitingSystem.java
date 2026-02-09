/*
 File Name: CallWaitingSystem.java
 Program: Call Waiting System using Queue
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CallWaitingSystem {

    static Queue<Integer> callQueue = new LinkedList<>();

    static void addCall(int callId) {
        callQueue.add(callId);
        System.out.println("Incoming call " + callId + " added to queue.");
    }

    static void handleCall() {
        if (callQueue.isEmpty()) {
            System.out.println("No calls waiting.");
        } else {
            int callId = callQueue.poll();
            System.out.println("Agent handling call " + callId + ".");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, callId;

        do {
            System.out.println("\n--- Call Waiting System ---");
            System.out.println("1. Add Incoming Call");
            System.out.println("2. Handle Call");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Call ID: ");
                    callId = sc.nextInt();
                    addCall(callId);
                    break;
                case 2:
                    handleCall();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
