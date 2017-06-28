package im.hdy.Interceptor;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.rsa.utils.Constants;
import im.hdy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hdy on 2017/6/23.
 * 进行用户的权限认证
 */
public class AuthSpringMVCInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    /**
     * 在Controller处理之前进行调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (token == null) {
            print(response);
            return false;
        } else {
            String userToken = userService.getUserTokenByToken(token);
            //获取到了绑定当前id的用户编号
            if (userToken != null && !"".equals(userToken)) {
                String id = userService.getUserTokenById(userToken);
                if (!id.equals(token)) {
                    //说明是过时的token对象.
                    userService.saveUserTokenByToken(null, token);
                    print(response);
                    return false;
                } else {
                    request.setAttribute(Constants.REQUEST_USER_KEY, Long.valueOf(id));
                    return true;
                }
            } else {
                print(response);
            }
        }
        return true;
    }


    //这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    //该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    public void print(HttpServletResponse response) {
        Status status = new Status(401, "身份验证失败");
        String jsonString = JSON.toJSONString(status);
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(jsonString);
        out.flush();
        out.close();
    }
}
