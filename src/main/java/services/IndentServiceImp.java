package services;

import dataBase.GoodsDAO;
import dataBase.GoodsDAOImp;
import dataBase.IndentDAO;
import dataBase.IndentDAOImp;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Goods;
import pojo.Indent;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class IndentServiceImp implements IndentService {
    IndentDAO indentDAO;


    @Override
    public boolean createIndent(Indent indent) {
        indentDAO = new IndentDAOImp();
        return indentDAO.createIndent(indent);
    }

    @Override
    public boolean setIndentZero(Long idUser) {
//TODO
        return false;
    }
    @Override
    public List<Goods> getCartList (Long idUser) {
        indentDAO = new IndentDAOImp();
        System.out.println(indentDAO.getCartList(idUser));
        return  indentDAO.getCartList(idUser);
    }

}
