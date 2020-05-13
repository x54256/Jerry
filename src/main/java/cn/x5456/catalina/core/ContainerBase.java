package cn.x5456.catalina.core;

import cn.x5456.catalina.Container;
import cn.x5456.catalina.Pipeline;

/**
 * @author yujx
 * @date 2020/05/11 17:08
 */
public abstract class ContainerBase implements Container {

    private String name;

    private Container parent;

    protected final Pipeline pipeline = new StandardPipeline(this);

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Container getParent() {
        return null;
    }

    @Override
    public void setParent(Container container) {

    }

    @Override
    public void addChild(Container child) {

    }

    @Override
    public Container findChild(String name) {
        return null;
    }

    @Override
    public Container[] findChildren() {
        return new Container[0];
    }

    @Override
    public Pipeline getPipeline() {
        return null;
    }

    @Override
    public void backgroundProcess() {

    }
}
