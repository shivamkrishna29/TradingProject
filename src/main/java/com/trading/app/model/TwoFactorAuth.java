package com.trading.app.model;

import com.trading.app.role.VERIFICATION_TYPE;

import lombok.Data;

@Data
public class TwoFactorAuth {

	private boolean isEnabled = false;
	
	private VERIFICATION_TYPE sendTo;

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public VERIFICATION_TYPE getSendTo() {
		return sendTo;
	}

	public void setSendTo(VERIFICATION_TYPE sendTo) {
		this.sendTo = sendTo;
	}
	
	
}
