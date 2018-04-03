/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresBaseDao;
import com.erp.dao.IWaresDao;
import com.erp.dao.IWaresExtendDao;
import com.erp.dao.IWaresPriceDao;
import com.erp.orm.entity.Wares;
import com.erp.orm.entity.WaresBase;
import com.erp.orm.entity.WaresExtend;
import com.erp.orm.entity.WaresPrice;
import com.erp.service.IWaresService;

/**
 *
 *
 * @author scy
 * @date 2016年9月29日
 */
@Service("waresService")
public class WaresServiceImpl implements IWaresService {

	@Resource
	private IWaresDao waresDao;
	@Resource
	private IWaresBaseDao waresBaseDao;
	@Resource
	private IWaresExtendDao waresExtendDao;
	@Resource
	private IWaresPriceDao waresPriceDao;
	
//	/**
//	 * @return the waresDao
//	 */
//	public IWaresDao getWaresDao() {
//		return waresDao;
//	}
//
//	/**
//	 * @param waresDao the waresDao to set
//	 */
//	public void setWaresDao(IWaresDao waresDao) {
//		this.waresDao = waresDao;
//	}
//
//	/**
//	 * @return the waresBaseDao
//	 */
//	public IWaresBaseDao getWaresBaseDao() {
//		return waresBaseDao;
//	}
//
//	/**
//	 * @param waresBaseDao the waresBaseDao to set
//	 */
//	public void setWaresBaseDao(IWaresBaseDao waresBaseDao) {
//		this.waresBaseDao = waresBaseDao;
//	}
//
//	/**
//	 * @return the waresExtendDao
//	 */
//	public IWaresExtendDao getWaresExtendDao() {
//		return waresExtendDao;
//	}
//
//	/**
//	 * @param waresExtendDao the waresExtendDao to set
//	 */
//	public void setWaresExtendDao(IWaresExtendDao waresExtendDao) {
//		this.waresExtendDao = waresExtendDao;
//	}
//
//	/**
//	 * @return the waresPriceDao
//	 */
//	public IWaresPriceDao getWaresPriceDao() {
//		return waresPriceDao;
//	}
//
//	/**
//	 * @param waresPriceDao the waresPriceDao to set
//	 */
//	public void setWaresPriceDao(IWaresPriceDao waresPriceDao) {
//		this.waresPriceDao = waresPriceDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#delById(java.lang.String)
	 */
	@Override
	public int delById(String wId) {
		waresExtendDao.deleteByPrimaryKey(wId);
		waresPriceDao.deleteByPrimaryKey(wId);
		return waresBaseDao.deleteByPrimaryKey(wId);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#save(com.erp.orm.entity.Wares)
	 */
	@Override
	public int save(WaresBase base,WaresExtend extend,WaresPrice price) {
		int n1 = waresBaseDao.insert(base);
		int n2 = waresExtendDao.insert(extend);
		int n3 = waresPriceDao.insert(price);
//		return waresDao.insert(wares) ;
		return (n1+n2+n3);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#saveIsNull(com.erp.orm.entity.Wares)
	 */
	@Override
	public int saveNotNull(WaresBase base,WaresExtend extend,WaresPrice price) {
		if(base != null){
			int n1 = 0;
			int n2 = 0;
			int n3 = 0;
			if(base.getwId()!= null && base.getwId() > 0){//更新操作
				n1 = waresBaseDao.updateByPrimaryKeySelective(base);
				n2 = waresExtendDao.updateByPrimaryKeySelective(extend);
				n3 = waresPriceDao.updateByPrimaryKeySelective(price);
			}else{//保存
				n1 = waresBaseDao.insert(base);
				n2 = waresExtendDao.insert(extend);
				n3 = waresPriceDao.insert(price);
			}
			return (n1+n2+n3);
		}
		return 0;
//		return waresDao.insertSelective(wares) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#findById(java.lang.String)
	 */
	@Override
	public Wares findById(String wId) {
		
		return waresDao.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#modifyByIdIsNull(com.erp.orm.entity.Wares)
	 */
	@Override
	public int modifyByIdIsNull(Wares wares) {
		
		return waresDao.updateByPrimaryKeySelective(wares) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresService#modifyById(com.erp.orm.entity.Wares)
	 */
	@Override
	public int modifyById(Wares wares) {
		
		return waresDao.updateByPrimaryKey(wares) ;
	}

	@Override
	public List<Wares> findAll() {
		return waresDao.selectAll();
	}

	@Override
	public List<Wares> findByName(String wTraname) {
		return waresDao.selectByName(wTraname);
	}

	@Override
	public List<Wares> findByNameOrId(String s) {
		return waresDao.selectByNameOrId(s);
	}

	@Override
	public List<Wares> findByZjmOrId(String zjm) {
		return waresDao.selectByZjmOrId(zjm);
	}
	@Override
	public List<Wares> findByPage(Integer page, Integer rows) {
		return waresDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return waresDao.selectCount();
	}

}
