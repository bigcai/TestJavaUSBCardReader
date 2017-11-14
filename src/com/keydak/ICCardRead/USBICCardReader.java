package com.keydak.ICCardRead;

/**
 * Created by Caisz on 2016/11/28.
 */
public interface USBICCardReader {

    /**
     * 以低功耗idle模式和非halt方式读取IC卡号
     * snrIdle = true
     * snrHalt = true
     * @return IC卡号
     */
    public String readICCard();

    /**
     * 设置参数：是否为低功耗模式，是否进行冲突处理
     *
     * @param snrIdle 是否为低功耗模式
     * @param snrHalt 是否进行冲突处理
     * @return IC卡号
     */
    public String readICCard( boolean snrIdle, boolean snrHalt);
}