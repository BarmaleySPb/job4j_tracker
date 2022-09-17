package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.persist(item);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item itemDb = session.get(Item.class, id);
            if (itemDb != null) {
                itemDb.setName(item.getName());
                itemDb.setDescription(item.getDescription());
            }
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.remove(findById(id));
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            items = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        }
        return items;
    }

    public void findAllByReact(Observe<Item> observe) {
        List<Item> items;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            items = session.createQuery("from Item", Item.class).list();
            items.forEach(observe::receive);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            items = session.createQuery("from Item i where i.name = :key", Item.class)
                    .setParameter("key", key)
                    .list();
            session.getTransaction().commit();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}