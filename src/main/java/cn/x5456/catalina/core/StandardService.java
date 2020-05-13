package cn.x5456.catalina.core;

import cn.x5456.catalina.*;
import cn.x5456.catalina.connector.Connector;
import cn.x5456.catalina.mapper.Mapper;
import cn.x5456.catalina.mapper.MapperListener;
import cn.x5456.catalina.util.LifecycleBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yujx
 * @date 2020/05/11 14:39
 */
public class StandardService extends LifecycleBase implements Service {

    /**
     * The name of this service.
     */
    private String name = null;

    /**
     * The <code>Server</code> that owns this Service, if any.
     */
    private Server server = null;

    /**
     * The set of Connectors associated with this Service.
     */
    protected List<Connector> connectors = new ArrayList<>();

    protected final List<Executor> executors = new ArrayList<>();

    private Engine engine = null;

    /**
     * Mapper.
     */
    protected final Mapper mapper = new Mapper();


    /**
     * Mapper listener.
     */
    protected final MapperListener mapperListener = new MapperListener(this);

    @Override
    protected void initInternal() {

        // 初始化 engine 容器
        if (engine != null) {
            engine.init();
        }

        // 初始化线程池
        for (Executor executor : executors) {
            executor.init();
        }

        // 初始化 mapperListener
        mapperListener.init();

        // 初始化连接器
        for (Connector connector : connectors) {
            connector.init();
        }
    }

    @Override
    protected void startInternal() {
        // 设置生命周期状态为【启动中】
        super.setState(LifecycleState.STARTING, null);

        // 启动容器
        if (engine != null) {
            engine.start();
        }

        // 启动线程执行器
        for (Executor executor : executors) {
            executor.start();
        }

        // 启动映射器监听器，主要做了以下2个事情：
        // 1、初始化Service与Host之间的映射（Service、Host、Context、Wrapper之间的联系存入映射器中）
        // 2、监听容器事件和生命周期事件，动态的更新Mapper中的信息
        mapperListener.start();

        // 启动我们定义的所有连接器
        for (Connector connector : connectors) {
            connector.start();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void addConnector(Connector connector) {
        connectors.add(connector);
    }

    @Override
    public Connector[] findConnectors() {
        return connectors.toArray(new Connector[0]);
    }

    @Override
    public void removeConnector(Connector connector) {
        connectors.remove(connector);
    }

    @Override
    public void addExecutor(Executor ex) {
        executors.add(ex);
    }

    @Override
    public Executor[] findExecutors() {
        return executors.toArray(new Executor[0]);
    }

    @Override
    public Executor getExecutor(String name) {
        for (Executor executor : executors) {
            if (executor.getName().equals(name)) {
                return executor;
            }
        }
        return null;
    }

    @Override
    public void removeExecutor(Executor ex) {
        executors.remove(ex);
    }

    public Engine getContainer() {
        return engine;
    }

    public void setContainer(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Mapper getMapper() {
        return mapper;
    }

}
