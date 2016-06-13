package com.stefanini.stefacar.controller.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stefanini.stefacar.model.domain.Login;

@WebFilter(filterName = "SALESMAN_ROLE", urlPatterns = { "/pages/sales/saleView.xhtml,/pages/sales/saleRegister.xhtml,"
		+ "/pages/sales/piecesSaleView.xhtml,/pages/sales/piecesSaleRegister.xhtml" })
public class SALESMAN_ROLE implements Filter {

	@Inject
	private Login session;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (session == null) {
			resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
		} else if (session.getLogin()) {
			if (session.getROLE_SALESMAN() == true) {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}

}
