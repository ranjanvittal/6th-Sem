# Makefile
#

CC = g++
SH = bash
CFLAGS = -g
LDFLAGS = -lm


all: simulate

simulate: simulate.o Table.o FoodItem.o kickstart.o
	g++ $(LDFLAGS) $^ -o $@

FoodItem.o: FoodItem.cpp FoodItem.hpp
	g++ -c $(CFLAGS) $< -o $@

Table.o: Table.cpp Table.hpp
	g++ -c $(CFLAGS) $< -o $@

simulate.o: simulate.cpp simulate.hpp
	g++ -c $(CFLAGS) $< -o $@


kickstart.o: kickstart.cpp FoodItem.hpp Table.hpp simulate.hpp
	g++ -c $(CFLAGS) $< -o $@

.PHONY: clean lint test

clean:
	rm -rf *.o
	rm -rf simulate

lint:
