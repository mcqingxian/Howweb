package com.hoau.how.module.bse.server.action.goodstrace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.util.CreateImageCodeUtil;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class CheckValidateCodeAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int codeCount;
	private int lineCount;
	private InputStream imageStream;
	private String code;
	private String codeName;

	public String execute() throws IOException {
		CreateImageCodeUtil vCode = new CreateImageCodeUtil(this.getWidth(),
				this.getHeight(), this.getCodeCount(), this.getLineCount());
		ActionContext ctx = ActionContext.getContext();
		if(codeName == null || codeName.equals("")){
			ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.VERCODE, vCode.getCode());
		}else{
			if(codeName.equals(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE)){
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE, vCode.getCode());
			}else if(codeName.equals(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE)){
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE, vCode.getCode());
			}else if(codeName.equals(SessionConstants.SESSION_VERCODE_KEYS.USER_REGIST_VERCODE)){
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.USER_REGIST_VERCODE, vCode.getCode());
			}
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(vCode.getBuffImg(), "JPEG", imageOut);
		imageOut.close();
		ByteArrayInputStream input = new ByteArrayInputStream(
				output.toByteArray());
		this.setImageStream(input);
		return returnSuccess();
	}

	public String codeCheck() throws IOException {
		ActionContext ctx = ActionContext.getContext();
		String sessionCode = (String)ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.VERCODE);
		if(code.equalsIgnoreCase(sessionCode)){
			return returnSuccess();
		}else{
			return returnError("验证码输入有误");
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
}
