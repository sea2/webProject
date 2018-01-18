package com.tgb.mapper;

import java.util.List;

import com.tgb.model.P2pInfo;

public interface P2pmapper {

	
	
	void save_init(P2pInfo mP2pInfo);

	List<P2pInfo> findAll();

	void delById(int id);

	void updateScore(P2pInfo mP2pInfo);

	
	
	
}
