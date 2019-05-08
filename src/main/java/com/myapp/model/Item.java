package com.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.security.Provider;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {
    public static final String ALIAS_TABLE_NAME = "i";
    public static final String TABLE_NAME = "items";
    public static final String ALIAS_ID_ITEM_COLUMN = "item_id";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String WAREHOUSE_ID_COLUMN = "warehouse_id";

    private Long id;
    private String name;
    private Long warehouse_id;
    private Set<Provider> providers = new HashSet<Provider>();

    public Set<Provider> getProviders() {
        return providers;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item that = (Item) obj;
        if (!name.equals(that.name) || warehouse_id != that.warehouse_id) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Item[id=" + this.id + ", name=" + this.name + "]";
    }
}
