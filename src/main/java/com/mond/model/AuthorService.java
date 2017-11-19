package com.mond.model;

import com.mond.entity.Author;
import com.mond.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 * Created by User on 19.11.2017.
 */

@Service
public class AuthorService {

    private Session currentSession;
    private Transaction currentTransaction;

    public AuthorService() {}

    private void openSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Author getById(int id) {
        openSession();
        Author author = (Author) currentSession.get(Author.class, id);
        closeSession();
        return author;
    }

}
