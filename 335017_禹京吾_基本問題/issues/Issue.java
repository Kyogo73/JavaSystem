package issues;

/**
 * 保有銘柄のコードと名前を保持するプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public abstract class Issue {
	/**
	 * 銘柄コードを保存します。
	 */
	private String code;

	/**
	 * 銘柄名を保存します。
	 */
	private String name;

	/**
	 * コンストラクタ
	 * @param code String 銘柄コード
	 * @param name String 銘柄名
	 */
	public Issue(String code, String name) {
		if(code == null) {
			throw new IllegalArgumentException();
		} else {
			this.code = code;
		}

		if(name == null) {
			throw new IllegalArgumentException();
		} else {
			this.name = name;
		}
	}

	/**
	 * getCodeメソッド
	 * 銘柄コードを返す。
	 * @return 銘柄コード
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * getNameメソッド
	 * 銘柄名を返す。
	 * @return 銘柄名
	 */
	public String getName() {
		return this.name;
	}
}
