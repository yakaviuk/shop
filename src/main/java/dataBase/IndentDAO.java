package dataBase;

import pojo.Goods;
import pojo.Indent;

import java.util.List;

public interface IndentDAO {
    boolean createIndent (Indent indent);
    boolean updateIndent (Indent indent);
    Indent getIndent (Long idUser);
    List<Goods> getCartList (Long idUser);
    Double getSum (Long idUser);
     boolean setIndentZero(Long idUser);
}