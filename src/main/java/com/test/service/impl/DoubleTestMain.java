package com.test.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class DoubleTestMain {
	public static final String ROOT="/root-ktv";
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk=new ZooKeeper("localhost:2181",3000,new Watcher(){
			@Override
			public void process(WatchedEvent event) {
				System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());
			}
		});
		zk.create(ROOT,"root-k".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		zk.create(ROOT+"/hangzhou-k","hangzhou-k".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
		zk.create(ROOT+"/beijing-k","beijing-k".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
		zk.create(ROOT+"/beijing-k-1","beijing-k-1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		List<String> ktvs=zk.getChildren(ROOT,true);
		System.out.println(Arrays.toString(ktvs.toArray()));
		for(String node:ktvs){
			zk.delete(ROOT+"/"+node,-1);
		}
		zk.delete(ROOT,-1);
		zk.close();
	}
}
