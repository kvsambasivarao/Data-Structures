# File Name: call_waiting_system.py
# Program: Call Waiting System using Queue

from collections import deque

call_queue = deque()

def add_call(call_id):
    call_queue.append(call_id)
    print(f"Incoming call {call_id} added to queue.")

def handle_call():
    if not call_queue:
        print("No calls waiting.")
    else:
        call_id = call_queue.popleft()
        print(f"Agent handling call {call_id}.")

while True:
    print("\n--- Call Waiting System ---")
    print("1. Add Incoming Call")
    print("2. Handle Call")
    print("3. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        call_id = int(input("Enter Call ID: "))
        add_call(call_id)
    elif choice == 2:
        handle_call()
    elif choice == 3:
        print("Exiting system...")
        break
    else:
        print("Invalid choice.")
