package com.hoau.how.module.obh.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.shared.vo.GoodsTraceResultVo;
import com.hoau.how.module.common.constants.ControllConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.common.constants.WaybillConstants;
import com.hoau.how.module.obh.server.service.IGoodsTraceService;
import com.hoau.how.module.obh.server.service.IWaybillService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.QueryWaybillEntity;
import com.hoau.how.module.obh.shared.domain.WaybillResultEntity;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.obh.shared.vos.QueryWaybillsVo;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：张贞献
 * @create：2015年8月4日 上午10:29:37
 * @description：
 */
@Controller
@Scope("prototype")
public class MyWaybillsAction extends AbstractAction{

	/**
	 *
	 */
	private static final long serialVersionUID = -8169459549798418152L;
    //private Logger logger = Logger.getLogger(MyWaybillsAction.class);
	
	//in
	private QueryWaybillsVo queryVo;
	private Integer pageNo = 1;
	private Integer pageSize;
	private String fieldType;
	private String fieldValue;
	//out
	private String controllType = ControllConstants.CONTROLL_MY_HOAU.MY_WAYBILLS ;
	private String categoryName;
	
	@Resource
	private IGoodsTraceService goodsTraceService;
	
	@Resource
	private IWaybillService waybillService;

	@PermissionCheck
	public String queryWaybillsByCondititons() {
		if (pageNo == null || pageSize== null) {
			throw new BusinessException();
		}
		if(queryVo == null) {
			queryVo = new QueryWaybillsVo();
		}
		if(queryVo.getQueryWaybillEntity() == null) {
			queryVo.setQueryWaybillEntity(new QueryWaybillEntity());
		}
		
		if (fieldType != null) {	
			if(fieldType.equals(WaybillConstants.WAYBILL_KEYS.TRANS_NO)
					&& fieldValue != null && !fieldValue
					.equals(WaybillConstants.VO_INFO.TRANS_NO_INFO)){
				queryVo.getQueryWaybillEntity().setTransNo(fieldValue);
			}else if(fieldType
					.equals(WaybillConstants.WAYBILL_KEYS.CONSIGNEE)
					&& fieldValue != null && !fieldValue
						.equals(WaybillConstants.VO_INFO.CONSIGNEE_INFO)){
				queryVo.getQueryWaybillEntity().setConsignee(fieldValue);
				
			}else if(fieldType.equals(WaybillConstants.WAYBILL_KEYS.CARGO_NAME)
					&& fieldValue != null && !fieldValue
					.equals(WaybillConstants.VO_INFO.CARGO_NAME_INFO)){
				queryVo.getQueryWaybillEntity().setGoodsName(fieldValue);
				
			}	
		}
		
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		CustomerContactEntity userInfo = (CustomerContactEntity) obj;
	
		//客户联系人Id
		queryVo.getQueryWaybillEntity().setCustomerId(userInfo.getEbccId());
		queryVo.getQueryWaybillEntity().setPageSize(pageSize);
		queryVo.getQueryWaybillEntity().setOffset((pageNo-1)*  pageSize);
		
		List<WaybillResultEntity> waybillResultEntitys = waybillService.queryWaybillResult(queryVo.getQueryWaybillEntity());
		this.totalCount =waybillService.queryWaybillCount(queryVo.getQueryWaybillEntity());

		// 加载货物轨迹
		if (waybillResultEntitys != null) {
			String tansNos = "";
			for (WaybillResultEntity entity : waybillResultEntitys) {
				if ("".equals(tansNos)) {
					tansNos = entity.getTransNo();
				} else {
					tansNos += "," + entity.getTransNo();
				}
			}
			List<GoodsTraceResultVo> ydTraceList = goodsTraceService
					.goodsTrace(tansNos);
			Map<String, GoodsTraceResultVo> map = new HashMap<String, GoodsTraceResultVo>();
			if (ydTraceList != null) {
				for (GoodsTraceResultVo vo : ydTraceList) {
					map.put(vo.getWaybillNo(), vo);
				}

				for (int i = 0; i < waybillResultEntitys.size(); i++) {
					GoodsTraceResultVo vo = map.get(waybillResultEntitys.get(i).getTransNo());
					if(vo == null){
						vo = new GoodsTraceResultVo();
						vo.setWaybillNo(waybillResultEntitys.get(i).getTransNo());
					}
					waybillResultEntitys.get(i).setGoodsTraceResult(vo);
					
				}

			}

		}
				
		queryVo.setWaybillResultEntitys(waybillResultEntitys);		
		return this.returnSuccess();
	}

	
	public String getControllType() {
		return controllType;
	}
	public void setControllType(String controllType) {
		this.controllType = controllType;
	}

	public QueryWaybillsVo getQueryVo() {
		return queryVo;
	}

	public void setQueryVo(QueryWaybillsVo queryVo) {
		this.queryVo = queryVo;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

}
