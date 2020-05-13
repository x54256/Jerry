package cn.x5456.catalina.util;

import cn.x5456.catalina.Lifecycle;
import cn.x5456.catalina.LifecycleEvent;
import cn.x5456.catalina.LifecycleListener;
import cn.x5456.catalina.LifecycleState;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yujx
 * @date 2020/05/11 14:17
 */
public abstract class LifecycleBase implements Lifecycle {

    /**
     * 用于保存监听器实例
     */
    private final List<LifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();


    /**
     * 组件的生命周期状态，初始为 New
     */
    private volatile LifecycleState state = LifecycleState.NEW;

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycleListeners.add(listener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycleListeners.toArray(new LifecycleListener[0]);
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycleListeners.remove(listener);
    }

    @Override
    public void init() {

        // 修改当前生命周期状态，并触发事件
        this.setState(LifecycleState.INITIALIZING, null);

        // 调用抽象方法，子类实现
        this.initInternal();

        this.setState(LifecycleState.INITIALIZED, null);
    }

    protected abstract void initInternal();

    protected void setState(LifecycleState state, Object data) {
        this.state = state;
        String lifecycleEvent = state.getLifecycleEvent();
        if (lifecycleEvent != null) {
            this.fireLifecycleEvent(lifecycleEvent, data);
        }
    }

    private void fireLifecycleEvent(String type, Object data) {
        LifecycleEvent event = new LifecycleEvent(this, type, data);
        for (LifecycleListener listener : lifecycleListeners) {
            listener.lifecycleEvent(event);
        }
    }

    @Override
    public void start() {

        // 将生命周期状态设置为开始准备
        setState(LifecycleState.STARTING_PREP, null);

        // 开始子类定义的启动方法（Tomcat4中的start()方法）
        startInternal();
    }

    protected abstract void startInternal();

    @Override
    public void stop() {
        // TODO: 2020/5/11 触发事件，调用子类
    }

    @Override
    public void destroy() {
        // TODO: 2020/5/11 触发事件，调用子类
    }

    @Override
    public LifecycleState getState() {
        return state;
    }
}
