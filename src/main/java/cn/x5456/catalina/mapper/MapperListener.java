package cn.x5456.catalina.mapper;

import cn.x5456.catalina.*;
import cn.x5456.catalina.util.LifecycleBase;

/**
 * @author yujx
 * @date 2020/05/11 15:17
 */
public class MapperListener extends LifecycleBase implements LifecycleListener {

    private final Service service;

    private final Mapper mapper;

    public MapperListener(Service service) {
        this.service = service;
        this.mapper = service.getMapper();
    }

    // 空方法
    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

        // 获取 engine 容器
        Engine engine = service.getContainer();

        // 寻找engine容器中默认的host，设置到 Mapper 中
        this.findDefaultHost();

        // 为engine容器和他所有的子容器添加ContainerListener和LifecycleListener（都是当前对象）
        // 目的是，当有变动的时候可以修改 Mapper 对象中的映射关系
        this.addListeners(engine);

        Container[] conHosts = engine.findChildren();
        for (Container conHost : conHosts) {
            Host host = (Host) conHost;
            if (!LifecycleState.NEW.equals(host.getState())) {
                // 注册当前获取到的host对象；目的是构建service中的mapper（映射器）
                this.registerHost(host);
            }
        }
    }

    private void findDefaultHost() {
        Engine engine = service.getContainer();
        String defaultHost = engine.getDefaultHost();

        // 检查是否真的有这个名字的 host
        for (Container container : engine.findChildren()) {
            if (container instanceof Host) {
                if (container.getName().equals(defaultHost)) {
                    mapper.setDefaultHostName(defaultHost);
                    return;
                }
            }
        }
    }

    private void addListeners(Container container) {
//        container.addContainerListener(this);
        container.addLifecycleListener(this);
        for (Container child : container.findChildren()) {
            this.addListeners(child);
        }
    }

    private void registerHost(Host host) {
        // TODO: 2020/5/11
    }

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        // TODO: 2020/5/11
    }
}
