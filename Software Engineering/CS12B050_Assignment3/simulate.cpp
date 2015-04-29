#include "simulate.hpp"
#include "FoodItem.hpp"
#include "Table.hpp"
#include <stdlib.h>
#include <stdio.h>


typedef int iter;
typedef int choice;
typedef int random_int;



int Simulation::check_and_occupy_table() {
    iter i;
    for(i = 1; i < MAX_TABLES + 1; i++) {
        if(tables[i].status == 0) {
            tables[i].status = 1;
            printf("Table %d is occupied.\n", tables[i].table_no);
            return i;
        }
    }
    return 0;
}
Simulation::Simulation(Table* tables, FoodItem* food_items) {
    this->tables = tables;
    this->food_items = food_items;
}

Simulation::~Simulation() {
    free(tables);
    free(food_items);
}

void Simulation::run() {

    Table occupied_tables[MAX_TABLES+1];
    int occupied = 1;
    choice ch;
    random_int r;
    iter i;
    for(i = 1; i <= 500; i++) {
        r = rand() % 5 + 1;
        iter j;
        for(j = 1; j < occupied; j++) {
            occupied_tables[j].check_delivery(food_items, i);
        }

        if(r == 1) {
            ch = rand() % 5 + 1;
            switch(ch) {
                case 1 :
                {
                    int table_no = check_and_occupy_table();
                    if(table_no != 0) {
                        tables[table_no].status = 1;
                        occupied_tables[occupied] = tables[table_no];
                        occupied++;
                    }
                    break;
                }
                case 2 :
                {
                    if(occupied != 1) {
                        choice which_table = (rand() % occupied-1) + 1;
                        int fl = occupied_tables[which_table].print_bill(food_items, i);
                        if(fl == 1) {
                            for(iter i = which_table; i < occupied-1; i++)
                                occupied_tables[i] = occupied_tables[i+1];
                            occupied--;
                        }
                    }
                    break;
                }
                default : {
                    if(occupied != 1) {
                        choice which_table = (rand() % occupied-1) + 1;
                        occupied_tables[which_table].placing_order(food_items, i);
                    }
                    break;
                }
            }
        }
    }

    iter j;
    for(i = 500; i <= 550; i++) {
        for(j = 1; j < occupied; j++) {
            occupied_tables[j].check_delivery(food_items, i);
        }
        for(j = 1; j < occupied; j++) {
            occupied_tables[j].print_bill(food_items, i);
        }
    }
}
