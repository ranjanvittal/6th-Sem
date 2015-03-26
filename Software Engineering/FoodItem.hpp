#ifndef FOODITEM_H
#define FOODITEM_H

typedef int kick_start_time;

#define MAX_ITEMS 10

class FoodItem {
    public:
        char* name;
        kick_start_time time_taken;
        int cost;
        int code;
    /*
        @param name which refers to the name of the item.
        @param time_taken which refers to the time taken to make the food.
        @param cost which refers to the cost of the food.
        @param code  which is the food code.
    */
    void food_item(char* name, kick_start_time time_taken, int cost, int code);

};

/*
    @return after initializing MAX_ITEMS number of food items, returns
    the pointer corresponding to those number of food items.
*/
FoodItem* initialize_food_items();
#endif
