package com.ashupan.appuserservice.repository;

import com.ashupan.appuserservice.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>, AppUserRepositoryCustom {

    @Query(value = "SELECT * FROM app_user WHERE username = :username", nativeQuery = true)
    Optional<AppUser> fetchAppUserByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM app_user WHERE email_address = :emailAddress", nativeQuery = true)
    Optional<AppUser> fetchAppUserByEmailAddress(@Param("emailAddress") String emailAddress);

    @Query(value = "SELECT * FROM app_user WHERE id = :id", nativeQuery = true)
    Optional<AppUser> getAppUserById(@Param("id") Long id);

    @Query(value = "SELECT * FROM app_user", nativeQuery = true)
    List<AppUser> fetchAllAppUsers();


}
