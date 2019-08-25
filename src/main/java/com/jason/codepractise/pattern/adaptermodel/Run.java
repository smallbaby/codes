package com.jason.codepractise.pattern.adaptermodel;

/**
 * 温故而知新.
 * author: zhangkai
 * date: 2019-08-25
 * description:适配器：将两个不想兼容的接口通过适配器进行相互转化
 */
public class Run {
    public static void main(String[] args) {
        Scanner s = new Scanner();
        s.read(new TXT());
        s.read(new HTMLAdapter(new HTML()));
    }
}

class Scanner {
    public void read(Readable material) {
        material.read();
    }
}

interface Readable {
    void read();
}

class TXT implements Readable {
    @Override
    public void read() {
        // 读取txt格式
    }
}

class HTML {
    public void toReadableFormat() {
        //
    }
}

//////// 适配器
class HTMLAdapter implements Readable {
    private HTML html;

    public HTMLAdapter(HTML html) {
        this.html = html;
    }

    @Override
    public void read() {
        html.toReadableFormat();
    }
}




