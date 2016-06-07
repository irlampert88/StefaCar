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

@WebFilter(filterName = "MECHANIC_ROLE", urlPatterns = {
		"/pages/manufacturer/manufacturerView.xhtml,/pages/manufacturer/manufacturerRegister.xhtml,"
				+ "/pages/outfitter/outfitterView.xhtml,/pages/outfitter/outfitterRegister.xhtml,"
				+ "/pages/pieces/piecesView.xhtml,/pages/pieces/piecesRegister.xhtml," })
public class MECHANIC_ROLE implements Filter {

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
			resp.sendRedirect(req.getServletContext().getContextPath() + "/main.xhtml");
		} else if (session.getLogin()) {
			if (session.getROLE_MECHANIC() == true) {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}

}
