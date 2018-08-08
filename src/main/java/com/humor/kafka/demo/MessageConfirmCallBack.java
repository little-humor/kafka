package com.humor.kafka.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * create by humor
 * @date 2018/8/8 下午1:37
 */
@Slf4j
public class MessageConfirmCallBack implements ListenableFutureCallback {

    @Override
    public void onFailure(Throwable throwable) {
        log.info("--callback---发送消息失败-----");
    }

    @Override
    public void onSuccess(Object o) {
        log.info("--callback---发送消息成功------");
    }
}
