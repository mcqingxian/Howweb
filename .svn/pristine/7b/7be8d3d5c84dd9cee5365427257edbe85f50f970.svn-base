package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.domain.CommentEntity;
import com.hoau.how.module.bse.api.shared.vo.CommentQueryVo;

/**
 * 客户留言SERVICCE层接口
 * @author：张爱萍
 * @create：2015年5月30日 下午3:54:41
 * @description：
 */
public interface ICommentService {
	
	/**
	 * 平台没有sqlserver分页查询组件
	 * 自定义分页查询客户留言信息
	 * 
	 * @param commentVo 查询条件实体
	 * @param pageIndex 页索引
	 * @param pageSize 也大小
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月8日
	 * @update
	 */
	public List<CommentEntity> queryCommentList(CommentQueryVo commentVo,Integer pageIndex, Integer pageSize);
	
	
	/**
	 * 客户留言总数
	 * 
	 * @param employeeVo
	 * @return
	 * @author 张爱萍
	 * @date 2015年5月31日
	 * @update
	 */
	public long countComment(CommentQueryVo commentVo); 
	
	/**
	 * 增加客户留言信息
	 * 
	 * @param employeeEntity
	 * @param roleCodes
	 * @author 张爱萍
	 * @date 2015年5月31日
	 * @update
	 */
	public void insertComment(CommentEntity commentEntity,String customerIp);
	
}
