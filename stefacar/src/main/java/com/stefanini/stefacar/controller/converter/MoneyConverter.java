package com.stefanini.stefacar.controller.converter;

import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="money")
public class MoneyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String money) {
		return Double.parseDouble(money);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object moneyFormat) {
		Double money = (Double) moneyFormat;
		return NumberFormat.getCurrencyInstance().format(money);
	}
}