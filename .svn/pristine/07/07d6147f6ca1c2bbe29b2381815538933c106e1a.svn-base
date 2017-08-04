package com.hoau.wechat.constants;

/**
 * @author Dy 2015年12月30日 枚举常量
 */
public interface LogConstants {

	enum HOW_TYPE implements LogConstants {
		MOBILE_HOW;
	}

	enum OPERATION_TYPE implements LogConstants {
		REGISTERED("注册"),LOGIN("登录"),CREATEORDER("下单"), CANCELORDER("撤销订单"),  CREATECONTACT(
				"创建联系人"), MODIFYCONTACT("修改联系人");

		private String desc;

		OPERATION_TYPE(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return this.desc;
		}

		@Override
		public String toString() {
			return this.desc;
		}
	}
}
