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

package com.github.xingshuangs.iot.protocol.rtsp.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * RTSP content type.
 * 接收内容类型
 *
 * @author xingshuang
 */
public enum ERtspContentType {

    /**
     * sdp
     */
    SDP("application/sdp"),

    /**
     * parameter
     */
    PARAMETER("text/parameters"),

    ;

    // 静态内部类（static 内部类）实现懒加载
    private static class Holder {
        private static final Map<String, ERtspContentType> INSTANCE = createMap();

        private static Map<String, ERtspContentType> createMap() {
            Map<String, ERtspContentType> map = new HashMap<>();
            for (ERtspContentType item : ERtspContentType.values()) {
                map.put(item.code, item);
            }
            return map;
        }
    }

    public static ERtspContentType from(String data) {
        return Holder.INSTANCE.get(data);
    }

    private final String code;

    ERtspContentType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
