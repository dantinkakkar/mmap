#include<stdio.h>
#include<sys/mman.h>
#include<fcntl.h>

int main(int argc, char **argv) {
    if (argc != 2) {
        printf("Invalid number of arguments\n");
        return 1;
    }
    char *fileName = *(argv+1);
    printf("File path: %s\n", fileName);
    int fileDescriptor = open(fileName, O_RDONLY);
    size_t bytesToBeMapped = sizeof(int)*7;
    int *ptr = mmap(NULL, bytesToBeMapped, PROT_READ, MAP_SHARED, fileDescriptor, 0);
    printf("dim: %d\n", ptr[0]);
    printf("hidden_dim: %d\n", ptr[1]);
    printf("n_layers: %d\n", ptr[2]);
    printf("n_heads: %d\n", ptr[3]);
    printf("n_kv_heads: %d\n", ptr[4]);
    printf("vocab_size: %d\n", ptr[5]);
    printf("seq_len: %d\n", ptr[6]);
    munmap(ptr, bytesToBeMapped);
    return 0;
}
