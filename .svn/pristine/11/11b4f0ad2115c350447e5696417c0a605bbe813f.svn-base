package com.hoau.how.module.bse.server.action.company;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.server.service.company.ICompanyScreenService;
import com.hoau.how.module.bse.server.service.company.QueryGisServer;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.util.UUIDUtil;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Controller
@Scope("prototype")
public class CompanyBatchQueryAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(CompanyBatchQueryAction.class);
	private static final int MAX_POST_SIZE = 9 * 1024 * 1024;

	@Resource
	private ICompanyScreenService companyScreenService;
	@Resource
	private QueryGisServer queryGisServer;
	private File uploadFile;
	private String uploadFileFileName;
	/** 
     * 被下载的文件名 
     */  
    private String fileName;
    /** 
     * 被下载的资源路径 
     */  
    private String inputPath; 
    
	private String errorMsg;
	private String errorType;
	private String categoryName;
	public String index() throws Exception {
		return "index";
	}
	
	public String batchUploadCompany(){
		try{
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, null);
			String directory = "/upload/batchExcelInfo";
			String downloadDirectory = "/download/batch";
			String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
			String targetDownloadDirectory = ServletActionContext.getServletContext().getRealPath(downloadDirectory);
			//生成上传的文件对象
			File target = new File(targetDirectory,this.uploadFileFileName);
			String fileNames = target.getName();
			String suffix = fileNames.substring(fileNames.lastIndexOf(".") + 1);
			long length = target.length();
			if (length > MAX_POST_SIZE) {
				setThisErrorMsg("系统异常：文件上传不能大于9M");
				return "batchUploadCompany";
			}
			if (suffix.equals("xls")  || suffix.equals("xlsx")){
				//如果文件已经存在，则删除原有文件
				if(target.exists()){
					target.delete();
				}
				//复制file对象，实现上传
				try {
					FileUtils.copyFile(this.uploadFile, target);
					String fileName = UUIDUtil.getUUID() + ".xls";
					this.fileName = fileName;
					this.inputPath = downloadDirectory;
					//路径如果不存在，则创建
					new File(targetDownloadDirectory).mkdirs();
					queryGisServer.queryGisServer(targetDirectory + File.separator + this.uploadFileFileName,
							"xls" , targetDownloadDirectory + File.separator + fileName);
					ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, "<p class='succ'><span class='icon_succ'></span>下载完成！</p>");
				} catch (IOException e) {
					e.printStackTrace();
					ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, "<p class='erro'><span class='icon_del'></span>"+e.getMessage()+"</p>");
				} catch (Exception ex){
					ex.printStackTrace();
					ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, "<p class='erro'><span class='icon_del'></span>"+ex.getMessage()+"</p>");
				}
			}else {
				setThisErrorMsg("系统异常：上传文件格式不正确");
				return "batchUploadCompany";
			}
		}catch(Exception ex){
			logger.error("CompanyBatchQueryAction batchUploadOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "batchUploadCompany";
	}
	
	/**
	 * 监控是否已经下载完成
	 * @return
	 * @author 莫涛
	 * @date 2015年10月28日
	 * @update
	 */
	public String queryDownLoadStatusJson(){
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
		if(obj != null){
			this.errorMsg = obj.toString();
			ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, null);
		}
		return "queryDownLoadStatusJson";
	}
	
	/** 
     * 获取下载显示的文件名称 
     *  
     * @return 
     */  
    public String getDownloadFileName() {  
        String downFileName = this.fileName;  
        try {
        	if(downFileName != null && !downFileName.endsWith("")){
        		downFileName = new String(downFileName.getBytes(), "ISO-8859-1");
        	}
        } catch (UnsupportedEncodingException e) {
          	e.printStackTrace();
        }  
        return downFileName;
    }  
  
    /** 
     * 配置stream类型结果时，需指定inputName；inputName为方法名去掉get前缀，并且首字母小写的字符串； 
     * 比如此例中的inputName为 targetFile 
     *  
     * @return 
     */  
    public InputStream getTargetFile() {
        InputStream resourceAsStream = ServletActionContext.getServletContext().getResourceAsStream(  
                inputPath + File.separator + this.fileName);
        return resourceAsStream;
    }
	
	private void setThisErrorMsg(String msg){
		String elsemessages = "";
		try {
			elsemessages = URLEncoder.encode("<p class='erro'><span class='icon_del'></span>"+msg+"</p>", "utf-8");
			this.errorMsg = elsemessages;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}