package issues;

/**
 * 償還年月日を文字列に変換し、年月日を加えるプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class Paymentday {
	/**
	 * 年を保存します。
	 */
	private int year;

	/**
	 * 月を保存します。
	 */
	private int month;

	/**
	 * 日を保存します。
	 */
	private int day;

	/**
	 * String型の月を保存します。
	 */
	private String monthString;

	/**
	 * String型の日を保存します。
	 */
	private String dayString;
	
	/**
	 * paymentStringメソッド
	 * 償還年月日の値を年月日を付けて返す
	 * @param maturity 整数値 償還年月日
	 * @return 償還年月日の値を年月日を付けた文字列
	 */
	public String paymentString(int maturity) {
		year = maturity / 10000;
		month = (maturity - (year * 10000))/ 100;
		day = maturity - (year * 10000) - (month * 100);
		
		if(month < 10) {
			monthString = " " + String.valueOf(month);
		} else {
			monthString = String.valueOf(month);
		}

		if(day < 10) {
			dayString = " " + String.valueOf(day);
		} else {
			dayString = String.valueOf(day);
		}

		return String.valueOf(year) + "年" + monthString + "月" + dayString + "日";
	}
}


