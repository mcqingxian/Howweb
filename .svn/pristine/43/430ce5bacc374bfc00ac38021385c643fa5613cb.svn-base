package com.hoau.how.module.bse.server.action.pricetime;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.bse.server.service.pricetime.IDistrictService;
import com.hoau.how.module.bse.shared.exception.MessageType;
import com.hoau.how.module.bse.shared.vo.District;

@Controller
@Scope("prototype")
public class QueryDistrictAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8715212737149715631L;

	private List<District> areas;

	@Resource
	private IDistrictService districtService;


	/**
	 * 新接口获得省的数据
	 * 
	 * @return
	 */
	@JSON
	public String queryProvincesFormMDM() {
		try {
			try {
				areas = districtService.queryProvincesFromMDM();
				return returnSuccess(MessageType.QUERY_SUCCESS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return returnError(e.toString());
			}
		} catch (BusinessException e) {
			return returnError(e);
		}
	}

	/**
	 * 新接口获得市的数据
	 * 
	 * @return
	 */
	@JSON
	public String queryCitysFormMDM() {
		try {
			try {
				areas = districtService.queryCitysFromMDM();
				return returnSuccess(MessageType.QUERY_SUCCESS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return returnError(e.toString());
			}
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	/**
	 * 新接口获得区县的数据
	 * @return
	 */
	@JSON
	public String queryCountycesFormMDM() {
		try {
			try {
				areas = districtService.queryCountyFromMDM();
				return returnSuccess(MessageType.QUERY_SUCCESS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return returnError(e.toString());
			}
		} catch (BusinessException e) {
			return returnError(e);
		}
	}


	public List<District> getAreas() {
		return areas;
	}

	public void setAreas(List<District> areas) {
		this.areas = areas;
	}

}
