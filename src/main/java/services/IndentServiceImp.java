package services;

import dataBase.IndentDAO;
import dataBase.IndentDAOImp;
import pojo.Indent;

public class IndentServiceImp implements IndentService {
    IndentDAO indentDAO;

    @Override
    public boolean createIndent(Indent indent) {
        indentDAO = new IndentDAOImp();
        return indentDAO.createIndent(indent);
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
