package com.csrg.syr.parentControl.child.Logic;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;


public class EMailSendService extends IntentService {

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle bundle = intent.getExtras();
		sendEmail(bundle);

	}

	public EMailSendService() {
		super("EMailSendService");
	}

	private void sendEmail(Bundle bundle) {
		/*
		 * send email to the parentset
		 */

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

		String aEmailList[] = bundle
				.getStringArray(android.content.Intent.EXTRA_EMAIL);
		String aEmailCCList[] = bundle
				.getStringArray(android.content.Intent.EXTRA_CC);
		String aEmailBCCList[] = bundle
				.getStringArray(android.content.Intent.EXTRA_BCC);
		String aEmailSubject = bundle
				.getString(android.content.Intent.EXTRA_SUBJECT);
		String aEmailTEXT = bundle.getString(android.content.Intent.EXTRA_TEXT);

		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
		emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
		emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);

		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				aEmailSubject);

		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, aEmailTEXT);

		startActivity(emailIntent);
	}
}
