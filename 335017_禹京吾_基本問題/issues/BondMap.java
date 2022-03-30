package issues;

import java.util.Map;
import java.util.HashMap;

/**
 * Bond型のデータをマップとして保持するプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class BondMap {
	/**
	 * Bond型のデータを保有するMapです。
	 */
	private Map<String, Bond> bondMap = new HashMap<>();

	/**
	 * getBondMapメソッド
	 * BondMap型のデータを返す。
	 * @return BondMap型のデータ
	 */
	public Map<String, Bond> getBondMap() {
		return this.bondMap;
	}

	/**
	 * loadAddBondメソッド
	 * マスターファイルを読み込むときに、bondデータをマップに追加する。
	 * @param issue Bond型
	 */
	public void loadAddBond(Bond issue) {
		bondMap.put(issue.getCode(), issue);
	}
	
	/**
	 * findBondPositionメソッド
	 * 渡されたコードがマップにあれば、そのデータを返す。なければnullを返す。
	 * @param code 文字列 銘柄コード
	 * @return bondデータ もしくは null
	 */
	public Bond findBondPosition(String code) {		
		if(bondMap.containsKey(code)) {
			return bondMap.get(code);
		} else {
			return null;
		}
	}
}

