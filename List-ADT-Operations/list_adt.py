class ListADT:
    def __init__(self, capacity=10):
        self.elements = []
        self.capacity = capacity

    # Insert element at the head
    def insert_at_head(self, element):
        if len(self.elements) == self.capacity:
            print("List is full")
            return
        self.elements.insert(0, element)

    # Print the list
    def print_list(self):
        for item in self.elements:
            print(item, end=" ")
        print()

# Main execution
if __name__ == "__main__":
    list_adt = ListADT()

    list_adt.insert_at_head(10)
    list_adt.insert_at_head(20)
    list_adt.insert_at_head(30)

    list_adt.print_list()
