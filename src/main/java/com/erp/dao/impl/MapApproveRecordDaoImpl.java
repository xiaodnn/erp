package com.erp.dao.impl;

import com.erp.orm.inter.IMapApproveRecordMapper;
import com.erp.dao.IMapApproveRecordDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.MapApproveRecord;
import org.springframework.stereotype.Repository;

@Repository("mapApproveRecordDao")
public class MapApproveRecordDaoImpl implements  IMapApproveRecordDao {
	@Resource
	private IMapApproveRecordMapper mapApproveRecordMapper;

//	public IMapApproveRecordMapper getMapApproveRecordMapper() {
//		return mapApproveRecordMapper;
//	}
//
//	public void setMapApproveRecordMapper(IMapApproveRecordMapper mapApproveRecordMapper) {
//		this.mapApproveRecordMapper = mapApproveRecordMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer marId){
		return mapApproveRecordMapper.deleteByPrimaryKey(marId);
	}



	@Override
	public int insert(MapApproveRecord mapApproveRecord){
		return mapApproveRecordMapper.insert(mapApproveRecord);
	}



	@Override
	public int insertSelective(MapApproveRecord mapApproveRecord){
		return mapApproveRecordMapper.insertSelective(mapApproveRecord);
	}



	@Override
	public MapApproveRecord selectByPrimaryKey(Integer marId){
		return mapApproveRecordMapper.selectByPrimaryKey(marId);
	}



	@Override
	public int updateByPrimaryKeySelective(MapApproveRecord mapApproveRecord){
		return mapApproveRecordMapper.updateByPrimaryKeySelective(mapApproveRecord);
	}



	@Override
	public int updateByPrimaryKey(MapApproveRecord mapApproveRecord){
		return mapApproveRecordMapper.updateByPrimaryKey(mapApproveRecord);
	}



	@Override
	public MapApproveRecord selectByCode(String oCode){
		return mapApproveRecordMapper.selectByCode(oCode);
	}



	@Override
	public List<MapApproveRecord> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return mapApproveRecordMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return mapApproveRecordMapper.selectCount(map);
	}

	@Override
	public MapApproveRecord selectByMidAndRid(Integer mId, String rId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		return mapApproveRecordMapper.selectByMidAndRid(map);
	}

	@Override
	public int updateByApproveInfoToPass(Integer mId, String rId, int n, Integer eId, String eoId,Byte marState) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		map.put("n",n);
		map.put("eId",eId);
		map.put("eoId",eoId);
		map.put("marState",marState);

		return mapApproveRecordMapper.updateByApproveInfoToPass(map);
	}

	@Override
	public int updateByApproveInfoToReject(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		map.put("n",n);
		map.put("eId",eId);
		map.put("eoId",eoId);
		map.put("marState",marState);

		return mapApproveRecordMapper.updateByApproveInfoToReject(map);
	}

	@Override
	public int updateByApproveInfoToCancelled(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		map.put("n",n);
		map.put("eId",eId);
		map.put("eoId",eoId);
		map.put("marState",marState);

		return mapApproveRecordMapper.updateByApproveInfoToCancelled(map);
	}

	@Override
	public int updateByApproveInfoToRecall(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		map.put("n",n);
		map.put("eId",eId);
		map.put("eoId",eoId);
		map.put("marState",marState);

		return mapApproveRecordMapper.updateByApproveInfoToRecall(map);
	}

	@Override
	public int updateByApproveInfoToAbort(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mId",mId);
		map.put("rId",rId);
		map.put("n",n);
		map.put("eId",eId);
		map.put("eoId",eoId);
		map.put("marState",marState);

		return mapApproveRecordMapper.updateByApproveInfoToAbort(map);
	}


}
