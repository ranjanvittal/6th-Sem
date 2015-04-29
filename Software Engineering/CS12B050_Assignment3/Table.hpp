#ifndef TABLE_H
#define TABLE_H

#include "FoodItem.hpp"

#define MAX_TABLES 30
#define MAX_ORDERED 401

class Table {
        FoodItem food_items[MAX_ORDERED];// food items ordered at the table.
        int expected_delivery[MAX_ORDERED];// expected delivery time for the ith food item.
        int items_ordered;// total items ordered.
    public: int table_no;// table no of current table.
    public: int status;// 0 when free and 1 when occupied.
    public:
        /*
            This function is used to initialize all the attributes of a given table
        */
        void initialize_table(int table_no);
        /*
            @param food_item which refers to a food item available at Kickstart.
            @param t is the current kickstart time which is offseted from 8:00 am in minutes.
            It adds food_item to the food list of table.
        */
        void add_food(FoodItem food_item, kick_start_time t);
        /*
            @param food_items which refers to the different food items available at Kickstart.
            @param t is the current kickstart time which is offseted from 8:00 am in minutes.
            This function checks whether some food item is to be delivered at this
            particular point in time and prints it when it is delivered.
        */
        void check_delivery(FoodItem* food_items,  kick_start_time t);
        /*
            @param table which refers to the address of a particular table at Kickstart.
            @param food_items which refers to the different food items available at Kickstart.
            @param t is the current kickstart time which is offseted from 8:00 am in minutes.
        */
        void placing_order(FoodItem* food_items, kick_start_time t);
        /*
            @param food_items which refers to the different food items available at Kickstart.
            @param t is the current kickstart time which is offseted from 8:00 am in minutes.
            This function prints the bill for the current table if all the items
            at this table have been given out. It returns 1 if it is done properly.
            It finally makes its status 0 after leaving.
        */
        int print_bill(FoodItem* food_items, kick_start_time t);
};



/*
    @return after initializing MAX_TABLES number of tables, returns
    the pointer corresponding to those number of tables.
*/
Table* initialize_tables();







#endif
