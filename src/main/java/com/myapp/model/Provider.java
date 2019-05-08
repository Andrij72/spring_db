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
public class Provider {
    public static final String TABLE_NAME = "providers";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    private Long id;
    private String name;
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
        Provider that = (Provider) obj;
        if (!name.equals(that.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Provider[id=" + this.id + ", name=" + this.name + "]";
    }
}
