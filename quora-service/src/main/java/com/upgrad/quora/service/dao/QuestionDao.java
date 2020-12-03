package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public QuestionEntity createQuestion(QuestionEntity questionEntity) {
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getQuestionsByUser(final UserEntity userEntity) {
        try {
            return entityManager.createNamedQuery("questionsByUserId", QuestionEntity.class).setParameter("user", userEntity).getResultList();
        } catch(NoResultException nre) {
            return null;
        }
    }

    public List<QuestionEntity> getQuestionsByEveryone() {
        try {
            return entityManager.createNamedQuery("questionsByEveryone", QuestionEntity.class).getResultList();
        } catch(NoResultException nre) {
            return null;
        }
    }
}
