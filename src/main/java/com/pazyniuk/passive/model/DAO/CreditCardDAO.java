package com.pazyniuk.passive.model.DAO;

import com.pazyniuk.passive.model.CreditCard;
import com.pazyniuk.passive.model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class CreditCardDAO {

    public final void saveCreditCard(final CreditCard creditCard) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(creditCard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void updateCreditCard(final CreditCard creditCard) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(creditCard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void deleteCreditCard(final int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CreditCard creditCard = session.get(CreditCard.class, id);
            if (creditCard != null) {
                session.delete(creditCard);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final CreditCard getCreditCard(final int id) {
        Transaction transaction = null;
        CreditCard creditCard = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            creditCard = session.get(CreditCard.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return creditCard;
    }

    @SuppressWarnings("unchecked")
    public final List <CreditCard> getAllCreditCards() {
        Transaction transaction = null;
        List <CreditCard> listOfCreditCards = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfCreditCards = session.createQuery("from CreditCard").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCreditCards;
    }
}
