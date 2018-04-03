package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import  org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.erp.dao.IBaseDao;
import com.erp.orm.inter.IBaseMapper;

@Repository
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

    //mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。

//    @Autowired
//    public final void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
//        super.setSqlSessionFactory(sqlSessionFactory);
//    }

//    @Resource(name = "sqlSessionFactory")
//    protected SqlSessionFactory sqlSessionFactory;
//
//    private String ns;      //命名空间
//
//    public String getNs() {
//        return ns;
//    }
//
//    public void setNs(String ns) {
//        this.ns = ns;
//    }

    @Resource
    private IBaseMapper<T> baseMapper;

    @Override
    public int insert(T t) {
//        return this.getSqlSession().insert(ns+ ".insert",t);
        return baseMapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return baseMapper.insertSelective(t);
//      return this.getSqlSession().insert(ns+ ".insertSelective",t);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseMapper.deleteByPrimaryKey(String.valueOf(id));
//        return this.getSqlSession().delete(ns+ ".deleteByPrimaryKey",id);

    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
//      return this.getSqlSession().update(ns+".updateByPrimaryKeySelective",t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
//        return this.getSqlSession().update(ns+".updateByPrimaryKey",t);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return (T)baseMapper.selectByPrimaryKey(String.valueOf(id));
//        return this.getSqlSession().selectOne(ns+".selectByPrimaryKey",id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
//        this.getSqlSession().selectList(ns+".selectAll");
    }

    @Override
    public List<T> selectByPage(Integer page, Integer rows) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page",page);
        map.put("rows",rows);
        return baseMapper.selectByPage(map);
//        this.getSqlSession().selectList(ns+".selectByPage",map);
    }

    @Override
    public Integer selectCount() {
        Map<String,Object> map = new HashMap<String,Object>();
        return baseMapper.selectCount(map);
//        this.getSqlSession().selectOne(ns+".selectCount",map);
    }
}
