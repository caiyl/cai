package cai.test;

import cai.rpc.client.HelloWorldService;
import cai.rpc.client.HelloWorldServiceImpl;
import cai.rpc.client.RPCProxyClient;

/**
 * Created by caiyl on 2017/2/16.
 */
public class RpcTest {
    public static void main(String[] args) {
        HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) RPCProxyClient.getProxy(HelloWorldServiceImpl.class);
                 helloWorldService.sayHello("test");
             }
}
