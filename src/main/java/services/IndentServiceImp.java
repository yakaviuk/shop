package services;

import dataBase.IndentDAO;
import dataBase.IndentDAOImp;
import pojo.Indent;

public class IndentServiceImp implements IndentService {
    IndentDAO orderDAO;

    @Override
    public boolean createIndent(Indent indent) {
        orderDAO = new IndentDAOImp();
        return orderDAO.createIndent(indent);
    }

    @Override
    public boolean setIndentFalse(Long idIndent) {
        return false;
    }

    @Override
    public boolean setIndentTrue(Long idIndent) {
        return false;
    }
}
