package com.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Warehouse {
    public static final String ALIAS_TABLE_NAME = "w";
    public static final String TABLE_NAME = "warehouses";
    public static final String ID_COLUMN = "id";
    public static final String ADDRESS_COLUMN = "address";

    private Long id;
    private String address;
    private Set<Item> items = new HashSet<Item>();

    public void addItem(Item item) {
        if (items == null) {
            items = new HashSet<Item>();
        }
        items.add(item);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Warehouse that = (Warehouse) obj;
        if (!address.equals(that.address)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Warehouse[id=" + this.id + ", address=" + this.address + "]";
    }
}
