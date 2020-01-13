package dataBase;

import pojo.Goods;

import java.util.List;

public interface GoodsDAO {
    List <Goods> findAll(); // it is necessary to get full array with all goods
}
