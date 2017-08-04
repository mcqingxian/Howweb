package com.hoau.wechat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.dao.impl.LotteryRecordDao;
import com.hoau.wechat.service.ICompusActivityService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.util.net.WeixinUtil;
import com.hoau.wechat.utils.TimeUtils;
import com.hoau.wechat.vo.CompusActivityCode;
import com.hoau.wechat.vo.CompusActivityInfo;
import com.hoau.wechat.vo.LotteryActivityDraw;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.VoucherActivity;

/**
 * @ClassName: CompusActivityService
 * @Description: 校园托运活动
 * @author hairen.long@hoau.net
 * @date 2015年5月20日 下午9:21:58
 */
@Service
public class CompusActivityService implements ICompusActivityService {
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private String[] arrCitys = new String[]{"北京","沈阳","南京","苏州","上海","西安","济南","杭州","湖南","湖北","重庆"};

	@Resource
	private LotteryRecordDao lotteryRecordDao;
	
	

	@Override
	public void saveSharedRecord(ShareRecode shareRecode) {
		ShareRecode record = new ShareRecode();
		record.setId(UUIDUtil.getUUID());
		record.setShareTime(new Date());
		record.setArticleid(shareRecode.getArticleid().trim());
		record.setOpenid(shareRecode.getOpenid().trim());
		record.setState(shareRecode.getState().trim());
		lotteryRecordDao.saveSharedRecord(record);
	}

	@Override
	public void updateActivityTicket(Map<String, String> inputParams) {
		lotteryRecordDao.updateVoucher(null,null, inputParams.get(MsgKey.KEY_CONTENT), 1);
	}

	@Override
	public VoucherActivity findActivityInfo(String openid) {
		return lotteryRecordDao.findVoucher(null, openid);
	}

	@Override
	public List<CompusActivityInfo> findLastRecord() {
		List<VoucherActivity> records = lotteryRecordDao.findLastLotteryRecord();
		List<CompusActivityInfo> infos = new ArrayList<CompusActivityInfo>();
		for(VoucherActivity record : records){
			infos.add(lotteryRecordDao.findActivityInfo(null, record.getOpenid()));
		}
		return infos;
	}

	@Override
	public LotteryActivityDraw gainDrawResult(String openid, String city) {
		LotteryActivityDraw result = new LotteryActivityDraw();
		result.setQualification(true);
		VoucherActivity voucher = null;
		// openid 是否中过奖
		// 中过奖
		if (lotteryRecordDao.hasLotteryOfOpenId(openid)) {
			voucher = lotteryDraw(openid, true,null);
		} else {// 没中过奖
			voucher = lotteryDraw(openid, false,city);
		}
		result.setVoucherActivity(voucher);
		return result;
	}

	private VoucherActivity lotteryDraw(String openid, boolean beenWinning,String city) {
		List<String> citys = Arrays.asList(arrCitys);
		VoucherActivity vouchers = null;
		// 中过奖 谢谢惠顾
		if (beenWinning) {
			vouchers = new VoucherActivity();
			vouchers.setVouchersName("感谢您的参与！");
			vouchers.setId(5000);
		} else {
			// 抽奖
			//TODO 抽奖概率
			if(citys.contains(city)){
				vouchers = getLotteryTicket(openid,getRandom(50));
			}else{
				vouchers = getLotteryTicket(openid,getRandom(50));
			}
			if (vouchers == null) {
				// 未中奖，谢谢惠顾的等字样
				vouchers = new VoucherActivity();
				vouchers.setVouchersName("感谢您的参与！");
				vouchers.setId(5000);
			}
		}
		return vouchers;
	}
	
	private int getRandom(int scop){
		return new Random().nextInt(scop);
	}

	/**
	 * @Title: getLotteryTicket
	 * @Description:抽奖规则
	 * @param openid
	 * @param id 随机ID
	 * @return
	 */
	private VoucherActivity getLotteryTicket(String openid, int id) {
		VoucherActivity voucher = null;
		try {
			int remainderTicketCount = lotteryRecordDao.remainderLotteryTicketCount();
			//TODO  xiugai
			int remainderActivityDays = TimeUtils.daysBetween(sdf.format(new Date()), "2015-06-01 00:00:00");
			if(remainderActivityDays != 0 && remainderTicketCount != 0){
				int winCount = (int)Math.ceil((double)remainderTicketCount/remainderActivityDays);
				if(lotteryRecordDao.winningCountInDay() < winCount){
					voucher = lotteryRecordDao.findVoucher(id,null);
					if(voucher != null){
						lotteryRecordDao.updateVoucher(id,openid,null,null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voucher;
	}

	/**
	 * 查询抽奖资格及次数
	 */
	@Override
	public Map<String, Object> hasQualificationsCount(String openid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int count = 0;
		List<CompusActivityInfo> infos = lotteryRecordDao.findActivityinfos(openid);
		for (CompusActivityInfo info : infos) {
			if (info.getForwardCount() >= 3 && info.getStatus() == 0) {
				// 更新 记录 表示这个幸运号已抽奖
//				lotteryRecordDao.updateActivityInfo(info.getCompetitionCode(),
//						null, 1, null);
				count++;
			}
		}
		resultMap.put("count", count);
		if(infos.size()>0){
			resultMap.put("competitionCode", infos.get(0).getCompetitionCode());
			resultMap.put("city", StringUtils.isEmpty(infos.get(0).getCity())?infos.get(0).getProvince():infos.get(0).getCity());
		}
		return resultMap;
	}

	@Override
	public void updateActivityInfoStatus(String code) {
		lotteryRecordDao.updateActivityInfo(code,null, 1, null);
	}

	/**
	 * 统计转发次数
	 */
	@Override
	public String statisticsActivityCode(Map<String, String> inputParams) {
		String respMsg = "";
		String activityCode = inputParams.get(MsgKey.KEY_CONTENT);
		String openid = inputParams.get(MsgKey.KEY_FROMUSER);
		CompusActivityInfo info = lotteryRecordDao.findActivityInfo(activityCode,null);
		if (info != null) {
			if (openid.equals(info.getOpenid())) {
				respMsg = "本人发送幸运码无效哦,赶快邀请小伙伴来发送吧!/::)";
			} else {
				if (info.getFriendOpenid() != null
						&& info.getFriendOpenid().contains(openid)) {
					respMsg = "您只能帮您好友转发一次哦!/::)";
				} else {
					info.setForwardCount(info.getForwardCount() + 1);
					if (info.getForwardCount() >= 3) {
						respMsg = "您的好友已获得一次抽奖机会,赶快通知您的好友抽奖吧!/::)";
					} else {
						respMsg = "您的回复使您的好友离抽奖更进一步!/::)";
					}
					info.setFriendOpenid(info.getFriendOpenid() == null ? openid
							: info.getFriendOpenid() + "," + openid);
					lotteryRecordDao.updateActivityInfo(
							info.getCompetitionCode(), info.getForwardCount(),
							null, info.getFriendOpenid());
				}
			}
		} else {
			respMsg = "查无此幸运号,请查看是否输入有误！/::)";
		}
		return respMsg;
	}

	@Override
	// @Transactional
	public String gainCompetitionCode(Map<String, String> inputParams) {
		String openid = inputParams.get(MsgKey.KEY_FROMUSER);
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+WeixinUtil.queryAccessToken(false)+"&openid="+openid;
		String respMsg = "";
		if (lotteryRecordDao.hasQualificationsToday(openid)) {
			CompusActivityCode activityCode = lotteryRecordDao.gainCompetitionCode();
			if (activityCode == null) {
				respMsg = "小微很努力的获取幸运号失败了！/::L\n" + "再发一次吧！/::)";
			} else {
				respMsg = "【天地华宇校园行,多重好礼免费送】\n" + "恭喜您获得天地华宇校园托运幸运号："
						+ activityCode.getCode() + ",\n"
						+ "赶紧邀请3位好友来关注天地华宇微信号吧,\n" + "只要您的好友发送 "
						+ activityCode.getCode() + " 给天地华宇微信,\n"
						+ "您就有机会参与校园行李免费寄活动(华宇助手-->抽奖活动)。/::)\n"
						+ "更多优惠请联系天地华宇门店或致电400-808-6666。";
				
				CompusActivityInfo info = new CompusActivityInfo();
				info.setCompetitionCode(activityCode.getCode());
				info.setCreateTime(new Date());
				info.setForwardCount(0);
				info.setId(UUIDUtil.getUUID());
				info.setOpenid(openid);
				info.setStatus(0);
				
				CompusActivityInfo binfo = lotteryRecordDao.findActivityInfo(null, openid);
				if(binfo != null){
					info.setCity(binfo.getCity());
					info.setCountry(binfo.getCountry());
					info.setNickname(binfo.getNickname());
					info.setProvince(binfo.getProvince());
				}else{
					String res = WeixinUtil.httpRequest(url, "GET", null);
					JSONObject obj = JSONObject.fromObject(res);
					if(res.contains("errcode")){
						info.setCity("不详");		
						info.setCountry("不详");
						info.setProvince("不详");
						info.setNickname("不详");
					}else{
						info.setCity(obj.getString("city"));		
						info.setCountry(obj.getString("country"));
						info.setProvince(obj.getString("province"));
						info.setNickname(obj.getString("nickname"));
					}
				}

				lotteryRecordDao.saveActivityInfo(info);
				lotteryRecordDao.updateActivityCodeStatus(activityCode);
			}
		} else {
			respMsg = "您今天已经获得两个幸运号,明天继续努力吧！/:bye";
		}
		return respMsg;
	}

}
