#ifndef SIMULATE_H
#define SIMULATE_H
#include "FoodItem.hpp"
#include "Table.hpp"

class Simulation {
    Table* tables;
    FoodItem* food_items;
    /*
        This method is present so that one can occupy a table if it is free.
    */
    public:
        Simulation(Table* tables, FoodItem* food_items);//constructor
        /*
            This is used to occupy a free table if necessary.
        */
        int check_and_occupy_table();

        /*
            This method simulates the kickstart cafe by randomly allocating people
            to tables at different times and make them exit at random times while
            maintaining sanity.
        */
        void run();

        ~Simulation();//destructor
};

#endif
