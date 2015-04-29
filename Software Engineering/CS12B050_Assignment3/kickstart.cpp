#include<stdio.h>
#include "FoodItem.hpp"
#include "Table.hpp"
#include "simulate.hpp"
#include <time.h>
#include <stdlib.h>

int main() {
    srand(time(0));
    FoodItem* food_items = initialize_food_items();
    Table* tables = initialize_tables();
    Simulation simulation(tables, food_items);
    simulation.run();
}
