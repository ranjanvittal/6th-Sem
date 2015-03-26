#include <stdio.h>
#include "FoodItem.hpp"
#include <stdlib.h>

void FoodItem::food_item(char* name, kick_start_time time_taken,
    int cost, int code
) {
    this->name = name;
    this->time_taken = time_taken;
    this->cost = cost;
    this->code = code;
}

FoodItem* initialize_food_items() {
    FoodItem* food_items = (FoodItem*) malloc((MAX_ITEMS+1)*(sizeof(FoodItem)));
    food_items[1].food_item( (char*) "Veg Puff", 2, 30, 1);
    food_items[2].food_item( (char*) "Doughnut", 6, 50, 2);
    food_items[3].food_item( (char*) "Veg Pizza", 30, 60,3);
    food_items[4].food_item( (char*) "Capuccino", 20, 70, 4);
    food_items[5].food_item( (char*) "Cold Coffee", 25, 80, 5);
    food_items[6].food_item( (char*) "Green Tea", 20, 35, 6);
    food_items[7].food_item( (char*) "Samosa Chat", 2, 20, 7);
    food_items[8].food_item( (char*)  "Ice-cream", 20, 80, 8);
    food_items[9].food_item( (char*) "Milk-Shake", 20, 70, 9);
    food_items[10].food_item( (char*) "Mexican Pasta", 30, 80, 10);
    return food_items;
}
