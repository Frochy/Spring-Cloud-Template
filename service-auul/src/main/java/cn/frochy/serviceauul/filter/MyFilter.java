package cn.frochy.serviceauul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     *
     * @return a string that represent the type of filter
     * zull provided 4 different lifecycle filter:
     * pre: before route
     * routing
     * post: after routing
     * error: call when the sending operation error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s>>>%s",request.getMethod(), request.getRequestURI()));;
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                logger.warn(e.getMessage());
                return null;
            }
        }
        logger.info("ok");
        return null;
    }
}
