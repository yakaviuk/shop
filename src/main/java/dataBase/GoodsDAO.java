package dataBase;

import pojo.Goods;

import java.util.List;

public interface GoodsDAO {
    List <Goods> findAll();
}