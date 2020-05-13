package cn.x5456.catalina;

public interface Executor extends java.util.concurrent.Executor, Lifecycle {

    public String getName();
}