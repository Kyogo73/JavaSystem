package display;

import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * 数値を一覧表示の際に整えるためのプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class Format {

    /**
     * convertDoubleメソッド
     * 少数点以下4位を切り捨て、小数点以下3位までの値の文字列を返す。
     * @param value 少数
     * @return 少数点以下3位までの値の文字列
     */
    public String convertDouble(double value) {
        return new DecimalFormat("#,##0.000").format(value);
    }

    /**
     * convertIntメソッド
     * 少数を整数値の文字列にして返す。
     * @param value 少数
     * @return 整数値の文字列
     */
    public String convertInt(double value) {
        return new DecimalFormat("#,##0").format(value);
    }

    /**
     * formatメソッド
     * 文字列を右寄せにして返す。
     * @param target 文字列
     * @param length 整数値
     * @return 右寄せにした文字列
     */
    public String formatInt(String target, int length) {
        int byteDiff = (getByteLength(target, Charset.forName("UTF-8")) - target.length())/2;
        return String.format("%" + (length-byteDiff) + "s", target);
    } 

    /**
     * formatStringメソッド
     * 文字列を左寄せにして返す。
     * @param target 文字列
     * @param length 整数値
     * @return 左寄せにした文字列
     */
    public String formatString(String target, int length) {
        int byteDiff = (getByteLength(target, Charset.forName("UTF-8")) - target.length())/2;
        return String.format("%-" + (length-byteDiff) + "s", target);
    }

    /**
     * getByteLengthメソッド
     * 文字列を指定したエンコードに変換して返す。
     * @param string 文字列
     * @param charset エンコード
     * @return 指定したエンコードに変換した文字列
     */
    public static int getByteLength(String string, Charset charset) {
        return string.getBytes(charset).length;
    }
}
