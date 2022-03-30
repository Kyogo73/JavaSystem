package issues;
/**
 * 保有銘柄の償還年月日、利率、クーポン回数を保持するプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class Bond extends Issue {
    /**
     * 償還年月日を保存します。
     */
    private int maturity;

    /**
     * 利率を保存します。
     */
	private double couponRate;

    /**
     * クーポン回数を保存します。
     */
    private int coupon;

    /**
     * 保有銘柄のデータを保持する。
     * @param code　銘柄コード
     * @param name　銘柄名
     * @param maturity　整数値　償還年月日
     * @param couponRate　少数　利率
     * @param coupon　整数値　クーポン回数
     */
    public Bond(String code, String name, int maturity, double couponRate, int coupon) {
        super(code, name);
		
        if(20000101 > maturity) {
			throw new IllegalArgumentException();
        } else if(29991231 < maturity) {
            throw new IllegalArgumentException();
        } else {
            this.maturity = maturity;
        }
		
		this.couponRate = couponRate;
    
		if(coupon >= 0) {
            this.coupon = coupon;
        } else {
			throw new IllegalArgumentException();
        }
    }

    /**
     * getMaturityメソッド
     * 償還年月日を返す。
     * @return 整数値 償還年月日
     */
    public int getMaturity() {
        return this.maturity;
    }

    /**
     * getCouponRateメソッド
     * 利率を返す。
     * @return 少数 利率
     */
	public double getCouponRate() {
		return this.couponRate;
	}

    /**
     * getCouponメソッド
     * クーポン回数を返す。
     * @return 整数値 クーポン回数
     */
    public int getCoupon() {
        return this.coupon;
    }
}