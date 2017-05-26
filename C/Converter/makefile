converter: main.o text_to_Binary.o binary_to_Text.o
	gcc main.o text_to_Binary.o binary_to_Text.o -o converter
main.o: main.c
	gcc -c main.c
text_to_Binary.o: text_to_Binary.c
	gcc -c text_to_Binary.c
binary_to_Text.o: binary_to_Text.c
	gcc -c binary_to_Text.c
clean:
	rm core *.o converter
