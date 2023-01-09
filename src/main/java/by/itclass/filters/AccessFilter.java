package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AccessFilter",
        value = {AppConstant.CABINET_JSP, AppConstant.MYNEWS_JSP, AppConstant.ADD_NEWS_JSP, AppConstant.VIEW_CONT,
        AppConstant.RATING_NEWS_CONT, AppConstant.NEWS_JSP,AppConstant.SAVE_NEWS_CONT})
public class AccessFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("AccessFilter. Method init()");
    }

    public void destroy() {
        System.out.println("AccessFilter. Method destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //своя реализация
        System.out.println("AccessFilter. Method doFilter()");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session= req.getSession();
        Object user=session.getAttribute(AppConstant.USER_ATTR);
        if(user!=null){
            chain.doFilter(req,res);
        }else{
            res.sendRedirect(req.getContextPath()+AppConstant.MAIN_PAGE_CONT);
        }

    }
}
