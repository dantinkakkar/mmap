# mmap
Manthan 2023, Mechanical Sympathy

## C Implementation

This is just a reference implementation for now. To compile, use `gcc mmap.c -o mmap` and to run use `./mmap /path/to/model.bin`. If the argument with the file path is not provided, it will error out saying the number of arguments supplied is invalid.

## Java Implementation

Java implementation uses `MappedByteBuffer` created by the `FileChannel::map` method. To compile, use `javac MMap.java` and to run use `java MMap model.bin`. If the argument to the file path is not provided or too many arguments are provided, it will error out.
