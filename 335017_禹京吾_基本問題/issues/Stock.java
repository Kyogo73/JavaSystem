package issues;

/**
 * 保有数量、簿価、時価を保持するクラス
 * @author 禹京吾
 * @version 1.0.0
 */
public class Stock extends Issue {
    /**
     * 保有数量を保存します。
     */
    private double amount;

    /**
     * 簿価を保存します。
     */
    private double bookValue;

    /**
     * 時価を保存します。
     */
    private double actualValue;
    
    /**
     * コンストラクタ
     * @param code 文字列 銘柄コード
     * @param name 文字列 銘柄名
     */
    public Stock(String code, String name) {
        super(code, name);
    }

    /**
     * setAmountメソッド
     * 保有数量をセットする。
     * @param amount 少数 保有数量
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * setBookValueメソッド
     * 簿価をセットする。
     * @param bookValue 整数値 簿価
     */
    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    /**
     * setActualValueメソッド
     * 時価をセットする。
     * @param actualValue 整数値 時価
     */
    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

     /**
     * getAmountメソッド
     * 保有数量を返す。
     * @return 保有数量
     */
    public double getAmount() {
        return this.amount;
    }
    
    /**
     * getBookValueメソッド
     * 簿価を返す。
     * @return 簿価
     */
    public double getBookValue() {
        return this.bookValue;
    }

    /**
     * getActualValueメソッド
     * 時価を返す。
     * @return 時価
     */
    public double getActualValue() {
        return this.actualValue;
    }
}
