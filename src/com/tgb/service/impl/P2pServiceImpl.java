package com.tgb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tgb.mapper.P2pmapper;
import com.tgb.model.P2pInfo;
import com.tgb.service.P2pService;

@Service
@Transactional // 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class P2pServiceImpl implements P2pService{
	@Resource
	private P2pmapper mapper;
	
	@Override
	public void save_init(P2pInfo mP2pInfo) {
		mapper.save_init(mP2pInfo);
	}

	@Override
	public List<P2pInfo> findAll() {
		return	mapper.findAll();
	}

	@Override
	public void delById(int id) {
		mapper.delById(id);
		
	}

	@Override
	public void updateScore(P2pInfo mP2pInfo) {
		mapper.updateScore(mP2pInfo);
		
	}

	
	
	
	
	
	
}
