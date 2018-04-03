package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IMapApproveRecordDao;
import com.erp.orm.entity.Approve;
import com.erp.orm.entity.MapApproveRecord;
import com.erp.service.IMapApproveRecordService;

/**
 * 模块对应审批权限
 */
@Service("mapapproverecordService")
public class MapApproveRecordServiceImpl implements  IMapApproveRecordService {
	@Resource
	private IMapApproveRecordDao mapApproveRecordDao;

//	public IMapApproveRecordDao getMapApproveRecordDao() {
//		return mapApproveRecordDao;
//	}
//
//	public void setMapApproveRecordDao(IMapApproveRecordDao mapApproveRecordDao) {
//		this.mapApproveRecordDao = mapApproveRecordDao;
//	}

	@Override
	public int delById(Integer marId){
		return mapApproveRecordDao.deleteByPrimaryKey(marId);
	}



	@Override
	public int save(MapApproveRecord mapApproveRecord){
		return mapApproveRecordDao.insert(mapApproveRecord);
	}



	@Override
	public int saveNotNull(MapApproveRecord mapApproveRecord){
		return mapApproveRecordDao.insertSelective(mapApproveRecord);
	}



	@Override
	public MapApproveRecord findById(Integer marId){
		return mapApproveRecordDao.selectByPrimaryKey(marId);
	}



	@Override
	public int modifyByIdNotNull(MapApproveRecord mapApproveRecord){
		return mapApproveRecordDao.updateByPrimaryKeySelective(mapApproveRecord);
	}



	@Override
	public int modifyById(MapApproveRecord mapApproveRecord){
		return mapApproveRecordDao.updateByPrimaryKey(mapApproveRecord);
	}



	@Override
	public MapApproveRecord findByCode(String oCode){
		return mapApproveRecordDao.selectByCode(oCode);
	}

	@Override
	public MapApproveRecord findByMidAndRid(Integer mId, String rId) {
		return mapApproveRecordDao.selectByMidAndRid(mId, rId);
	}


	@Override
	public List<MapApproveRecord> findByPage(Integer page, Integer rows){
		return mapApproveRecordDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return mapApproveRecordDao.selectCount();
	}

	@Override
	public int saveNotNull(String rId, Integer uId, Approve approve) {
		MapApproveRecord mapApproveRecord = new MapApproveRecord();
		mapApproveRecord.setaId(approve.getaId());
		mapApproveRecord.setuId(uId);
		mapApproveRecord.setmId(approve.getmId());
		mapApproveRecord.setrId(rId);
		mapApproveRecord.setMarState((byte)1);
		mapApproveRecord.setMarLevel(approve.getaLevel());
//		mapApproveRecord.setMarDid1(approve.getaLevelDid1());
//		mapApproveRecord.setMarUid1(approve.getaLevelUid1());
//		mapApproveRecord.setMarDid2(approve.getaLevelDid2());
//		mapApproveRecord.setMarUid2(approve.getaLevelUid2());
//		mapApproveRecord.setMarDid3(approve.getaLevelDid3());
//		mapApproveRecord.setMarUid3(approve.getaLevelUid3());
//		mapApproveRecord.setMarDid4(approve.getaLevelDid4());
//		mapApproveRecord.setMarUid4(approve.getaLevelUid4());
//		mapApproveRecord.setMarDid5(approve.getaLevelDid5());
//		mapApproveRecord.setMarUid5(approve.getaLevelUid5());
//		mapApproveRecord.setMarDid6(approve.getaLevelDid6());
//		mapApproveRecord.setMarUid6(approve.getaLevelUid6());

		return mapApproveRecordDao.insertSelective(mapApproveRecord);
	}

	@Override
	public int modifyByApproveInfoToPass(Integer mId, String rId, int n, Integer eId, String eoId,Byte marState) {

		return mapApproveRecordDao.updateByApproveInfoToPass(mId, rId, n, eId, eoId, marState);
	}

	@Override
	public int modifyByApproveInfoToReject(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		return mapApproveRecordDao.updateByApproveInfoToReject(mId, rId, n, eId, eoId, marState);
	}

	@Override
	public int modifyByApproveInfoToCancelled(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		return mapApproveRecordDao.updateByApproveInfoToCancelled(mId, rId, n, eId, eoId, marState);
	}

	@Override
	public int modifyByApproveInfoToRecall(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		return mapApproveRecordDao.updateByApproveInfoToRecall(mId, rId, n, eId, eoId, marState);
	}

	@Override
	public int modifyByApproveInfoToAbort(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState) {
		return mapApproveRecordDao.updateByApproveInfoToAbort(mId, rId, n, eId, eoId, marState);
	}


}
