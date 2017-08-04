package com.hoau.how.module.bse.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.CommentEntity;
import com.hoau.how.module.bse.api.shared.vo.CommentQueryVo;

/**
 * @author：张爱萍
 * @create：2015年5月30日 下午4:07:38
 * @description：
 */
@Repository
public interface CommentMapper {
	/**
	 * 分页查询留言信息
	 * 
	 * @param params
	 * @param rb
	 * @return
	 * @author 张爱萍
	 * @date 2015年5月31日
	 * @update
	 */
	public List<CommentEntity> getCommentList(CommentQueryVo commentQueryVo, RowBounds rb);
	
	/**
	 * 自定义分页查询留言信息
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月8日
	 * @update
	 */
	public List<CommentEntity> queryCommentList(Map<String,Object> params);
	
	/**
	 * 查询留言信息总数
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年5月31日
	 * @update
	 */
	public long countComment(Map<String,Object> params);
	
	/**
	 * 添加留言信息
	 * 
	 * @param params
	 * @author 张爱萍
	 * @date 2015年5月31日
	 * @update
	 */
	public void addComment(CommentEntity commentEntity);
}
