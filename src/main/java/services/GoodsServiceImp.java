package services;

import dataBase.GoodsDAO;
import dataBase.GoodsDAOImp;
import pojo.Goods;
import java.util.List;

public class GoodsServiceImp implements GoodsService {
    GoodsDAO gdao = new GoodsDAOImp();

    @Override
    public List<Goods> findAll() {
        return gdao.findAll();
    }
}