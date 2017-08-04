package com.hoau.mhow.module.bse.server.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.IBseOperationLogService;
import com.hoau.mhow.module.bse.api.shared.domain.BseOperationLogEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.server.dao.BseOperationLogMapper;
import com.hoau.wechat.constants.LogConstants;
import com.hoau.wechat.constants.OrderConstants;
import com.hoau.wechat.constants.SessionConstants;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Dy 2015年12月30日
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BseOperationLogService implements IBseOperationLogService {

	@Resource
	BseOperationLogMapper operationMapper;

	@Override
	public void insert(Object entity, int type) {
		BseOperationLogEntity operate = new BseOperationLogEntity();
		CustomerContactEntity customer = new CustomerContactEntity();
		NetOrderEntity order = null;
		if (type >= 0 && type < 3 && entity != null) {
			switch (type) {
			case 0:
				operate.setOperationType(LogConstants.OPERATION_TYPE.REGISTERED
						.toString());
				break;
			case 1:
				operate.setOperationType(LogConstants.OPERATION_TYPE.LOGIN
						.toString());
				break;
			case 2:
				order = (NetOrderEntity) entity;
				if (order.getEinoStatus().equals(
						OrderConstants.ORDER_STATUS_KEYS.ADD)) {
					operate.setOperationType(LogConstants.OPERATION_TYPE.CREATEORDER
							.toString());
				} else if (order.getEinoStatus().equals(
						OrderConstants.ORDER_STATUS_KEYS.VOID)) {
					operate.setOperationType(LogConstants.OPERATION_TYPE.CANCELORDER
							.toString());
				}
				operate.setLoginUser(order.getEinoEbccId().toString());
				operate.setOrderId(order.getEinoId());
				break;
			default:
				break;
			}
			if (StringUtil.isEmpty(operate.getLoginUser())) {
				customer = (CustomerContactEntity) entity;
				operate.setLoginUser(customer.getEbccId().toString());
			}
			operate.setLoginType(ActionContext.getContext().getSession()
					.get(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE)
					.toString());
			operate.setOperationIp(getIp(ServletActionContext.getRequest()));
			operate.setHowType(LogConstants.HOW_TYPE.MOBILE_HOW.toString());
			operationMapper.insertOperationLog(operate);
		}
	}

	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
