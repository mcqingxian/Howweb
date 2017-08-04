package com.hoau.how.module.bse.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.how.module.bse.api.server.service.ICommentService;
import com.hoau.how.module.bse.api.shared.domain.CommentEntity;
import com.hoau.how.module.bse.api.shared.exception.CommentException;
import com.hoau.how.module.bse.api.shared.vo.CommentQueryVo;
import com.hoau.how.module.bse.server.dao.CommentMapper;

/**
 * 
 * @author：张爱萍
 * @create：2015年5月30日 下午3:53:25
 * @description：
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CommentService implements ICommentService{
	
	@Resource
	private CommentMapper commentMapper;
	
	@Override
	public long countComment(CommentQueryVo commentQueryVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(commentQueryVo != null){
			if(commentQueryVo.getType()!= -1){
				params.put("type", commentQueryVo.getType());
			}
			if(commentQueryVo.getDate() != null && commentQueryVo.getDate().toString() != ""){
				params.put("date", commentQueryVo.getDate());
			}
			if(commentQueryVo.getStatus() != -1){
				params.put("status", commentQueryVo.getStatus());
			}
			if(commentQueryVo.getKey() != null && commentQueryVo.getKey()!=""){
				params.put("key", "%" + commentQueryVo.getKey() + "%");
			}
		}
		return commentMapper.countComment(params);
	}
	
	@Override
	public void insertComment(CommentEntity commentEntity,String customerIp) {
		if(commentEntity !=null){
			commentEntity.setIp(customerIp);
			commentMapper.addComment(commentEntity);
		}else {
			throw new CommentException(CommentException.COMMENT_NULL);
		}
	}
	
	@Override
	public List<CommentEntity> queryCommentList(CommentQueryVo commentQueryVo,
			Integer pageIndex, Integer pageSize) {
		// 判断分页参数是否为空
		if(pageIndex ==null || pageSize ==null){
			throw new CommentException(CommentException.RB_NULL);
		}
		// 查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageStart", (pageIndex-1) * pageSize + 1 );
		params.put("pageEnd",pageIndex * pageSize);
		if(commentQueryVo != null){
			if(commentQueryVo.getType()!= -1){
				params.put("type", commentQueryVo.getType());
			}
			if(commentQueryVo.getDate() != null && commentQueryVo.getDate().toString() != ""){
				params.put("date", commentQueryVo.getDate());
			}
			if(commentQueryVo.getStatus() != -1){
				params.put("status", commentQueryVo.getStatus());
			}
			if(commentQueryVo.getKey() != null && commentQueryVo.getKey()!=""){
				params.put("key", "%" + commentQueryVo.getKey() + "%");
			}
		}
		return commentMapper.queryCommentList(params);
	}
}
