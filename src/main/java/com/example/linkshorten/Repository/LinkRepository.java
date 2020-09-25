package com.example.linkshorten.Repository;


import com.example.linkshorten.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {

  @Query(value = "select id from link order by id desc limit 1",nativeQuery = true)
  Integer getLastLinkId();


}
