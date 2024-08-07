package com.techymeet.jparespository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techymeet.vo.LoginVo;

public interface LoginRepository  extends JpaRepository<LoginVo,Integer > {





	boolean loginCheck(LoginVo loginVo);



}
