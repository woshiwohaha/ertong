package com.child.controller;

import com.child.util.CommonVal;
import com.child.util.ImgRandomCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 
图片验证码生成接口，该接口用来生成一张带有4位随机码的图片
 *
 */
@Controller
@RequestMapping("/validCode")
public class CodeController {
	@RequestMapping("code") 
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		ImgRandomCodeUtils rdnu = ImgRandomCodeUtils.Instance();//图片验证码生成器
		HttpSession session = req.getSession(); 
		// 取得随机字符串放入Session中
		session.setAttribute(CommonVal.code, rdnu.getString());//将该验证码存入session中
		// 禁止图像缓存。  
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos);//返回给前台
        sos.close(); 
    }
}
