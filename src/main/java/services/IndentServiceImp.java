package services;

import dataBase.IndentDAO;
import dataBase.IndentDAOImp;
import pojo.Goods;
import pojo.Indent;

import java.util.List;

public class IndentServiceImp implements IndentService {

    @Override
    public boolean createIndent(Indent indent) {
        IndentDAO indentDAO = new IndentDAOImp();
        return indentDAO.createIndent(indent);
    }

    @Override
    public boolean setIndentZero(Long idUser) {
        IndentDAO indentDAO = new IndentDAOImp();
        return indentDAO.setIndentZero(idUser);
    }

    @Override
    public List<Goods> getCartList(Long idUser) {
        IndentDAO indentDAO = new IndentDAOImp();
        return indentDAO.getCartList(idUser);
    }

    @Override
    public Double getSum(Long idUser) {
        IndentDAO indentDAO = new IndentDAOImp();
        Object s = indentDAO.getSum(idUser);
        Double d = null;
        if (s == null) {
            d = 0.0;
        } else {
            d = (int) Math.round(indentDAO.getSum(idUser) * 100) / 100d;
        }
        return d;
    }
}