package com.jason.codepractise.pattern.Strategymodel;

import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.util.List;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description:
 */
public class Compression {
    public static void main(String[] args) {
        CompressionContext ctx = new CompressionContext();
        ctx.setStrategy(CompressionPreperence.getPreferedStrategy());
        ctx.createArchieve(null);
    }
}

/**
 * 压缩策略接口
 */
interface CompressionStrategy {
    void compress(List<File> files);
}

class CompressionPreperence {
    public static CompressionStrategy getPreferedStrategy() {
        return new RarCompressionStrategy();
    }
}

class RarCompressionStrategy implements CompressionStrategy {
    @Override
    public void compress(List<File> files) {
        // RAR 压缩
    }
}

class CompressionContext {
    private CompressionStrategy strategy;

    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void createArchieve(List<File> files) {
        strategy.compress(files);
    }
}