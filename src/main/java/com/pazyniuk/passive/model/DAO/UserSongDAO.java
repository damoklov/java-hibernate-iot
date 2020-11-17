package com.pazyniuk.passive.model.DAO;

import com.pazyniuk.passive.model.HibernateUtil;
import com.pazyniuk.passive.model.UserSong;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class UserSongDAO {

    public final void saveUserSong(final UserSong userSong) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(userSong);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void updateUserSong(final UserSong userSong) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(userSong);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void deleteUserSong(final int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            UserSong userSong = session.get(UserSong.class, id);
            if (userSong != null) {
                session.delete(userSong);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final UserSong getUserSong(final int id) {
        Transaction transaction = null;
        UserSong userSong = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            userSong = session.get(UserSong.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return userSong;
    }

    @SuppressWarnings("unchecked")
    public final List <UserSong> getAllUserSongs() {
        Transaction transaction = null;
        List <UserSong> listOfUserSongs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfUserSongs = session.createQuery("from UserSong").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUserSongs;
    }
}
