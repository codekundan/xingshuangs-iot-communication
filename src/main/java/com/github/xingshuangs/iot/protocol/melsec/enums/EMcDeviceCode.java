/*
 * MIT License
 *
 * Copyright (c) 2021-2099 Oscura (xingshuang) <xingshuang_cool@163.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.xingshuangs.iot.protocol.melsec.enums;


import com.github.xingshuangs.iot.common.constant.GeneralConst;

import java.util.HashMap;
import java.util.Map;

/**
 * 软元件代码
 *
 * @author xingshuang
 */
public enum EMcDeviceCode {

    /**
     * Special relay
     * 特殊继电器
     */
    SM("SM", GeneralConst.TYPE_BIT, 10, "SM", (byte) 0x9, "SM**", 0x0091),

    /**
     * Special register
     * 特殊寄存器
     */
    SD("SD", GeneralConst.TYPE_WORD, 10, "SD", (byte) 0xA, "SD**", 0x00A9),

    /**
     * Input
     * 输入
     */
    X("X", GeneralConst.TYPE_BIT, 16, "X*", (byte) 0x9C, "X***", 0x009C, 0x5820),

    /**
     * Output
     * 输出
     */
    Y("Y", GeneralConst.TYPE_BIT, 16, "Y*", (byte) 0x9D, "Y***", 0x009D, 0x5920),

    /**
     * Internal relay
     * 内部继电器
     */
    M("M", GeneralConst.TYPE_BIT, 10, "M*", (byte) 0x90, "M***", 0x0090, 0x4D20),

    /**
     * Latch relay
     * 锁存继电器
     */
    L("L", GeneralConst.TYPE_BIT, 10, "L*", (byte) 0x92, "L***", 0x0092, 0x4D20),

    /**
     * Annunciator
     * 报警器
     */
    F("F", GeneralConst.TYPE_BIT, 10, "F*", (byte) 0x93, "F***", 0x0093, 0x4620),

    /**
     * Edge relay
     * 变址继电器
     */
    V("V", GeneralConst.TYPE_BIT, 10, "V*", (byte) 0x94, "V***", 0x0094),

    /**
     * Link relay
     * 链接继电器
     */
    B("B", GeneralConst.TYPE_BIT, 16, "B*", (byte) 0xA0, "B***", 0x00A0, 0x4220),

    /**
     * Data register
     * 数据寄存器
     */
    D("D", GeneralConst.TYPE_WORD, 10, "D*", (byte) 0xA8, "D***", 0x00A8, 0x4420),

    /**
     * Link register
     * 链接寄存器
     */
    W("W", GeneralConst.TYPE_WORD, 16, "W*", (byte) 0xB4, "W***", 0x00B4, 0x5720),

    /**
     * Timer contact
     * 定时器触点
     */
    TS("TS", GeneralConst.TYPE_BIT, 10, "TS", (byte) 0xC1, "TS**", 0x00C1, 0x5453),

    /**
     * Time coil
     * 定时器线圈
     */
    TC("TC", GeneralConst.TYPE_BIT, 10, "TC", (byte) 0xC0, "TC**", 0x00C0, 0x5443),

    /**
     * Timer current value
     * 定时器当前值
     */
    TN("TN", GeneralConst.TYPE_WORD, 10, "TN", (byte) 0xC2, "TN**", 0x00C2, 0x544E),

    /**
     * Long time contact
     * 长定时器触点
     */
    LTS("LTS", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LTS*", 0x0051),

    /**
     * Long time coil
     * 长定时器线圈
     */
    LTC("LTC", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LTC*", 0x0050),

    /**
     * Long time current value
     * 长定时器当前值
     */
    LTN("LTN", GeneralConst.TYPE_DWORD, 10, "", (byte) 0x00, "LTN*", 0x0052),

    /**
     * Retentive timer contact
     * 累计定时器触点
     */
    STS("STS", GeneralConst.TYPE_BIT, 10, "SS", (byte) 0xC7, "STS*", 0x00C7),

    /**
     * Retentive timer coil
     * 累计定时器线圈
     */
    STC("STC", GeneralConst.TYPE_BIT, 10, "SC", (byte) 0xC6, "STC*", 0x00C6),

    /**
     * Retentive timer current value
     * 累计定时器当前值
     */
    STN("STN", GeneralConst.TYPE_WORD, 10, "SN", (byte) 0xC8, "STN*", 0x00C8),

    /**
     * Long retentive timer contact
     * 长累计定时器触点
     */
    LSTS("LSTS", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LSTS", 0x0059),

    /**
     * Long retentive timer coil
     * 长累计定时器线圈
     */
    LSTC("LSTC", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LSTC", 0x0058),

    /**
     * Long retentive timer current value
     * 长累计定时器当前值
     */
    LSTN("LSTN", GeneralConst.TYPE_DWORD, 10, "", (byte) 0x00, "LSTN", 0x005A),

    /**
     * Counter contact
     * 计数器触点
     */
    CS("CS", GeneralConst.TYPE_BIT, 10, "CS", (byte) 0xC4, "CS**", 0x00C4, 0x4353),

    /**
     * Counter coil
     * 计数器线圈
     */
    CC("CC", GeneralConst.TYPE_BIT, 10, "CC", (byte) 0xC3, "CC**", 0x00C3, 0x4343),

    /**
     * Counter current value
     * 计数器当前值
     */
    CN("CN", GeneralConst.TYPE_WORD, 10, "CN", (byte) 0xC5, "CN**", 0x00C5, 0x434E),

    /**
     * Long counter contact
     * 长计数器触点
     */
    LCS("LCS", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LCS*", 0x0055),

    /**
     * Long counter coil
     * 长计数器线圈
     */
    LCC("LCC", GeneralConst.TYPE_BIT, 10, "", (byte) 0x00, "LCC*", 0x0054),

    /**
     * Long counter current value
     * 长计数器当前值
     */
    LCN("LCN", GeneralConst.TYPE_DWORD, 10, "", (byte) 0x00, "LCN*", 0x0056),

    /**
     * Link special relay
     * 链接特殊继电器
     */
    SB("SB", GeneralConst.TYPE_BIT, 16, "SB", (byte) 0xA1, "SB**", 0x00A1),

    /**
     * Link special register
     * 链接特殊寄存器
     */
    SW("SW", GeneralConst.TYPE_WORD, 16, "SW", (byte) 0xB5, "SW**", 0x00B5),

    /**
     * Direct access input
     * 直接访问输入
     */
    DX("DX", GeneralConst.TYPE_BIT, 16, "DX", (byte) 0xA2, "DX**", 0x00A2),

    /**
     * Direct access output
     * 直接访问输出
     */
    DY("DY", GeneralConst.TYPE_BIT, 16, "DY", (byte) 0xA3, "DY**", 0x00A3),

    /**
     * Index register, index register
     * 变址寄存器
     */
    Z("Z", GeneralConst.TYPE_WORD, 10, "Z*", (byte) 0xCC, "Z***", 0x00CC),

    /**
     * Index register, long index register
     * 变址寄存器长变址寄存器
     */
    LZ("LZ", GeneralConst.TYPE_DWORD, 10, "", (byte) 0x00, "LZ**", 0x0062),

    /**
     * File register, block switching method
     * 文件寄存器 块切换方式
     */
    R("R", GeneralConst.TYPE_WORD, 10, "R*", (byte) 0xAF, "R***", 0x00AF, 0x5220),

    /**
     * File register, serial number access method
     * 文件寄存器 连号访问方式
     */
    ZR("ZR", GeneralConst.TYPE_WORD, 16, "ZR", (byte) 0xB0, "ZR**", 0x00B0),

    /**
     * Refresh data register
     * 刷新数据寄存器
     */
    RD("RD", GeneralConst.TYPE_WORD, 10, "", (byte) 0x00, "RD**", 0x002C),
    ;

    // 静态内部类（static 内部类）实现懒加载
    private static class Holder {
        private static final Map<String, EMcDeviceCode> INSTANCE = createMap();

        private static Map<String, EMcDeviceCode> createMap() {
            Map<String, EMcDeviceCode> map = new HashMap<>();
            for (EMcDeviceCode item : EMcDeviceCode.values()) {
                map.put(item.symbol, item);
            }
            return map;
        }
    }

    public static EMcDeviceCode from(String data) {
        return Holder.INSTANCE.get(data);
    }

    /**
     * 符号
     */
    private final String symbol;

    /**
     * 类型
     */
    private final int type;

    /**
     * 表记，10进制和16进制
     */
    private final int notation;

    /**
     * 二进制参数，1个字节
     */
    private final byte binaryCode;

    /**
     * ascii参数
     */
    private final String asciiCode;

    /**
     * 二进制参数，2个字节
     */
    private final int binaryCodeIqr;

    /**
     * ascii参数
     */
    private final String asciiCodeIqr;

    /**
     * 1E帧的二进制编码
     */
    private final int binaryCode1E;

    EMcDeviceCode(String symbol, int type, int notation,
                  String asciiCode, byte binaryCode,
                  String asciiCodeIqr, int binaryCodeIqr) {
        this.symbol = symbol;
        this.type = type;
        this.notation = notation;
        this.asciiCode = asciiCode;
        this.binaryCode = binaryCode;
        this.asciiCodeIqr = asciiCodeIqr;
        this.binaryCodeIqr = binaryCodeIqr;
        this.binaryCode1E = 0;
    }

    EMcDeviceCode(String symbol, int type, int notation,
                  String asciiCode, byte binaryCode,
                  String asciiCodeIqr, int binaryCodeIqr,
                  int binaryCode1E) {
        this.symbol = symbol;
        this.type = type;
        this.notation = notation;
        this.asciiCode = asciiCode;
        this.binaryCode = binaryCode;
        this.asciiCodeIqr = asciiCodeIqr;
        this.binaryCodeIqr = binaryCodeIqr;
        this.binaryCode1E = binaryCode1E;
    }

    public byte getBinaryCode() {
        return binaryCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getType() {
        return type;
    }

    public int getNotation() {
        return notation;
    }

    public String getAsciiCode() {
        return asciiCode;
    }

    public int getBinaryCodeIqr() {
        return binaryCodeIqr;
    }

    public String getAsciiCodeIqr() {
        return asciiCodeIqr;
    }

    public int getBinaryCode1E() {
        return binaryCode1E;
    }

    /**
     * 是否为位类型数据
     *
     * @param deviceCode 软元件
     * @return true：是，false：否
     */
    public static boolean checkBitType(EMcDeviceCode deviceCode) {
        switch (deviceCode) {
            case SM:
            case X:
            case Y:
            case M:
            case L:
            case F:
            case V:
            case B:
            case TS:
            case TC:
            case LTS:
            case LTC:
            case STS:
            case STC:
            case LSTS:
            case LSTC:
            case CS:
            case CC:
            case LCS:
            case LCC:
            case SB:
            case DX:
            case DY:
                return true;
            default:
                return false;
        }
    }

    /**
     * 是否为字类型数据
     *
     * @param deviceCode 软元件
     * @return true：是，false：否
     */
    public static boolean checkWordType(EMcDeviceCode deviceCode) {
        switch (deviceCode) {
            case SD:
            case D:
            case W:
            case TN:
            case STN:
            case CN:
            case SW:
            case Z:
            case R:
            case ZR:
            case RD:
                return true;
            default:
                return false;
        }
    }

    /**
     * 是否为双字类型数据
     *
     * @param deviceCode 软元件
     * @return true：是，false：否
     */
    public static boolean checkDWordType(EMcDeviceCode deviceCode) {
        switch (deviceCode) {
            case LTN:
            case LSTN:
            case LCN:
            case LZ:
                return true;
            default:
                return false;
        }
    }

    /**
     * 校验1E帧是否支持
     *
     * @param deviceCode 软元件代码
     * @return true：是，false：否
     */
    public static boolean check1ESupported(EMcDeviceCode deviceCode) {
        switch (deviceCode) {
            case X:
            case Y:
            case M:
            case L:
            case F:
            case B:
            case TN:
            case TC:
            case TS:
            case CN:
            case CC:
            case CS:
            case D:
            case W:
            case R:
                return true;
            default:
                return false;
        }
    }
}
