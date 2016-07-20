package com.stefanini.stefacar.controller.shared;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessengerSystem {

	public static void notifyError(String errorMessage, String details){
		notify(FacesMessage.SEVERITY_ERROR, errorMessage, details);
	}
	
	public static void notifyNotice(String noticeMessage, String details){
		notify(FacesMessage.SEVERITY_WARN, noticeMessage, details);
	}
	
	public static void notifyInfo(String infoMessage, String detail){
		notify(FacesMessage.SEVERITY_INFO,	infoMessage, detail);
	}
	
	private static void notify(FacesMessage.Severity severity, String message, String detail){
		FacesMessage msg = new FacesMessage(severity,	message, detail);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
