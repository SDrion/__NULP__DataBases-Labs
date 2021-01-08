package com.polotskyi.model.dao;

import com.polotskyi.HibernateUtil;
import com.polotskyi.model.entity.Rent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDao implements IGenDao<Rent> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Rent> findAll() {
        List<Rent> rents = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            rents = session.createQuery("from Rent").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rents;
    }


    @Override
    public Rent find(Integer id) {
        Rent rent = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            rent = session.get(Rent.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rent;
    }

    @Override
    public void create(Rent rent) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(rent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Rent rent) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(rent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Rent rent = session.get(Rent.class, id);
            if (rent != null) {
                session.delete(rent);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
