#include "Table.hpp"
#include "FoodItem.hpp"
#include <stdio.h>
#include <stdlib.h>

typedef int iter;

void Table::initialize_table(int table_no) {
    for(iter i = 0; i < MAX_ITEMS; i++) {
        this->expected_delivery[i] = 0;
    }
    this->items_ordered = 0;
    this->status = 0;
    this->table_no = table_no;
}

Table* initialize_tables() {
    Table* tables = (Table*) malloc((MAX_TABLES + 1)*sizeof(Table));
    for(iter i = 1; i < MAX_TABLES + 1; i++) {
        tables[i].initialize_table(i);
    }
    return tables;
}

void Table::add_food(FoodItem food_item, kick_start_time t) {
    int items_ordered = this->items_ordered;
    this->food_items[items_ordered] = food_item;
    this->expected_delivery[items_ordered] = t + food_item.time_taken;
    this->items_ordered++;
}

void Table::check_delivery(FoodItem food_items[], kick_start_time t) {
    int fl = 0;
    int quantity[MAX_ITEMS+1] = {0};
    if(this->status == 0)
        return;
    iter i;
    for( i = 1; i < MAX_ITEMS + 1; i++) {
        quantity[i] = 0;
        for (iter j = 0; j < this->items_ordered; j++) {
            if(this->food_items[j].code == food_items[i].code && this->expected_delivery[j] == t)
                quantity[i]++;
        }
    }

    for( i = 1; i < MAX_ITEMS + 1; i++) {
        if(quantity[i] > 0) {
            printf("Table %d got %d %s delivered at ", this->table_no, quantity[i], this->food_items[i].name);
            if(t%60 > 10)
                printf("%d:%d\n", t/60+8, t%60);
            else
                printf("%d:0%d\n", t/60+8, t%60);
            fl = 1;
        }
    }
}

void Table::placing_order(FoodItem food_items[], kick_start_time t) {
    iter i;
    int orders;
    if(this->status == 0)
        return;
    printf("Table no %d is ordering ", this->table_no);
    int total_order = rand()%1024 + 1;
    int order = 10;
    while(total_order != 0) {
        int flag = total_order%2;
        if(flag == 1) {
            int quantity = rand() % 5 + 1;
            printf("%d %s, ", quantity, food_items[order].name);
            for(iter j = 0; j < quantity; j++)
                add_food(food_items[order], t);
        }
        total_order /= 2;
        order--;
    }
    printf("at ");
    if(t%60 > 10)
        printf("%d:%d\n", t/60+8, t%60);
    else
        printf("%d:0%d\n", t/60+8, t%60);
}

int Table::print_bill(FoodItem food_items[], kick_start_time t) {
    if(this->status == 0)
        return 0;

    int bill = 0;
    iter i;
    iter j;
    for( i = 0; i < this->items_ordered; i++) {
        bill += this->food_items[i].cost;
    }
    int quantity[MAX_ITEMS+1] = {0};
    int fl = 0;
    for( i = 1; i < MAX_ITEMS + 1; i++) {
        quantity[i] = 0;
        for ( j = 0; j < this->items_ordered; j++) {
            if(this->food_items[j].code == food_items[i].code) {
                quantity[i]++;
                if(fl != 2)
                    fl = 1;
            }
            if(this->expected_delivery[j] > t)
                fl = 2;
        }

    }
    if(fl != 1)
        return 0;

    printf("Table %d asked for bill\n", this->table_no);

    for( i = 1; i < MAX_ITEMS + 1; i++)
        if(quantity[i] > 0)
            printf("Item : %s \t\t quantity : %d \t\t Price : %d\n", food_items[i].name, quantity[i], quantity[i]*food_items[i].cost);

    printf(" Final Amount : %d\n\n", bill);
    initialize_table(this->table_no);
    return 1;
}
