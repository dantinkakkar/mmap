# mmap
Using [https://en.wikipedia.org/wiki/Mmap](mmap), a Unix system call that maps files/devices into memory to read metadata from a Large Language Model (LLM) file. This is a small snippet to demonstrate usage of mmap and expects the model file(s) to be in a predetermined format. Implementations are defined in C and Java so far.

## C Implementation

This is just a reference implementation for now. To compile, use `gcc mmap.c -o mmap` and to run use `./mmap /path/to/model.bin`. If the argument with the file path is not provided, it will error out saying the number of arguments supplied is invalid.

## Java Implementation

Java implementation uses `MappedByteBuffer` created by the `FileChannel::map` method. To compile, use `javac MMap.java` and to run use `java MMap model.bin`. If the argument to the file path is not provided or too many arguments are provided, it will error out.

The main difference between the two implementations here is the explicit specification of the Little Endian ordering within the Java implementation. This is because C (compiled natively) defaults to the OS' ordering, but Java imposes Big Endian notation by default. Big Endian is more commonly used for network-based use cases and Java assumes an ordering here.
