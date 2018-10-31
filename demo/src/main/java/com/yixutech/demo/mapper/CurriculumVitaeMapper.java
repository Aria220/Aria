package com.yixutech.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yixutech.demo.entity.CurriculumVitae;

@Mapper
public interface CurriculumVitaeMapper {

	Integer insert(CurriculumVitae curriculumVitae);

	CurriculumVitae findCurriculumVitaeById(Integer id);

	List<CurriculumVitae> getCurriculumVitaeList();

	Integer delete(Integer id);
	
	List<CurriculumVitae> getCurriculumVitaeListByAccountId(Integer accountId);
	
}
