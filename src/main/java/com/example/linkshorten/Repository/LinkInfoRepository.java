package com.example.linkshorten.Repository;

import com.example.linkshorten.entity.LinkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 22/09/20
 **/
public interface LinkInfoRepository extends JpaRepository<LinkInfo,Integer> {
}
