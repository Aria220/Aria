package com.yixutech.demo.mapper;

import java.util.List;

import com.yixutech.demo.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorMapper {
	Integer insert(Administrator account);

	Administrator findAdministratorById(Integer id);

	List<Administrator> getAdministratorList();

	Integer delete(Integer id);
}
