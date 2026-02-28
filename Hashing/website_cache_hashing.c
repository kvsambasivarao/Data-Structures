/* File Name: website_cache_hashing.c */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 10
#define EMPTY ""

// Structure for cache entry
struct Cache {
    char url[100];
    char content[200];
};

struct Cache cache[SIZE];

// Hash Function (Simple String Hash)
int hashFunction(char *url) {
    int sum = 0;
    for (int i = 0; url[i] != '\0'; i++)
        sum += url[i];
    return sum % SIZE;
}

// Initialize cache
void initialize() {
    for (int i = 0; i < SIZE; i++)
        strcpy(cache[i].url, EMPTY);
}

// Access Website
void accessWebsite(char *url) {
    int index = hashFunction(url);
    int start = index;

    while (strcmp(cache[index].url, EMPTY) != 0) {
        if (strcmp(cache[index].url, url) == 0) {
            printf("Cache HIT: %s\nContent: %s\n", url, cache[index].content);
            return;
        }
        index = (index + 1) % SIZE;
        if (index == start)
            break;
    }

    printf("Cache MISS: Fetching from server...\n");
    strcpy(cache[index].url, url);
    sprintf(cache[index].content, "HTML data of %s", url);
    printf("Stored in cache.\n");
}

// Display Cache
void display() {
    printf("\nCache Table:\n");
    for (int i = 0; i < SIZE; i++) {
        if (strcmp(cache[i].url, EMPTY) == 0)
            printf("Index %d -> EMPTY\n", i);
        else
            printf("Index %d -> %s\n", i, cache[i].url);
    }
}

int main() {
    initialize();
    int choice;
    char url[100];

    while (1) {
        printf("\n1.Access Website\n2.Display Cache\n3.Exit\n");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter URL: ");
                scanf("%s", url);
                accessWebsite(url);
                break;
            case 2:
                display();
                break;
            case 3:
                exit(0);
        }
    }
}
