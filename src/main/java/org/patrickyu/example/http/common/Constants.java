package org.patrickyu.example.http.common;


public class Constants {
	public static class status {
		public static final int OK = 200;
		public static final int UNKNOWN_ERROR = 500;
		public static final int NO_PERMISSION = 550;
		public static final int USER_CANCEL = 551;
		public static final int NEED_LOGIN = 561;
		public static final int LOGIN_ERROR = 562;
		public static final int CANNOT_GUEST_LOGIN = 566;
		public static final int INVALID_REQUEST = 571;
		public static final int MAINTENANCE_ERROR = 600;
		public static final int DB_ERROR = 610;
		public static final int SMS_FAIL = 611;
	}

	public static class paysbuy {
		public static final String RESULT_FRONT_URI = "/refill/paysbuy/result_front";
		public static final String RESULT_BACK_URI = "/refill/paysbuy/result_back";
		public static final String CODE_SUCCEED = "00";
		public static final String CODE_PROCESS = "02";
		public static final String CODE_FAILED = "99";
		public static final String ID = "1570610184";
		public static final String SECURE_CODE = "BE5C94603B952529CB9A7D0AD98074BC";
		public static final String CURR_TYPE = "TH"; //TH:Thai Baht
		public static final String METHOD = "6"; //1:PAYSBUY_Acount 2:Visa, MasterCard, JCB, 3:PayPal, 4:American Express, 5:Online Banking, 6:Cash
		public static final String LANGUAGE = "T"; //T:Thai, E:English, J:Japanese
	}

	public static class mol {
		public static final String ID = "cmthai";
		public static final String GAME_ID = "50";
		public static final String SECRET_PIN = "88be1e5af14f061abefcc21466f41f85";
		public static final String RESULT_FRONT_URI = "/refill/mol/result_front";
		public static final String RESULT_BACK_URI = "/refill/mol/result_back";
		public static final String CHANNEL = "12call";
		public static final String CODE_SUCCEED = "000";
	}

	public static class paymentStatus {
		public static final String READY = "ready";
		public static final String PROGRESS = "progress";
		public static final String SUCCESS = "success";
		public static final String FAIL = "fail";
	}
}
