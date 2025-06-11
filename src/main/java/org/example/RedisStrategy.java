package org.example;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisStrategy implements Strategy {
    private Jedis jedis;
    private String chanell;

    public RedisStrategy(String host, Integer port, String chanell) {
        this.jedis = new Jedis(host, port);
        this.chanell = chanell;
    }

    @Override
    public void output(List<DataModel> modelList) {
        for (DataModel model : modelList) {
            jedis.lpush(chanell, model.toString());
        }
    }

    public void close() {
        jedis.close();
    }
}
