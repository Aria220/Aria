package com.yixutech.demo.mapper;

import java.util.List;

import com.yixutech.demo.entity.CurriculumVitae;

public interface CurriculumVitaeMapper {

	Integer insert(CurriculumVitae curriculumVitae);

	CurriculumVitae findCurriculumVitaeById(Integer id);

	List<CurriculumVitae> getCurriculumVitaeList();

	Integer delete(Integer id);
}
