/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWarehousingDao;
import com.erp.orm.entity.Warehousing;
import com.erp.service.IWarehousingService;

/**
 * 入库信息
 *
 * @author scy
 * @date 2017年1月2日
 */
@Service("warehousingService")
public class WarehousingServiceImpl implements IWarehousingService {
	
	@Resource
	private IWarehousingDao warehousingDao;

//	/**
//	 * @return the warehousingDao
//	 */
//	public IWarehousingDao getWarehousingDao() {
//		return warehousingDao;
//	}
//
//	/**
//	 * @param warehousingDao the warehousingDao to set
//	 */
//	public void setWarehousingDao(IWarehousingDao warehousingDao) {
//		this.warehousingDao = warehousingDao;
//	}

	@Override
	public int delById(String whId) {
		
		return warehousingDao.deleteByPrimaryKey(whId) ;
	}

	@Override
	public int save(Warehousing warehousing) {
		
		return warehousingDao.insert(warehousing) ;
	}

	@Override
	public int saveNotNull(Warehousing warehousing) {
		
		return warehousingDao.insertSelective(warehousing) ;
	}

	@Override
	public Warehousing findById(String whId) {
		
		return warehousingDao.selectByPrimaryKey(whId) ;
	}

	@Override
	public int modifyByIdNotNull(Warehousing warehousing) {
		
		return warehousingDao.updateByPrimaryKeySelective(warehousing) ;
	}

	@Override
	public int modifyById(Warehousing warehousing) {
		
		return warehousingDao.updateByPrimaryKey(warehousing) ;
	}

	@Override
	public List<Warehousing> findWarehousing(String whId, String whInitime, String whCreator) {

		return warehousingDao.selectByIdOrTimeOrCreator(whId, whInitime,  whCreator);
	}

	@Override
	public List<Warehousing> findAll() {
		return warehousingDao.selectAll();
	}

	@Override
	public List<Warehousing> findByPage(Integer page, Integer rows) {
		return warehousingDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return warehousingDao.selectCount();
	}

}
