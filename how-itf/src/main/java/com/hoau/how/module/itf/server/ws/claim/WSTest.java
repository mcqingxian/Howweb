package com.hoau.how.module.itf.server.ws.claim;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.hoau.how.module.common.constants.ClaimEnum;
import com.hoau.how.module.common.constants.SysConfigConstants;
import com.hoau.how.module.util.ZipUtil;

public class WSTest {
	private static final QName SERVICE_NAME = new QName("http://hoauweb.ws.erry.com/", "ClaimsWBServiceImplService");
	
	public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = new URL("http://10.39.251.109/TDHY_CLAIMS/ws-services/claimsWBService?wsdl");
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        ClaimsWBServiceImplService ss = new ClaimsWBServiceImplService(wsdlURL, SERVICE_NAME);
        ClaimsWBService port = ss.getClaimsWBServiceImplPort();  
        
        {
            System.out.println("Invoking uploadClaims...");
            com.hoau.how.module.itf.server.ws.claim.ClaimsInfo _uploadClaims_claimsInfo = new com.hoau.how.module.itf.server.ws.claim.ClaimsInfo();
            _uploadClaims_claimsInfo.setAccidentType("3");
            _uploadClaims_claimsInfo.setBillNo("F6137612");
            _uploadClaims_claimsInfo.setBillTel("13651973694");
            _uploadClaims_claimsInfo.setCargoType("2");
            _uploadClaims_claimsInfo.setClaimsAmount(new BigDecimal("1"));
            _uploadClaims_claimsInfo.setClaimsOwner("1");
            _uploadClaims_claimsInfo.setContactMail("");
            _uploadClaims_claimsInfo.setContactTel("13651973694");
            _uploadClaims_claimsInfo.setCreateBy("00115365");
            _uploadClaims_claimsInfo.setExceptionCount(Long.parseLong("1"));
            _uploadClaims_claimsInfo.setPayeeName("上海");
            _uploadClaims_claimsInfo.setReason("1");
            _uploadClaims_claimsInfo.setIdentificationCardFiles(new byte[]{});
            _uploadClaims_claimsInfo.setBankCardFiles(new byte[]{});
            _uploadClaims_claimsInfo.setCargoReceiptFiles(new byte[]{});
            _uploadClaims_claimsInfo.setInvoiceFiles(new byte[]{});
            _uploadClaims_claimsInfo.setDamageFiles(new byte[]{});
//            _uploadClaims_claimsInfo.setChannel(1);
            System.out.println("port:------------"+port);
            com.hoau.how.module.itf.server.ws.claim.ResponseClaimsObject _uploadClaims__return = port.uploadClaims(_uploadClaims_claimsInfo);
//            com.hoau.how.module.itf.server.ws.claim.ResponseClaimsObject _uploadClaims__return = port.getClaims("708527");
            System.out.println("uploadClaims.result=" + _uploadClaims__return.errorMessage);


            }
        
    }
    /**
	 * 
	* @Title: getImages 
	* @Description: 从文件系统获取图片
	* @param @param waybill
	* @param @param type    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static byte[] getImages(String waybill,String type) {
		String parentPath = getParent(waybill, type);
		return ZipUtil.zip(parentPath).toByteArray();
	}
	public static String getParent(String waybill, String type) {
		String root = SysConfigConstants.CLAIM_IMG_DIR;
		String path = root + File.separatorChar + waybill + File.separatorChar
				+ type;
		return path;
	}
}
