package com.example.thread.frokjuoin.example02;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    long from, to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    protected Long compute() {
        long size = to - from + 1;

        if (size <= 5)
            return sum();

        long half = (from + to) / 2;

        SumTask left = new SumTask(from, half);
        SumTask right = new SumTask(half + 1, to);

        left.fork();
        return right.compute() + left.join();
    }

    private Long sum() {
        long temp = 0L;
        for (long i = from; i <= to; i++) {
            temp += i;
        }
        return temp;
    }
}
