package issues;

import java.util.Map;
import java.util.HashMap;

/**
 * Stock型のデータをマップとして保持するプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class StockMap {
	/**
	 * Stock型のデータを保有するMapです。
	 */
	private Map<String, Stock> portfolio = new HashMap<>();

	/**
	 * getPortfolioMapメソッド
	 * Stock型のデータを保持するマップを返す。
	 * @return Stock型のデータを保持するマップ
	 */
	public Map<String, Stock> getPortfolioMap() {
		return this.portfolio;
	}

	/**
	 * loadAddPositionメソッド
	 * ファイルからデータを読み込むときにstockデータをマップに追加する
	 * @param stock Stock型
	 */
	public void loadAddPosition(Stock stock) {
		portfolio.put(stock.getCode(), stock);
	}

	/**
	 * addPositionメソッド
	 * 在庫入力の時に、入力された値をマップに追加する
	 * @param code 文字列 銘柄コード
	 * @param amount 少数 保有数量
	 * @param bookValue 整数値 簿価
	 */
	public void addPosition(String code, Double amount, Double bookValue) {
		Stock rePosition = portfolio.get(code);
		rePosition.setAmount(amount);
		rePosition.setBookValue(bookValue);
		portfolio.put(code, rePosition);
	}
	
	/**
	 * findStockPositionメソッド
	 * 渡されたコードがマップにあれば、そのデータを返す。なければnullを返す。
	 * @param code 文字列 銘柄コード
	 * @return stockデータ もしくは null
	 */
	public Stock findStockPosition(String code) {		
		if(portfolio.containsKey(code)) {
			return portfolio.get(code);
		} else {
			return null;
		}
	}
}

