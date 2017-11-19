package com.mond.model;

import com.mond.entity.Quote;
import com.mond.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 * Created by User on 19.11.2017.
 */

@Service
public class QuoteService {

    private Session currentSession;
    private Transaction currentTransaction;

    public QuoteService() {}

    private void openSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Quote getById(int id) {
        openSession();
        Quote quote = (Quote) currentSession.get(Quote.class, id);
        closeSession();
        return quote;
    }

}
