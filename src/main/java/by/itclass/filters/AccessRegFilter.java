package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AccessRegFilter", value = AppConstant.REG_JSP)
public class AccessRegFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("AccessFilter. Method doFilter()");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session= req.getSession();
        Object user=session.getAttribute(AppConstant.USER_ATTR);

        if(user!=null){
            res.sendRedirect(req.getContextPath()+AppConstant.CABINET_JSP);
        }else{
            chain.doFilter(req,res);
        }


    }
}
