package com.hoperun.shuma.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by ZC on 2017/9/28.
 */
@NoRepositoryBean
public interface BaseJpa<T> extends JpaRepository<T, Integer> {

    List<T> findByDeleteStatus(String deleteStatus);

    T findByIdAndDeleteStatus(Integer id, String deleteStatus);
}