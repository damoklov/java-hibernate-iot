package com.pazyniuk.passive.model.DAO;

import com.pazyniuk.passive.model.HibernateUtil;
import com.pazyniuk.passive.model.ItunesUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class ItunesUserDAO {

    public final void saveItunesUser(final ItunesUser itunesUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(itunesUser);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void updateItunesUser(final ItunesUser itunesUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(itunesUser);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void deleteItunesUser(final int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ItunesUser itunesUser = session.get(ItunesUser.class, id);
            if (itunesUser != null) {
                session.delete(itunesUser);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final ItunesUser getItunesUser(final int id) {
        Transaction transaction = null;
        ItunesUser itunesUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            itunesUser = session.get(ItunesUser.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return itunesUser;
    }

    @SuppressWarnings("unchecked")
    public final List <ItunesUser> getAllItunesUsers() {
        Transaction transaction = null;
        List <ItunesUser> listOfItunesUsers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfItunesUsers = session.createQuery("from ItunesUser").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfItunesUsers;
    }
}
