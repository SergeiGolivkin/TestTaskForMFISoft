package com.task.multithreading.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolTaskConfig {

/**
 * По умолчанию после создания пула потоков количество потоков в пуле потоков равно 20. Когда приходит задача, создается поток для выполнения задачи.
 * Когда количество потоков в пуле потоков достигает corePoolSize, поступающие задачи будут помещены в очередь кеширования;
 * Когда очередь заполнена, продолжайте создавать потоки, когда количество потоков больше или равно maxPoolSize, начните использовать политику отклонения для отклонения
 */

    /**
     * Количество основных
     * <p>
     * потоков(количество потоков по умолчанию)
     */
    private static final int corePoolSize = 20;
    /**
     * Максимальное количество
     * потоков
     */
    private static final int maxPoolSize = 100;
    /**
     * Разрешить время
     * <p>
     * простоя потока(единица измерения:секунда по умолчанию)
     */
    private static final int keepAliveTime = 1;
    /**
     * Размер очереди
     * буфера
     */
    private static final int queueCapacity = 200;
    /**
     * Префикс имени
     * пула потоков
     */
    private static final String threadNamePrefix = "taskExecutor -";

    @Bean("taskExecutor") // Имя bean-компонента, по умолчанию это имя метода с первой буквой в нижнем регистре
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        // Стратегия обработки пула потоков для отклоненных задач
        // CallerRunsPolicy: вызывающий поток (поток, отправляющий задачу) обрабатывает задачу
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // Инициализация
        executor.initialize();
        return executor;
    }
}
