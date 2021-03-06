package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cadqe13@gmail.com on 2022-05-16
 * Blog : https://velog.io/@donsco
 * GitHub : https://github.com/wlwlsus
 */
@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final MyLogger myLogger;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request){
		String requestURL = request.getRequestURL().toString();

		myLogger.setRequestURL(requestURL);

		myLogger.log("controller test");
		logDemoService.logic("testId");

		return "OK";
	}
}
