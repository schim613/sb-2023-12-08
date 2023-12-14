package com.ll.sb20231208.standard.util;

import lombok.SneakyThrows;

public class Ut {
    public static class thread {

        // @SneakyThrows
        // public static void sleep(int milli) {
        //    Thread.sleep(milli);

        @SneakyThrows
        public static void sleep(int milli) {
            try {
                Thread.sleep(milli);
            } catch (InterruptedException e) {
                // InterruptedException 처리
                Thread.currentThread().interrupt();
            }
        }
    }
}