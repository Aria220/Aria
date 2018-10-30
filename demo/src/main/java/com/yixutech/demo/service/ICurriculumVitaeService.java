package com.yixutech.demo.service;

import java.util.List;

import com.yixutech.demo.entity.CurriculumVitae;

public interface ICurriculumVitaeService {
	Integer insert(CurriculumVitae curriculumVitae);

	CurriculumVitae findCurriculumVitaeById(Integer id);

	List<CurriculumVitae> getCurriculumVitaeList();

	Integer delete(Integer id);
	
	List<CurriculumVitae> getCurriculumVitaeListByAccountId(Integer accountId);
}
