package ImageHoster.repository;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "ImageHoster")
    private EntityManagerFactory emf;
    //The method receives the Comment object to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public Comment createComment(Comment newComment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments from the database
    //Returns the list of all the comments fetched from the database

    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i", Comment.class);

        return query.getResultList();

    }
    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch the comment from the database with corresponding title
    //Returns the comment in case the comment is found in the database
    //Returns null if no comment is found in the database

    public Comment getComment(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT i from Comment i where i.id =:id", Comment.class).setParameter("id",id );
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    //The method receives the Comment object to be updated in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public void updateComment(Image updatedComment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }


}
