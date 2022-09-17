package ru.job4j.tracker;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {
    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Timestamp created = Timestamp.from(Instant.now());
    private String description;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        this.description = "";
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
        this.description = "";
    }

    public Item(String name, Timestamp created, String description) {
        this.name = name;
        this.created = created;
        this.description = description;
    }

    public Item(String name, int id, Timestamp created, String description) {
        this.name = name;
        this.id = id;
        this.created = created;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{"
                 + "id=" + id
                 + ", name='" + name + '\''
                 + ", created=" + format.format(created)
                 + ", description='" + description + '\''
                 + '}';
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(id, item.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}