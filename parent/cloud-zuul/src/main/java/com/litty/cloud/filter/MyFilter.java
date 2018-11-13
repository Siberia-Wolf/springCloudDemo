package com.litty.cloud.filter;

import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Component
@Slf4j
public class MyFilter extends ZuulFilter {

    /*
      -  `pre`：请求在被路由之前执行
      - `routing`：在路由请求时调用
      - `post`：在routing和errror过滤器之后调用
      - `error`：处理请求时发生错误调用
     */
    @Override
    public String filterType() {
        log.info("登录校验，肯定是在前置拦截--->{}","filterType");

        return FilterConstants.PRE_TYPE;
    }

    /*
    通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
     */
    @Override
    public int filterOrder() {
        log.info("执行过滤器顺序--->{}","filterOrder");
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /*
    返回一个`Boolean`值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
     */
    @Override
    public boolean shouldFilter() {
        log.info("执行过滤器--->{}","shouldFilter");
        return true;
    }

    /*
    过滤器的具体业务逻辑。
     */
    @Override
    public Object run() throws ZuulException {

        HashMap<Object, Object> map = Maps.newHashMap();

        // 1）获取Zuul提供的请求上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        log.info("获取Zuul提供的请求上下文对象---{}",context);
        // 2) 从上下文中获取request对象
        HttpServletRequest request = context.getRequest();
        log.info("从上下文中获取request对象---{}",request);
        // 3) 从请求中获取token
        String accessToken = request.getParameter("access-token");
        accessToken = "========";
        log.info("从请求中获取token---{}",accessToken);
        // 4) 判断
        if(StringUtils.isBlank(accessToken)){
            log.info("没有token，登录校验失败，拦截---{}","登录失败");
            // 没有token，登录校验失败，拦截
            context.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

            map.put("success",false);
            map.put("msg","登录失败");

            log.info("返回值对象---{}",map);

            return map;
        }

        map.put("success",true);
        map.put("msg","登录成功");

        log.info("返回值对象---{}",map);

        return map;
    }


}
