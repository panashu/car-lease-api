package com.ashupan.appuserservice.repository.impl;

import com.ashupan.appuserservice.repository.AppUserRepositoryCustom;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ashutosh on 8/11/21
 */
@Service
@Transactional
public class AppUserRepositoryCustomImpl implements AppUserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

}
