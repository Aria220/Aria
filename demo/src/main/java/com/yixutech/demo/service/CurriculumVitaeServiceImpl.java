package com.yixutech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yixutech.demo.entity.CurriculumVitae;
import com.yixutech.demo.mapper.CurriculumVitaeMapper;

@Service("curriculumVitaeService")
public class CurriculumVitaeServiceImpl implements ICurriculumVitaeService{

	@Autowired
	private CurriculumVitaeMapper curriculumVitaeMapper;
	
	@Override
	public Integer insert(CurriculumVitae curriculumVitae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurriculumVitae findCurriculumVitaeById(Integer id) {
		return curriculumVitaeMapper.findCurriculumVitaeById(id);
	}

	@Override
	public List<CurriculumVitae> getCurriculumVitaeList() {
		return curriculumVitaeMapper.getCurriculumVitaeList();
	}

	@Override
	public Integer delete(Integer id) {
		return curriculumVitaeMapper.delete(id);
	}

	@Override
	public List<CurriculumVitae> getCurriculumVitaeListByAccountId(Integer accountId) {
		return curriculumVitaeMapper.getCurriculumVitaeListByAccountId(accountId);
	}
	
}
