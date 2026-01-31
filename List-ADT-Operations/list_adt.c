#include <stdio.h>
#include <stdlib.h>

// Define the List structure
typedef struct {
    int *elements;
    int size;
    int capacity;
} List;

// Initialize the list
void list_init(List *list, int capacity) {
    list->elements = (int *)malloc(sizeof(int) * capacity);
    list->size = 0;
    list->capacity = capacity;
}

// Insert an element at the head
void list_insert_at_head(List *list, int element) {
    if (list->size == list->capacity) {
        printf("List is full\n");
        return;
    }

    for (int i = list->size - 1; i >= 0; i--) {
        list->elements[i + 1] = list->elements[i];
    }
    list->elements[0] = element;
    list->size++;
}

// Print the list
void list_print(List *list) {
    for (int i = 0; i < list->size; i++) {
        printf("%d ", list->elements[i]);
    }
    printf("\n");
}

int main() {
    List list;
    list_init(&list, 10);

    list_insert_at_head(&list, 10);
    list_insert_at_head(&list, 20);
    list_insert_at_head(&list, 30);

    list_print(&list);

    free(list.elements);
    return 0;
}
