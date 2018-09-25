package com.hb.start_boot.jpa;

import com.hb.start_boot.entity.JpaUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<JpaUser, Long>,
        JpaSpecificationExecutor<JpaUser>,
        Serializable {

}
